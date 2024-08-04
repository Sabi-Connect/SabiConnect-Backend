package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
}
