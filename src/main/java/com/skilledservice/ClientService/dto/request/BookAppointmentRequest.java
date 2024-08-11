package com.skilledservice.ClientService.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skilledservice.ClientService.models.Category;
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
    private String status;
    private LocalDate startTime;
    private Category category;
    private BigDecimal amount;



}
