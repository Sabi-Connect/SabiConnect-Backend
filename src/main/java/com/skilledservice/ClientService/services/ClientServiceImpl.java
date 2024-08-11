package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.response.ClientRegistrationResponse;
import com.skilledservice.ClientService.models.Address;
import com.skilledservice.ClientService.models.User;
import com.skilledservice.ClientService.repository.AddressRepository;
import com.skilledservice.ClientService.repository.AppointmentRepository;
import com.skilledservice.ClientService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public ClientRegistrationResponse registerClient(RegistrationRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Address address = new Address();
        address= addressRepository.save(address);
        user.setAddress(address);
        user = userRepository.save(user);
        var response = modelMapper.map(user, ClientRegistrationResponse.class);
        response.setMessage(" registered successfully");
        return response;

    }

    @Override
    public Long getNumberOfUsers() {
        return userRepository.count();
    }

}

