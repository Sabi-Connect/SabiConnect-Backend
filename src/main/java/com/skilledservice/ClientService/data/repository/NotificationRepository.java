package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
