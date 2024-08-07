package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.request.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.response.BookAppointmentResponse;
import com.skilledservice.ClientService.dto.response.CancelAppointmentResponse;
import com.skilledservice.ClientService.dto.response.UpdateAppointmentResponse;

public interface AppointmentService {
    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest);
    CancelAppointmentResponse cancelAppointment(Long id);
    UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
}
