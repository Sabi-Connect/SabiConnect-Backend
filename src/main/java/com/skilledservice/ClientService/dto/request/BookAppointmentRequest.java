package com.skilledservice.ClientService.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skilledservice.ClientService.models.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class BookAppointmentRequest {

    private Long userId;
    private String UserEmail;
    private String userPhoneNumber;
    private AppointmentStatus status;
    private LocalDate startTime;
    private BigDecimal amount;



}
