package com.apiexamples.examples.service;

import com.apiexamples.examples.payload.RegistrationDto;

public interface RegistrationService {
     RegistrationDto createRegistration(RegistrationDto registrationDto);

     void deleteRegistrationById(long id);

     RegistrationDto updateRegistration(long id, RegistrationDto registrationDto);
}
