package com.skilledservice.ClientService.dto.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.skilledservice.ClientService.data.constants.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class ViewAllAppointmentsResponse {
    @JsonProperty("appointments_id")
    Long Id;
    @JsonFormat(pattern = "dd-MMMM-yyyy 'at' hh:mm a")
    private LocalDateTime scheduleTime;
    private Category category;
    private BigDecimal amount;

}
