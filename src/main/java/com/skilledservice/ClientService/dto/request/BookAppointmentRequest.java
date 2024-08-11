package com.skilledservice.ClientService.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("Client_id")
    private Long UserId;
    private  Long Id;
    private BigDecimal amount;



}
