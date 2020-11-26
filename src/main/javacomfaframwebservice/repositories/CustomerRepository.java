package com.fafram.webserviceApplication.repositories;

import com.fafram.webserviceApplication.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}