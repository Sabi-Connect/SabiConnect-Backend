package com.skilledservice.ClientService.services.ServiceUtils;
import com.skilledservice.ClientService.data.models.ConsultationAvailability;
import com.skilledservice.ClientService.dto.responses.ConsultationResponse;

import java.time.LocalDateTime;

public interface ConsultationService {
    ConsultationResponse bookConsultation(Long clientId, Long workerId,String details);
    ConsultationAvailability scheduleAvailability(Long consultationId,
                                                  LocalDateTime clientAvailability,
                                                  LocalDateTime workerAvailability);


}
