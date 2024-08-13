package com.skilledservice.ClientService.services.ServiceUtils;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.PostReviewRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.requests.UpdateAppointmentRequest;
import com.skilledservice.ClientService.dto.responses.*;

import java.util.List;

public interface ClientService {

    ClientRegistrationResponse registerClient(RegistrationRequest registerRequest);
    Long getNumberOfUsers();

    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest);

    CancelAppointmentResponse cancelAppointment(Long id);

    UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);

    DeleteAppointmentResponse deleteAppointment(Long id);

    List<ViewAllAppointmentsResponse> viewAllAppointment();

}
