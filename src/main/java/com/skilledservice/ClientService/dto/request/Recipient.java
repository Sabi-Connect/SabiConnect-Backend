package com.skilledservice.ClientService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Recipient {
    private String name;
    private String email;
}
