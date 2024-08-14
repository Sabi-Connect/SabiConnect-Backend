package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.ClientRegistrationResponse;
import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Sql(scripts = {"/db/data.sql"})
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
        registerClientRequest.setPassword("password");
        registerClientRequest.setHouseNumber("1");
        registerClientRequest.setStreet("Herbert Maccaulay way");
        registerClientRequest.setArea("Yaba");
        ClientRegistrationResponse response = clientService.registerClient(registerClientRequest);
        assertThat(response).isNotNull();
        assertThat(clientService.getNumberOfUsers()).isEqualTo(1L);
    }
}
