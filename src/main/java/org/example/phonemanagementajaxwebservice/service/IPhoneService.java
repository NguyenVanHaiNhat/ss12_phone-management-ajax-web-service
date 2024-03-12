package org.example.phonemanagementajaxwebservice.service;

import org.example.phonemanagementajaxwebservice.model.Phone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Phone> findAll();
    Optional<Phone> findById(Long id);
    void save(Phone phone);
    void remove(Long id);
}
