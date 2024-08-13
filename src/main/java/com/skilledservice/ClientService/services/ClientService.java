package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.request.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.response.*;
import com.skilledservice.ClientService.models.User;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientRegistrationResponse registerClient(RegistrationRequest registerRequest);
    Optional<User> findById(Long id);
    Long getNumberOfUsers();

    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest);
    CancelAppointmentResponse cancelAppointment(Long id);
    UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
    DeleteAppointmentResponse deleteAppointment(Long id);
    List<ViewAllAppointmentsResponse> viewAllAppointment();


}
