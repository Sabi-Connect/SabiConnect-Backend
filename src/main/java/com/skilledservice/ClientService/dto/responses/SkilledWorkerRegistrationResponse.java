package com.skilledservice.ClientService.dto.responses;

import com.skilledservice.ClientService.data.models.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkilledWorkerRegistrationResponse {
    private Long skilledWorkerId;
    private String fullName;
    private String email;
    private String password;
    private String message;

}
