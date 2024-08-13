package com.skilledservice.ClientService.data.repository;

import com.skilledservice.ClientService.data.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
