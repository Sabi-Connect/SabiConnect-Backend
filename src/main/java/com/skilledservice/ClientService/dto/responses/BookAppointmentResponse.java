package com.skilledservice.ClientService.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class BookAppointmentResponse {
    @JsonProperty("appointment_Id")
    private Long Id;
    private BigDecimal amount;
    private LocalDateTime scheduleTime;
    private AppointmentStatus status;
    private String message;
}
