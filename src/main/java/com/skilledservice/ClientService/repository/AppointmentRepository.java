package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllById(Long id);
    Long findByUserId(Long userId);
}
