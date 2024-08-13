package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.request.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.request.RegistrationRequest;
import com.skilledservice.ClientService.dto.response.BookAppointmentResponse;
import com.skilledservice.ClientService.dto.response.ClientRegistrationResponse;
import com.skilledservice.ClientService.models.Address;
import com.skilledservice.ClientService.models.AppointmentStatus;
import com.skilledservice.ClientService.models.Category;
import com.skilledservice.ClientService.models.User;
import com.skilledservice.ClientService.repository.AppointmentRepository;
import com.skilledservice.ClientService.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class ClientServiceTest {
    @Autowired
    private ClientServiceImpl clientServiceImpl;
    @Autowired
    private AppointmentServiceImpl appointmentServiceImpl;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public  void clearAll(){
        appointmentRepository.deleteAll();

    }

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

       // assertThat(clientServiceImpl.getNumberOfUsers()).isEqualTo(1L);
    }
    @Test
    public void bookingAppointmentTest(){
        BookAppointmentRequest request = new BookAppointmentRequest();
        request.setId(100L);
        request.setCategory(Category.FASHION);
        request.setAmount(BigDecimal.valueOf(10000));
        request.setStatus(AppointmentStatus.WAITING);
        request.setStartTime(LocalDateTime.now().plusDays(24));
        BookAppointmentResponse response = clientServiceImpl.bookAppointment(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage().contains("Appointment booked successfully"));
       //        assertThat(response.getAppointmentId()).isNotNull();
        assertEquals(3, appointmentServiceImpl.getAllAppointments().size());


    }

}
