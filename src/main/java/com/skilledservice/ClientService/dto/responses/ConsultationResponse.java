package com.skilledservice.ClientService.dto.responses;

import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.models.SkilledWorker;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConsultationResponse {
    private String message;
    private Client client;;
    private SkilledWorker skilledWorker;
}
