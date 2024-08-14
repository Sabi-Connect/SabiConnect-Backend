package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.PostReviewRequest;
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
    private final PasswordEncoder passwordEncoder;
    private final AppointmentService appointmentService;
    private final AddressService addressService;
    private final ClientRepository clientRepository;

    @Override
    public ClientRegistrationResponse registerClient(RegistrationRequest request) {

        Client user = new Client();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Address address = addressService.createAddress(request);
        user.setAddress(address);
        user = clientRepository.save(user);

        ClientRegistrationResponse response = new ClientRegistrationResponse();
        response.setClientId(user.getId());
        response.setMessage("registration successful");
        return response;

    }

    @Override
    public Long getNumberOfUsers() {
        return clientRepository.count();
    }

    @Override
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest) {

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

