package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.data.repository.SkilledWorkerRepository;
import com.skilledservice.ClientService.dto.requests.*;
import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.models.Appointment;
import com.skilledservice.ClientService.data.constants.Role;
import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.dto.responses.*;
import com.skilledservice.ClientService.exceptions.AppointmentNotFoundException;
import com.skilledservice.ClientService.exceptions.InvalidEmailFoundException;
import com.skilledservice.ClientService.exceptions.InvalidPasswordException;
import com.skilledservice.ClientService.exceptions.UserNotFoundException;
import com.skilledservice.ClientService.services.ServiceUtils.AppointmentService;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final AppointmentService appointmentService;

    @Override
    public ClientRegistrationResponse registerClient(RegistrationRequest request) {

        validateEmail(request.getEmail());
        validatePassword(request.getPassword());

        Client user = new Client();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Address address = new Address();
        address = addressRepository.save(address);
        user.setAddress(address);
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
            throw new InvalidPasswordException("Password does not meet complexity requirements");
        }
        if (!password.matches("[a-zA-Z0-9]*")) {
            throw new InvalidPasswordException("Password must be alphanumeric");
        }
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }
    }


}

