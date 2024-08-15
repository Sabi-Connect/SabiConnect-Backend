//package com.skilledservice.ClientService.services;
//
//import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
//import com.skilledservice.ClientService.dto.responses.SkilledWorkerRegistrationResponse;
//import com.skilledservice.ClientService.data.repository.AddressRepository;
//import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@SpringBootTest
////@Sql(scripts = {"/db/data.sql"})
//public class SkilledWorkerServiceTest {
//    @Autowired
//    private SkilledWorkerService skilledWorkerService;
//    @Autowired
//    private AddressRepository addressRepository;
//
//
//    @Test
//    public void SkilledWorkerRegistrationTest() {
//        RegistrationRequest registrationRequest = getRegistrationRequest();
//        SkilledWorkerRegistrationResponse response = skilledWorkerService.registerSkilledWorker(registrationRequest);
//        assertThat(skilledWorkerService.getNumberOfUsers()).isEqualTo(1L);
//        assertThat(response).isNotNull();
//    }
//
//    private RegistrationRequest getRegistrationRequest() {
//        RegistrationRequest registrationRequest = new RegistrationRequest();
//        registrationRequest.setFirstName("Fitzgerald");
//        registrationRequest.setLastName("McDonald");
//        registrationRequest.setUsername("Fitz");
//        registrationRequest.setEmail("fitzgerald@gmail.com");
//        registrationRequest.setPassword("password");
//        registrationRequest.setPhoneNumber("1234567890");
//        registrationRequest.setHouseNumber("312");
//        registrationRequest.setStreet("Herbert Macaulay Way");
//        registrationRequest.setArea("Yaba");
//        return registrationRequest;
//    }
//
//}
