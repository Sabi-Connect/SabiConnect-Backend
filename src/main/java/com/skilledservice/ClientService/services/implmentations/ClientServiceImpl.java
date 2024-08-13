package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.requests.UpdateAppointmentRequest;
import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.models.Appointment;
import com.skilledservice.ClientService.data.constants.Role;
import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.data.repository.AppointmentRepository;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.dto.responses.*;
import com.skilledservice.ClientService.services.ServiceUtils.AppointmentService;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AppointmentRepository appointmentRepository;
    private final ClientRepository userRepository;
    private final AddressRepository addressRepository;
    private final AppointmentService appointmentService;

    @Override
    public ClientRegistrationResponse registerClient(RegistrationRequest request) {

        Client user = new Client();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole(Role.CLIENT);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Address address = new Address();
        address= addressRepository.save(address);
        user.setAddress(address);
        user = userRepository.save(user);

        ClientRegistrationResponse response = new ClientRegistrationResponse();
        response.setClientId(user.getId());
        response.setMessage("registration successful");
        return response;

    }

    @Override
    public Long getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest) {
//      Client user = userRepository.findById(bookAppointmentRequest.getId())
//              .orElseThrow(() ->new UsernameNotFoundException("User not found"));
//      Appointment appointment =
//              appointmentService.bookAppointment(bookAppointmentRequest.getAmount());
//      appointment.setUserId(bookAppointmentRequest.getUserId());
//      appointmentService.save(appointment);
//      return modelMapper.map(appointment, BookAppointmentResponse.class);
        return null;
    }

    @Override
    public CancelAppointmentResponse cancelAppointment(Long id) {
        return appointmentService.cancelAppointment(id);
    }

    @Override
    public UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request) {
        return appointmentService.updateAppointment(request);
    }

    @Override
    public DeleteAppointmentResponse deleteAppointment(Long id) {
        return appointmentService.deleteAppointment(id);
    }

    @Override
    public List<ViewAllAppointmentsResponse> viewAllAppointment() {
        return appointmentService.viewAllAppointment();
    }

}

