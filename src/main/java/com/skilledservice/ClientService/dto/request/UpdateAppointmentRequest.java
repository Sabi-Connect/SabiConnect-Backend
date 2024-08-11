package com.skilledservice.ClientService.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.skilledservice.ClientService.models.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class UpdateAppointmentRequest {
    private Long appointmentId;
    private Long clientId;
    private Long userId;
    private String UserEmail;
    private String userPhoneNumber;
    private AppointmentStatus status;
    private LocalDate startTime;
    private BigDecimal amount;


}
