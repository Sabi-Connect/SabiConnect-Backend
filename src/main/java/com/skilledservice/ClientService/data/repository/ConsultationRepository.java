package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
