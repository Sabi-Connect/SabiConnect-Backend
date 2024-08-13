package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Sql(scripts = {"/db/data.sql"})
public class SkilledWorkerServiceTest {
    @Autowired
    private SkilledWorkerService skilledWorkerService;
    @Autowired
    private AddressRepository addressRepository;


    @Test
    public void SkilledWorkerRegistrationTest() {
        RegistrationRequest registrationRequest = getRegistrationRequest();
        SkilledWorkerRegistrationResponse response = skilledWorkerService.registerSkilledWorker(registrationRequest);
        assertThat(skilledWorkerService.getNumberOfUsers()).isEqualTo(1L);
//        assertThat(skilledWorkerRepository).isNotNull();
        assertThat(response).isNotNull();
    }

    private RegistrationRequest getRegistrationRequest() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        Address address = new Address();
        address.setHouseNumber("312");
        address.setStreet("Herbert Macaulay Way");
        address.setArea("Yaba");
        registrationRequest.setFirstName("Fitzgerald");
        registrationRequest.setLastName("McDonald");
        registrationRequest.setUsername("Fitz");
        registrationRequest.setEmail("fitzgerald@gmail.com");
        registrationRequest.setPassword("password");
        registrationRequest.setPhoneNumber("1234567890");
        address = addressRepository.save(address);
        registrationRequest.setAddress(address);
        return registrationRequest;
    }

}
