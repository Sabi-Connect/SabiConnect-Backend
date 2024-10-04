package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.models.Client;
import com.skilledservice.ClientService.data.models.Consultation;
import com.skilledservice.ClientService.data.models.ConsultationAvailability;
import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.data.repository.ClientRepository;
import com.skilledservice.ClientService.data.repository.ConsultationAvailabilityRepository;
import com.skilledservice.ClientService.data.repository.ConsultationRepository;
import com.skilledservice.ClientService.data.repository.SkilledWorkerRepository;
import com.skilledservice.ClientService.dto.responses.ConsultationResponse;
import com.skilledservice.ClientService.services.ServiceUtils.ConsultationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConsultationServiceTest {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private ConsultationAvailabilityRepository consultationAvailabilityRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SkilledWorkerRepository skilledWorkerRepository;

    @Test
    void testBookConsultation() {
        Client client = clientRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: 1L"));

        SkilledWorker skilledWorker = skilledWorkerRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("SkilledWorker not found with id: 1L"));

        ConsultationResponse bookedConsultation = consultationService.bookConsultation(
                client.getId(),
                skilledWorker.getId(),
                "Need electrical repair"
        );
        assertNotNull(bookedConsultation);
        assertNotNull(bookedConsultation.getMessage());
    }

    @Test
    void testScheduleAvailability() {
        ConsultationAvailability consultationAvailability = new ConsultationAvailability();
        consultationAvailability.setClientAvailability(LocalDateTime.now());
        consultationAvailability.setWorkerAvailability(LocalDateTime.now().plusHours(1));
        consultationAvailability.setConsultation(consultationAvailability.getConsultation());
        consultationAvailability.setId(1L);
        assertNotNull(consultationAvailability);
    }

    @Test
    void testScheduleAvailability_ConsultationNotFound() {
        assertThrows(RuntimeException.class, () -> {
            consultationService.scheduleAvailability(999L, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        });
    }
    
}
