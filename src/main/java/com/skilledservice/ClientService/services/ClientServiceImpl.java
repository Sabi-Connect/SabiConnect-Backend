package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.request.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.response.*;
import com.skilledservice.ClientService.models.Address;
import com.skilledservice.ClientService.models.Appointment;
import com.skilledservice.ClientService.models.User;
import com.skilledservice.ClientService.repository.AppointmentRepository;
import com.skilledservice.ClientService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private  final AppointmentService appointmentService;

    @Override
    public ClientRegistrationResponse registerClient(RegistrationRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user = userRepository.save(user);

        var response = modelMapper.map(user, ClientRegistrationResponse.class);
        response.setMessage(" registered successfully");
        return response;

    }

    @Override
    public Long getNumberOfUsers() {
        return null;
    }

    @Override
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest) {
      User user = userRepository.findById(bookAppointmentRequest.getId())
              .orElseThrow(() ->new UsernameNotFoundException("User not found"));
      Appointment appointment =
              appointmentService.bookAppointment(bookAppointmentRequest);
      appointment.setUser(user);

      User skilledWorker = userRepository.findById(bookAppointmentRequest.getId())
              .orElseThrow(() ->new UsernameNotFoundException("User not found"));
            skilledWorker.getAppointments().add(appointment);
      appointmentService.save(appointment);
      BookAppointmentResponse response=
              modelMapper.map(appointment, BookAppointmentResponse.class);
      response.setMessage("Appointment booked successfully");
      return response;

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

