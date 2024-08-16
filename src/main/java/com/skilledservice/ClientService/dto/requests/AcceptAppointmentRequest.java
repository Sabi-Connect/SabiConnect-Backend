package com.skilledservice.ClientService.dto.requests;

import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AcceptAppointmentRequest {
    private Long appointmentId;
    private Long clientId;
    private AppointmentStatus status;
}
