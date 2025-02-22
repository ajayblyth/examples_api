package com.apiexamples.examples.service;

import com.apiexamples.examples.payload.RegistrationDto;

import java.util.List;

public interface RegistrationService {
     RegistrationDto createRegistration(RegistrationDto registrationDto);

     void deleteRegistrationById(long id);

     RegistrationDto updateRegistration(long id, RegistrationDto registrationDto);


     List<RegistrationDto> getAllRegistrations();
}
