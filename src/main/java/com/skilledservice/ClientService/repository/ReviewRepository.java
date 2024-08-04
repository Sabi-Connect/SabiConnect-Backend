package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
