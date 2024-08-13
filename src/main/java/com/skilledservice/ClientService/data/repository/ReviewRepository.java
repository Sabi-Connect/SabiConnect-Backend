package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//    @Query("select r Review from Review r where r.skilledWorker.id=:reviewerId")
//    List<Review> findReviewsForSkilledWorker(Long reviewerId);
//
}

//@Query("select s from Skill s where s.skilledWorker.id=:skilledWorkerId")

