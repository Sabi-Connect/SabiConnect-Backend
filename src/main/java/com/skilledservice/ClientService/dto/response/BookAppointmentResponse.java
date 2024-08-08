package com.skilledservice.ClientService.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class BookAppointmentResponse {

    private Long appointmentId;
    private BigDecimal amount;
    private LocalDateTime startTime;
    private String message;
}
