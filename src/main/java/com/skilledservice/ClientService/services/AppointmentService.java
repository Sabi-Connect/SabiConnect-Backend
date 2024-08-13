package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.AddAppointmentRequest;
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
     Appointment addAppointment(AddAppointmentRequest request);
     List<Appointment> getAllAppointments();

     List<Appointment>getAllAppointmentsFor(Long id);

    void save(Appointment appointment);


}
