package org.example.phonemanagementajaxwebservice.repository;

import org.example.phonemanagementajaxwebservice.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone, Long> {
}
