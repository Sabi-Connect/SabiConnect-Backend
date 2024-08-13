package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.ClientRegistrationResponse;
import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository userRepository;

    @Test
    public void registerClient() {
        RegistrationRequest registerClientRequest = new RegistrationRequest();
        registerClientRequest.setFirstName("John");
        registerClientRequest.setLastName("Doe");
        registerClientRequest.setUsername("JohnDoe");
        registerClientRequest.setPhoneNumber("123456789");
        registerClientRequest.setEmail("john@doe.com");
        Address address = new Address();
        address.setStreet("Street");
        address.setArea("area");
        address.setHouseNumber("number");
        registerClientRequest.setAddress(address);
        registerClientRequest.setPassword("password");
        ClientRegistrationResponse response = clientService.registerClient(registerClientRequest);
        assertThat(response).isNotNull();
        assertThat(clientService.getNumberOfUsers()).isEqualTo(2L);
    }
}
