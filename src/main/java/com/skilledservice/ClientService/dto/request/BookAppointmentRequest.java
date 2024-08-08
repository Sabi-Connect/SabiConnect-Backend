package com.skilledservice.ClientService.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BookAppointmentRequest {
    @JsonProperty("Client_id")
    private Long UserId;
    private  Long Id;
    private BigDecimal amount;



}
