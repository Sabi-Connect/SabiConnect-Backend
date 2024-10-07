package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.SkilledWorker;
import com.skilledservice.ClientService.services.ServiceUtils.ClientService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkilledWorkerRepository extends JpaRepository<SkilledWorker, Long> {

    Optional<SkilledWorker> findById(Long Id);

    Optional<SkilledWorker> findByEmail(String email);

    Optional<SkilledWorker> findSkillByFullName(String skilledWorkerFullName);
    Optional<SkilledWorker> findByFullName(String fullName);
}



