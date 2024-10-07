package com.skilledservice.ClientService.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skilledservice.ClientService.data.constants.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultationRequest {
    private String skilledWorkerFullName;
    private String clientId;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime scheduleTime;
    private Category category;
}
