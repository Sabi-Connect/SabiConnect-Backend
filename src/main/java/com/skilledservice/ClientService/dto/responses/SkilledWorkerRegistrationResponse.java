package com.skilledservice.ClientService.dto.responses;

import com.skilledservice.ClientService.data.models.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkilledWorkerRegistrationResponse {
    private Long skilledWorkerId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Address address;
    private String message;
}
