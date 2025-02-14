package com.apiexamples.examples.controller;

import com.apiexamples.examples.payload.RegistrationDto;
import com.apiexamples.examples.repository.RegistrationRepository;
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
    @GetMapping("/get/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(@PathVariable long id){
        RegistrationDto dto = registrationService.fetchById(id);
return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity< String> deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistrationById(id);
        return  new ResponseEntity<>("Registration deleted " , HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity< RegistrationDto> updateById(@RequestParam long id,
                                                       @RequestBody RegistrationDto registrationDto){
        RegistrationDto dto = registrationService.updateRegistration(id, registrationDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
