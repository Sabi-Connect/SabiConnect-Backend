package com.skilledservice.ClientService.dto.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skilledservice.ClientService.data.constants.Category;
import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.models.SkilledWorker;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ConsultationResponse {
    private String message;
//    private String clientId;
    private String clientFullName;
//    private LocalDateTime timeCreated;
    private String skilledWorkerFullName;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime scheduleTime;
    private Category category;
}

