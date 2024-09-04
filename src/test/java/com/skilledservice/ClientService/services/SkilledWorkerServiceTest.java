package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.requests.UpdateSkilledWorkerRequest;
import com.skilledservice.ClientService.dto.responses.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.dto.responses.UpdateSkilledWorkerResponse;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

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
        assertThat(response).isNotNull();
    }

    private RegistrationRequest getRegistrationRequest() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFullName("Fitzgerald McDonald");
        registrationRequest.setEmail("fitzgerald@gmail.com");
        registrationRequest.setPassword("password1");

        return registrationRequest;
    }

    @Test
    public void UpdateSkilledWorkerTest() {
//        SkilledWorker skilledWorker = new SkilledWorker();
        UpdateSkilledWorkerRequest request = new UpdateSkilledWorkerRequest();
        RegistrationRequest registrationRequest = getRegistrationRequest();
        SkilledWorkerRegistrationResponse response = skilledWorkerService.registerSkilledWorker(registrationRequest);


        request.setSkilledWorkerId(response.getSkilledWorkerId());
        request.setPassword("password2");
        request.setPhoneNumber("1234567891");
        request.setUsername("Fitty");
        request.setHouseNumber("111");
        request.setStreet("Street 1");
        request.setArea("Iwaya");
        UpdateSkilledWorkerResponse response1 = skilledWorkerService.updateSkilledWorkerProfile(request);
        assertThat(response1).isNotNull();
        assertThat(response1.getSkilledWorkerId()).isEqualTo(response.getSkilledWorkerId());

    }

}
