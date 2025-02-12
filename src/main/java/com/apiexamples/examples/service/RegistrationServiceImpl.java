package com.apiexamples.examples.service;

import com.apiexamples.examples.entity.Registration;
import com.apiexamples.examples.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service

public class RegistrationServiceImpl implements  RegistrationService{
    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration createRegistration(Registration registration) {
        Registration savedEntity = registrationRepository.save(registration);
        return savedEntity;

    }
}
