package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import com.skilledservice.ClientService.data.constants.Category;
import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.repository.AddressRepository;
import com.skilledservice.ClientService.data.repository.AppointmentRepository;
import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.RegistrationRequest;
import com.skilledservice.ClientService.dto.requests.UpdateClientRequest;
import com.skilledservice.ClientService.dto.responses.ClientRegistrationResponse;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.dto.responses.UpdateClientResponse;
import com.skilledservice.ClientService.dto.responses.UpdateSkilledWorkerResponse;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.skilledservice.ClientService.data.constants.AppointmentStatus.CANCELLED;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
//@Sql(scripts = "/db/data.sql")
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
        RegistrationRequest registerClientRequest = getRegistrationRequest();
        ClientRegistrationResponse response = clientService.registerClient(registerClientRequest);
        assertThat(response).isNotNull();
        assertThat(clientService.getNumberOfUsers()).isEqualTo(1L);

    }

    private static @NotNull RegistrationRequest getRegistrationRequest() {
        RegistrationRequest registerClientRequest = new RegistrationRequest();
        registerClientRequest.setFullName("John Doe");
        registerClientRequest.setEmail("john@doe.com");
        registerClientRequest.setPassword("password1");
        return registerClientRequest;
    }

    @Test
    public void updateUserProfileTest() {
        UpdateClientRequest updateRequest = new UpdateClientRequest();
        RegistrationRequest registerClientRequest = getRegistrationRequest();
        ClientRegistrationResponse response = clientService.registerClient(registerClientRequest);
        assertThat(response).isNotNull();
        assertThat(clientService.getNumberOfUsers()).isEqualTo(1L);

        updateRequest.setClientId(response.getClientId());
        updateRequest.setUsername("Jdoe");
        updateRequest.setPassword("password1");
        updateRequest.setHouseNumber("312");
        updateRequest.setStreet("Herbert Macaulay way");
        updateRequest.setArea("Yaba");
        UpdateClientResponse updateResponse = clientService.updateClientProfile(updateRequest);
        assertThat(updateResponse).isNotNull();
        assertThat(clientService.getNumberOfUsers()).isEqualTo(1L);
        assertThat(updateResponse.getClientId()).isEqualTo(response.getClientId());

    }

//    @Test
//    public void testThatClientCan_bookAppointmentTest() {
//        BookAppointmentRequest request = new BookAppointmentRequest();
//        request.setClientId(2L);
//        request.setCategory(Category.ELECTRICAL);
//        request.setStatus(AppointmentStatus.SCHEDULED);
//        request.setScheduleTime(java.time.LocalDateTime.now().plusDays(6));
//        request.setSkilledWorkerId(204L);
//        clientService.bookAppointment(request);
//        assertThat(clientRepository.findById(2L).get()
//                .getAppointment().size()).isEqualTo(1);
//
//    }

//    @Test
//    public void testThatClientCan_cancelAppointmentTest() {
//        BookAppointmentRequest request = new BookAppointmentRequest();
//        request.setClientId(3L);
//        request.setCategory(Category.ELECTRICAL);
//        request.setStatus(AppointmentStatus.SCHEDULED);
//        request.setScheduleTime(java.time.LocalDateTime.now().plusDays(6));
//        request.setSkilledWorkerId(204L);
//        clientService.bookAppointment(request);
//        clientService.cancelAppointment(1L,3L);
//        Client client = clientRepository.findById(3L).orElseThrow();
//        assertThat(client.getAppointment().size()).isEqualTo(1);
//        assertThat(client.getAppointment().getFirst().getStatus()).isEqualTo(CANCELLED);
//    }
//    @Test
//    public void testThatClientCanDeleteAppointment(){
//        BookAppointmentRequest request = new BookAppointmentRequest();
//        request.setClientId(2L);
//        request.setCategory(Category.ELECTRICAL);
//        request.setStatus(AppointmentStatus.SCHEDULED);
//        request.setScheduleTime(java.time.LocalDateTime.now().plusDays(6));
//        request.setSkilledWorkerId(202L);
//        clientService.bookAppointment(request);
//        assertThat(clientRepository.findById(2L).get()
//                .getAppointment().size()).isEqualTo(1);
//
//    }
}
