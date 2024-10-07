package com.skilledservice.ClientService.services.ServiceUtils;
import com.skilledservice.ClientService.data.constants.Category;
import com.skilledservice.ClientService.data.models.ConsultationAvailability;
import com.skilledservice.ClientService.dto.responses.ConsultationResponse;

import java.time.LocalDateTime;

public interface ConsultationService {
//    ConsultationResponse bookConsultation(String skilledWorkerFullName, String details);
    ConsultationAvailability scheduleAvailability(Long consultationId,
                                                  LocalDateTime clientAvailability,
                                                  LocalDateTime workerAvailability);

    ConsultationResponse bookConsultation(String skilledWorkerFullName, String clientId, LocalDateTime scheduleTime, Category category);

    void updateBookingStatus(Long consultationId, String newStatus);
    boolean checkAvailability(LocalDateTime scheduleTime, Category category);


}
