package com.apiexamples.examples.controller;

import com.apiexamples.examples.entity.Registration;
import com.apiexamples.examples.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")

//http://localhost:8080/api/v1/registration
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("/create")
    public Registration addRegistration(@RequestBody Registration registration){
        Registration savedEntity = registrationService.createRegistration(registration);
        return savedEntity;


    }

}
