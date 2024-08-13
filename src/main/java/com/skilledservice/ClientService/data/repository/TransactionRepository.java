package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
