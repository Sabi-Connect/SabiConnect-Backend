package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.data.repository.SkilledWorkerRepository;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.services.ServiceUtils.SkilledWorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SkilledWorkerServiceImplTest {

    @Autowired
    private SkilledWorkerService skilledWorkerService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SkilledWorkerRepository skilledWorkerRepository;

    @Test
    public void testLogin(){
        RegistrationRequest request = new RegistrationRequest();
        request.setEmail("olodo1@gmail.com");
        request.setPassword("olodoolodo1");
        skilledWorkerService.registerSkilledWorker(request);

        SkilledWorker found = skilledWorkerRepository.findByEmail("olodo@gmail.com").orElseThrow();
        System.out.println(found.getPassword());

        System.out.println(passwordEncoder.matches(found.getPassword(), "olodoolodo1"));
    }
}