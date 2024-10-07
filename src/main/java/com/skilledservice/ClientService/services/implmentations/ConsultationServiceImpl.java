package com.skilledservice.ClientService.services.implmentations;

import com.skilledservice.ClientService.data.constants.Category;
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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SkilledWorkerRepository skilledWorkerRepository;

    @Autowired
    private ConsultationAvailabilityRepository consultationAvailabilityRepository;

    @Override
    public ConsultationAvailability scheduleAvailability(Long consultationId, LocalDateTime clientAvailability, LocalDateTime workerAvailability) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));
        ConsultationAvailability availability = new ConsultationAvailability();
        availability.setConsultation(consultation);
        availability.setClientAvailability(clientAvailability);
        availability.setWorkerAvailability(workerAvailability);
        return consultationAvailabilityRepository.save(availability);
    }

    @Override
    public ConsultationResponse bookConsultation(String skilledWorkerFullName, String clientId, LocalDateTime scheduleTime, Category category) {
        SkilledWorker skilledWorker = skilledWorkerRepository.findByFullName(skilledWorkerFullName)
                .orElseThrow(() -> new IllegalArgumentException("SkilledWorker not found with fullName: " + skilledWorkerFullName));

        Client client = clientRepository.findById(Long.parseLong(clientId))
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + clientId));

        Consultation consultation = new Consultation();
        consultation.setWorker(skilledWorker);
        consultation.setClient(client);
        consultation.setScheduleTime(scheduleTime);
        consultation.setCategory(category);
        consultation.setStatus("pending");
        consultationRepository.save(consultation);

        ConsultationResponse response = new ConsultationResponse();
        response.setMessage("Consultation booked successfully");
//        response.setClientId(client.getId().toString());
        response.setClientFullName(client.getFullName());
        response.setScheduleTime(consultation.getScheduleTime());
        response.setSkilledWorkerFullName(skilledWorker.getFullName());
        response.setCategory(category);

        return response;
    }

    public boolean checkAvailability(LocalDateTime scheduleTime, Category category) {
        List<Consultation> consultations = consultationRepository.findByScheduleTimeAndCategory(scheduleTime, category);
        return consultations.isEmpty();
    }

    public void updateBookingStatus(Long consultationId, String newStatus) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));
        consultation.setStatus(newStatus);
        consultationRepository.save(consultation);
    }


}
