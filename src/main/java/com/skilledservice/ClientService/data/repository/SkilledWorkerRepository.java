package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.SkilledWorker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkilledWorkerRepository extends JpaRepository<SkilledWorker, Long> {

    Optional<SkilledWorker> findById(Long Id);
}



