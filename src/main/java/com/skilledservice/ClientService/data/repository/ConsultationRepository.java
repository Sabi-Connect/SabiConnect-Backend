package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.constants.Category;
import com.skilledservice.ClientService.data.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
    List<Consultation> findByClient_Id(Long clientId);

    List<Consultation> findByScheduleTimeAndCategory(LocalDateTime scheduleTime, Category category);
}
