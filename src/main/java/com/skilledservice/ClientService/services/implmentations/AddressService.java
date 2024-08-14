package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;

public interface AddressService {
    Address createAddress(RegistrationRequest registrationRequest);
}
