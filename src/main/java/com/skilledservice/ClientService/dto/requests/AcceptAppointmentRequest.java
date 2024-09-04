package com.skilledservice.ClientService.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AcceptAppointmentRequest {
    private Long appointmentId;
    @JsonProperty("skilled_worker")
    private Long Id;
    private AppointmentStatus status;
}
