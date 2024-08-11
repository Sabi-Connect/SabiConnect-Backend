package com.skilledservice.ClientService.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class BookAppointmentRequest {
//    private Long clientId;
//    private LocalDateTime scheduleTime;
    private BigDecimal amount;



}
