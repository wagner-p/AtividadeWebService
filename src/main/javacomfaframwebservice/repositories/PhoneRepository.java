package com.fafram.webserviceApplication.repositories;

import com.fafram.webserviceApplication.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}