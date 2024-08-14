package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.dto.requests.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.responses.CancelAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.DeleteAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.UpdateAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.ViewAllAppointmentsResponse;
import com.skilledservice.ClientService.data.models.Appointment;

import java.math.BigDecimal;
import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(BigDecimal bookAppointmentRequest);
    CancelAppointmentResponse cancelAppointment(Long id);
    UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
    DeleteAppointmentResponse deleteAppointment(Long id);
    List<ViewAllAppointmentsResponse> viewAllAppointment();
    void save(Appointment appointment);

}
