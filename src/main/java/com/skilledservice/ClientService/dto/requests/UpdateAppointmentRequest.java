package com.skilledservice.ClientService.dto.requests;

import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class UpdateAppointmentRequest {
    private Long clientId;
    private BigDecimal amount;
    private LocalDateTime startTime;
    private AppointmentStatus status;

}
