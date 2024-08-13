package com.skilledservice.ClientService.dto.responses;

import com.skilledservice.ClientService.data.models.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponse {
    private String status;
    private String message;
    private Data data;


}
