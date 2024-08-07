package com.skilledservice.ClientService.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CancelAppointmentResponse {
    private String message;
    private Long appointmentId;
}
