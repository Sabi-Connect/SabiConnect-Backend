package com.skilledservice.ClientService.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultationRequest {
    private Long clientId;
    private Long workerId;
    private String details;
}
