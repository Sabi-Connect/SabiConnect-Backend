package com.skilledservice.ClientService.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientRegistrationRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String Address;
}
