package com.apiexamples.examples.controller;

import com.apiexamples.examples.payload.RegistrationDto;
import com.apiexamples.examples.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")



//http://localhost:8080/api/v1/registration
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> addRegistration(@Valid  @RequestBody RegistrationDto registrationDto,
                                                           BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }
        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);
    }

//    http://localhost:8080/api/v1/registration?pageNo=0&pageSize=8&sortby=email
    @GetMapping()
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations(
            @RequestParam(name ="pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(name= "pageSize", defaultValue = "5", required = false)int pageSize,
            @RequestParam(name = "sortby", defaultValue = "name", required = false)String sortBy,
            @RequestParam(name ="sortDir",defaultValue = "name",required = false)String sortDir
            ){

        List<RegistrationDto> dto =registrationService.getAllRegistrations(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
//http://localhost:8080/api/v1/registration?id=

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
@GetMapping("/byId")
    public ResponseEntity<RegistrationDto> getRegistrationById(@RequestParam Long id){
       RegistrationDto dto= registrationService.getRegistrationById(id);
       return new ResponseEntity<>(dto, HttpStatus.OK);
}
}
