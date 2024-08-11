package com.skilledservice.ClientService.dto.request;

import com.skilledservice.ClientService.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddAppointmentRequest {
    private User userId;
}
