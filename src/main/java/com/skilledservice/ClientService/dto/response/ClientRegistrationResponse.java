package com.skilledservice.ClientService.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientRegistrationResponse {
    private Long clientId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
}
