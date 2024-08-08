package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.request.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.response.*;

import java.util.List;

public interface ClientService {
    ClientRegistrationResponse registerClient(RegistrationRequest registerRequest);

    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest);
    CancelAppointmentResponse cancelAppointment(Long id);
    UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
    DeleteAppointmentResponse deleteAppointment(Long id);
    List<ViewAllAppointmentsResponse> viewAllAppointment();
}
