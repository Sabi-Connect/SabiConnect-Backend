package com.skilledservice.ClientService.dto.response;

import com.skilledservice.ClientService.models.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateSkilledWorkerResponse {
    private String skilledWorkerId;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;
    private Address address;
    private String password;

}
