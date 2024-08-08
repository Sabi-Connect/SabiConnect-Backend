package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
