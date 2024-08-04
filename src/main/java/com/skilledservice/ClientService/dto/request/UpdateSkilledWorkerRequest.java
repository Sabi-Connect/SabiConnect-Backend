package com.skilledservice.ClientService.dto.request;

import com.skilledservice.ClientService.models.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateSkilledWorkerRequest {
    private String skilledWorkerId;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;
    private Address address;
    private String password;
}
