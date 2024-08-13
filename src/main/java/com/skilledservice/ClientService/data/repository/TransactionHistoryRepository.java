package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
}
