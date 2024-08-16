package com.skilledservice.ClientService.dto.responses;

import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AcceptAppointmentResponse {
    private Long clientId;
    private Long appointmentId;
    private AppointmentStatus status;
}
