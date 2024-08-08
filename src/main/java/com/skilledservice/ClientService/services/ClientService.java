package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.response.ClientRegistrationResponse;

public interface ClientService {
    ClientRegistrationResponse registerClient(RegistrationRequest registerRequest);
}
