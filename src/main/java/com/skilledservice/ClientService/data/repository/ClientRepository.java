package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
