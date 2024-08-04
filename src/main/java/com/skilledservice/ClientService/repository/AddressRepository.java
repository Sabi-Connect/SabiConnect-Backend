package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
