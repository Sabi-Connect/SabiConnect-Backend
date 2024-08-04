package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
