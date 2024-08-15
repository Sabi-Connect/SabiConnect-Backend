package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    public AddressServiceImpl(ModelMapper modelMapper, AddressRepository addressRepository) {
        this.modelMapper = modelMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(RegistrationRequest registrationRequest) {
        Address address = modelMapper.map(registrationRequest, Address.class);
        return addressRepository.save(address);
    }

}
