package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.response.ClientRegistrationResponse;
import com.skilledservice.ClientService.models.Address;
import com.skilledservice.ClientService.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceTest {
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @Test
    public void registerClient() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("John");
        registrationRequest.setLastName("Doe");
        registrationRequest.setUsername("JohnDoe");
        registrationRequest.setPhoneNumber("123456789");
        registrationRequest.setEmail("john@doe.com");
        Address address = new Address();
        address.setStreet("Street");
        address.setArea("area");
        address.setHouseNumber("number");
        registrationRequest.setAddress(address);
        registrationRequest.setPassword("password");
        ClientRegistrationResponse response = clientServiceImpl.registerClient(registrationRequest);
        assertThat(response).isNotNull();
        assertThat(clientServiceImpl.getNumberOfUsers()).isEqualTo(1L);
    }
}
