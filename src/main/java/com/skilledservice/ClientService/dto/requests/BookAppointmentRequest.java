package com.skilledservice.ClientService.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import com.skilledservice.ClientService.data.constants.Category;
import com.skilledservice.ClientService.data.models.Client;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
public class BookAppointmentRequest {

    private Long clientId;
    private AppointmentStatus status;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime scheduleTime;
    private Category category;

}
