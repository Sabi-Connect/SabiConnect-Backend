package com.skilledservice.ClientService.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skilledservice.ClientService.models.AppointmentStatus;
import com.skilledservice.ClientService.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class BookAppointmentRequest {
//    private Long clientId;
//    private LocalDateTime scheduleTime;
    @JsonProperty("skilledWorker_id")
    private Long skilledWorkerId;
    private AppointmentStatus status;
    private LocalDateTime scheduleTime;
    private Category category;
    private BigDecimal amount;



}
