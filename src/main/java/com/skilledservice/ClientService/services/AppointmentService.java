package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.request.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.response.*;
import com.skilledservice.ClientService.models.Appointment;

import java.math.BigDecimal;
import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(BookAppointmentRequest bookAppointmentRequest);
    CancelAppointmentResponse cancelAppointment(Long id);
    UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
    DeleteAppointmentResponse deleteAppointment(Long id);
    List<ViewAllAppointmentsResponse> viewAllAppointment();

    void save(Appointment appointment);
}
