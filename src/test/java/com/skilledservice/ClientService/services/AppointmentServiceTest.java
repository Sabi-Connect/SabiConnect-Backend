package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.data.constants.AppointmentStatus;
import com.skilledservice.ClientService.dto.requests.AcceptAppointmentRequest;
import com.skilledservice.ClientService.dto.responses.AcceptAppointmentResponse;
import com.skilledservice.ClientService.services.ServiceUtils.AppointmentService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppointmentServiceTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void acceptClientAppointmentSchedule() {
        AcceptAppointmentRequest request = new AcceptAppointmentRequest();
        request.setClientId(301L);
        request.setAppointmentId(101L);
        request.setStatus(AppointmentStatus.ACCEPTED);
        AcceptAppointmentResponse response = appointmentService.acceptAppointment(request);
        assertNotNull(response);
        assertNotNull(response.getAppointmentId());
        assertNotNull(response.getClientId());
        assertNotNull(response.getStatus());
        assertThat(appointmentService.getAppointments()).isEqualTo(1L);

    }
}
