package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.dto.requests.*;
import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.models.Appointment;
import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.dto.responses.*;
import com.skilledservice.ClientService.exceptions.*;
import com.skilledservice.ClientService.services.ServiceUtils.AppointmentService;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import com.skilledservice.ClientService.utils.JwtUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final SkilledWorkerService skilledWorkerService;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private AppointmentService appointmentService;

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public ClientRegistrationResponse registerClient(RegistrationRequest request) {

        validateEmail(request.getEmail());
        validatePassword(request.getPassword());

        Client user = new Client();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user = clientRepository.save(user);

        ClientRegistrationResponse response = new ClientRegistrationResponse();
        response.setClientId(user.getId());
        response.setMessage("registration successful");
        return response;

    }


    @Override
    @Transactional
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest) {
        Client client = clientRepository.findById(bookAppointmentRequest.getClientId())
                  .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Appointment appointment =
                appointmentService.bookAppointment(bookAppointmentRequest);
        appointment.setClient(client);
        client.getAppointment().add(appointment);
        appointmentService.save(appointment);

        Long skilledWorkerId = bookAppointmentRequest.getSkilledWorkerId();
        SkilledWorker skilledWorker = skilledWorkerService.findById(skilledWorkerId);
        appointment.setSkilledWorker(skilledWorker);
        skilledWorker.getAppointment().add(appointment);
        appointmentService.save(appointment);

        BookAppointmentResponse response =
                modelMapper.map(appointment, BookAppointmentResponse.class);
        response.setMessage("Appointment booked successfully");
        return response;


    }

    @Override
    @Transactional
    public CancelAppointmentResponse cancelAppointment(Long id, CancelAppointmentRequest request){
        Client client = clientRepository.findById(request.getId())
                .orElseThrow(()->new UserNotFoundException("User not found"));
        Optional<Appointment> appointment = Optional.ofNullable((appointmentService.findAppointmentById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"))));
        appointmentService.cancelAppointment(appointment.get().getId());
        client.getAppointment().remove(appointment.get());
        clientRepository.save(client);

        CancelAppointmentResponse response = new CancelAppointmentResponse();
        response.setMessage("Appointment cancelled successfully");
        return response;
    }

    @Override
    @Transactional
    public UpdateAppointmentResponse updateAppointment(Long Id,UpdateAppointmentRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Optional<Appointment> appointment = appointmentService.findAppointmentById(Id);
        appointment.ifPresent(value -> client.getAppointment().add(value));

        UpdateAppointmentResponse response = modelMapper.map(appointment,UpdateAppointmentResponse.class);
        response.setMessage("Appointment updated successfully");
        return response;
    }

    @Override
    @Transactional
    public DeleteAppointmentResponse deleteAppointment(Long id, DeleteAppointmentRequest request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not found"));
        var appointment = appointmentService.findAppointmentById(request.getId());
        appointmentService.deleteAppointment(appointment.get().getId());
        client.getAppointment().remove(appointment);
        DeleteAppointmentResponse response = new DeleteAppointmentResponse();
         response.setMessage("Appointment  deleted successfully");
         return response;
    }

    @Override
    public List<ViewAllAppointmentsResponse> viewAllAppointment(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not found"));
        List<Appointment> appointments = client.getAppointment();
        return appointments.stream()
                .map(appointment -> modelMapper
                        .map(appointment, ViewAllAppointmentsResponse.class)).toList();
    }
    private void validateEmail(String email) {
        if (!email.matches( "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailFoundException("Invalid Email");
        }
    }
    private static  void validatePassword(String password){
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must contain at least 8 characters");
        }
        if (!password.matches("[a-zA-Z0-9]*")) {
            throw new InvalidPasswordException("Password must be alphanumeric");
        }
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }
    }

    @Override
    public Client findById(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(()-> new SabiConnectException("client not found"));
    }

    @Override
    public Long getNumberOfUsers() {
        return clientRepository.count();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        return checkLoginDetail(email, password);
    }

    private LoginResponse checkLoginDetail(String email, String password) {
        Optional<Client> foundClient = clientRepository.findByEmail(email);
        if (foundClient.isPresent()){
            Client client = foundClient.get();
            if (client.getPassword().equals(password)) {
                return loginResponseMapper(client);
            } else {
                throw new SabiConnectException("Invalid username or password");
            }
        } else {
            throw new SabiConnectException("Invalid username or password");
        }
    }

    private LoginResponse loginResponseMapper(Client client) {
        LoginResponse loginResponse = new LoginResponse();
        String accessToken = JwtUtils.generateAccessToken(client.getId());
        BeanUtils.copyProperties(client, loginResponse);
        loginResponse.setJwtToken(accessToken);
        loginResponse.setMessage("Login Successful");

        return loginResponse;
    }

    @Override
    public UpdateClientResponse updateClientProfile(UpdateClientRequest updateRequest) {
        if (updateRequest.getClientId() == null) throw new UserNotFoundException("client ID must not be null");

        Client foundClient = clientRepository.findById(updateRequest.getClientId())
                .orElseThrow(()-> new UserNotFoundException("User not found"));

        foundClient.setPassword(updateRequest.getPassword());
        foundClient.setUsername(updateRequest.getUsername());
        foundClient.setPhoneNumber(updateRequest.getPhoneNumber());
        Address address = new Address();
        address.setHouseNumber(updateRequest.getHouseNumber());
        address.setStreet(updateRequest.getStreet());
        address.setArea(updateRequest.getArea());
        foundClient.setAddress(address);
        addressRepository.save(address);

        UpdateClientResponse response = new UpdateClientResponse();
        response.setClientId(updateRequest.getClientId());
        response.setUsername(updateRequest.getUsername());
        response.setPassword(updateRequest.getPassword());
        response.setPassword(updateRequest.getPassword());
        response.setHouseNumber(updateRequest.getHouseNumber());
        response.setStreet(updateRequest.getStreet());
        response.setArea(updateRequest.getArea());

        return response;
    }


}

