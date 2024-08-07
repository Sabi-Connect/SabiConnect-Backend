package com.skilledservice.ClientService.dto.request;

import com.skilledservice.ClientService.models.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Address address;
}
