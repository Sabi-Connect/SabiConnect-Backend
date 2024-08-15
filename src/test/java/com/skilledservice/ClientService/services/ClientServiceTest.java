package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import com.skilledservice.ClientService.data.constants.Category;
import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.data.repository.AppointmentRepository;
import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.responses.ClientRegistrationResponse;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.skilledservice.ClientService.data.constants.AppointmentStatus.CANCELLED;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Sql(scripts = "/db/data.sql")
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public void setUp() {
      appointmentRepository.deleteAll();
    }
    @Test
    public void registerClient() {
        RegistrationRequest registerClientRequest = new RegistrationRequest();
        registerClientRequest.setFirstName("John");
        registerClientRequest.setLastName("Doe");
        registerClientRequest.setUsername("JohnDoe");
        registerClientRequest.setPhoneNumber("123456789");
        registerClientRequest.setEmail("john@doe.com");
        registerClientRequest.setStreet("Street");
        registerClientRequest.setArea("area");
        registerClientRequest.setHouseNumber("number");
        registerClientRequest.setPassword("password");
        ClientRegistrationResponse response = clientService.registerClient(registerClientRequest);
        assertThat(response).isNotNull();
//        assertThat(clientService.getNumberOfUsers()).isEqualTo(2L);
    }
    @Test
    public void testThatClientCan_bookAppointmentTest() {
        BookAppointmentRequest request = new BookAppointmentRequest();
        request.setClientId(2L);
        request.setCategory(Category.ELECTRICAL);
        request.setStatus(AppointmentStatus.SCHEDULED);
        request.setScheduleTime(java.time.LocalDateTime.now().plusDays(6));
        request.setSkilledWorkerId(204L);
        clientService.bookAppointment(request);
        assertThat(clientRepository.findById(2L).get()
                .getAppointment().size()).isEqualTo(1);

    }

    @Test
    public void testThatClientCan_cancelAppointmentTest() {
        BookAppointmentRequest request = new BookAppointmentRequest();
        request.setClientId(3L);
        request.setCategory(Category.ELECTRICAL);
        request.setStatus(AppointmentStatus.SCHEDULED);
        request.setScheduleTime(java.time.LocalDateTime.now().plusDays(6));
        request.setSkilledWorkerId(204L);
        clientService.bookAppointment(request);
        clientService.cancelAppointment(1L);
        Client client = clientRepository.findById(3L).orElseThrow();
        assertThat(client.getAppointment().size()).isEqualTo(1);
        assertThat(client.getAppointment().getFirst().getStatus()).isEqualTo(CANCELLED);
    }
    @Test
    public void testThatClientCanDeleteAppointment(){
        BookAppointmentRequest request = new BookAppointmentRequest();
        request.setClientId(2L);
        request.setCategory(Category.ELECTRICAL);
        request.setStatus(AppointmentStatus.SCHEDULED);
        request.setScheduleTime(java.time.LocalDateTime.now().plusDays(6));
        request.setSkilledWorkerId(202L);
        clientService.bookAppointment(request);
        assertThat(clientRepository.findById(2L).get()
                .getAppointment().size()).isEqualTo(1);
//        clientService.deleteAppointment(1L);
//        Client client = clientRepository.findById(2L).orElseThrow();
//        assertThat(client.getAppointment().size()).isEqualTo(0);



    }
}
