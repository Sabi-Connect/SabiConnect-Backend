package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.dto.requests.*;
import com.skilledservice.ClientService.dto.responses.*;

import java.util.List;

public interface ClientService {

    ClientRegistrationResponse registerClient(RegistrationRequest registerRequest);


    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest);

    CancelAppointmentResponse cancelAppointment(Long id, CancelAppointmentRequest cancelAppointmentRequest);

    UpdateAppointmentResponse updateAppointment(Long Id,UpdateAppointmentRequest request);

    DeleteAppointmentResponse deleteAppointment(Long id, DeleteAppointmentRequest request);

    List<ViewAllAppointmentsResponse> viewAllAppointment(Long id);

    Client findById(Long clientId);
}
