package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.request.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.response.*;

import java.util.List;

public interface AppointmentService {
    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest);
    CancelAppointmentResponse cancelAppointment(Long id);
    UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
    DeleteAppointmentResponse deleteAppointment(Long id);
    List<ViewAllAppointmentsResponse> viewAllAppointment();
}
