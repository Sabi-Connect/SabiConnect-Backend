package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.ConsultationAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationAvailabilityRepository extends JpaRepository<ConsultationAvailability, Long> {
}
