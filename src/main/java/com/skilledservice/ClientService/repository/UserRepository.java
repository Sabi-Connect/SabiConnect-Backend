package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
