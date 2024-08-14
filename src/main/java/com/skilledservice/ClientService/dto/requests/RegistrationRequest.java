package com.skilledservice.ClientService.dto.requests;

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
    private String houseNumber;
    private String street;
    private String area;

}
