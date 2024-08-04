package com.skilledservice.ClientService.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateClientResponse {
    private String clientId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String password;
}
