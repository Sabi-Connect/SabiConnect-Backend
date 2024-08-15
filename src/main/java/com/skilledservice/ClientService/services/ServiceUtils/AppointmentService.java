package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.responses.UpdateAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.ViewAllAppointmentsResponse;
import com.skilledservice.ClientService.data.models.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment bookAppointment(BookAppointmentRequest bookAppointmentRequest);
    void cancelAppointment(Long id);
    UpdateAppointmentResponse updateAppointment(Long Id,UpdateAppointmentRequest request);
    void deleteAppointment(Long id);
    List<ViewAllAppointmentsResponse> viewAllAppointment();

    Optional<Appointment> findAppointmentById(Long id);

    void save(Appointment appointment);
}
