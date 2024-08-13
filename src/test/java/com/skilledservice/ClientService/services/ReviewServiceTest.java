package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.PostReviewRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.ClientRegistrationResponse;
import com.skilledservice.ClientService.dto.responses.PostReviewResponse;
import com.skilledservice.ClientService.dto.responses.SkilledWorkerRegistrationResponse;
import com.skilledservice.ClientService.exceptions.ProjectException;
import com.skilledservice.ClientService.data.models.Address;
import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.data.repository.ReviewRepository;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import com.skilledservice.ClientService.services.ServiceUtils.ReviewService;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ReviewServiceTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SkilledWorkerService skilledWorkerService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ClientRepository userRepository;

    @Test
    public void postReviewForSkilledWorkerTest() {
        RegistrationRequest registrationRequest = getRegisterSkilledWorkerRequest();
        SkilledWorkerRegistrationResponse response = skilledWorkerService.registerSkilledWorker(registrationRequest);
        Long skilledWorkerId = response.getSkilledWorkerId();
        assertThat(skilledWorkerId).isNotNull();
        System.out.println(skilledWorkerId);

        RegistrationRequest registerClientRequest = getRegisterClientRequest();
        ClientRegistrationResponse clientResponse = clientService.registerClient(registerClientRequest);
        Long clientId = clientResponse.getClientId();
        assertThat(clientId).isNotNull();
        System.out.println(clientId);
        assertThat(clientService.getNumberOfUsers()).isEqualTo(2L);

        PostReviewRequest postReviewRequest = new PostReviewRequest();
        Client skilledWorker = userRepository.findById(skilledWorkerId)
                .orElseThrow(() -> new ProjectException("user not found"));
        postReviewRequest.setSkilledWorker(skilledWorker);
        postReviewRequest.setReview("impressive work ethic");

        PostReviewResponse reviewResponse = reviewService.addReview(postReviewRequest);

        assertThat(reviewResponse).isNotNull();
        assertThat(reviewResponse.getReview()).isEqualTo("impressive work ethic");
        // Assuming reviewResponse.getReviewerId() is used to find the review
        var review = reviewRepository.findById(reviewResponse.getPostId())
                .orElseThrow(() -> new ProjectException("Review not found"));
        assertThat(review.getReview()).isEqualTo("impressive work ethic");
        assertThat(reviewRepository.count()).isEqualTo(1L);

    }


    private static RegistrationRequest getRegisterClientRequest() {
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
        return registerClientRequest;
    }

    private RegistrationRequest getRegisterSkilledWorkerRequest() {
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
