package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
