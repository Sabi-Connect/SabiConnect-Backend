package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.PostReviewRequest;
import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.response.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.models.Address;
import com.skilledservice.ClientService.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ReviewTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SkilledWorkerService skilledWorkerService;

    @Test
    public void postReviewAboutSkilledWorkerTest() {
        RegistrationRequest registrationRequest = getRegistrationRequest();
        SkilledWorkerRegistrationResponse response = skilledWorkerService.registerSkilledWorker(registrationRequest);
        assertThat(skilledWorkerService.getNumberOfUsers()).isEqualTo(1L);
        assertThat(response).isNotNull();



        PostReviewRequest postReview = new PostReviewRequest();


    }
    private RegistrationRequest getRegistrationRequest() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        Address address = new Address();
        address.setHouseNumber("312");
        address.setStreet("Herbert Macaulay Way");
        address.setArea("Yaba");
        registrationRequest.setFirstName("Fitzgerald");
        registrationRequest.setLastName("McDonald");
        registrationRequest.setEmail("fitzgerald@gmail.com");
        registrationRequest.setPassword("password");
        registrationRequest.setPhoneNumber("1234567890");
        address = addressRepository.save(address);
        registrationRequest.setAddress(address);
        return registrationRequest;
    }


}
