package com.apiexamples.examples.controller;

import com.apiexamples.examples.entity.Registration;
import com.apiexamples.examples.payload.RegistrationDto;
import com.apiexamples.examples.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")

//http://localhost:8080/api/v1/registration
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("/create")
    public ResponseEntity<RegistrationDto> addRegistration(@RequestBody RegistrationDto registrationDto){
        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity< String> deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistrationById(id);
        return  new ResponseEntity<>("Registration deleted " , HttpStatus.OK);

    }

}
