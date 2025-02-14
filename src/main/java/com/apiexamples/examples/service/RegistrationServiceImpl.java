package com.apiexamples.examples.service;

import com.apiexamples.examples.entity.Registration;
import com.apiexamples.examples.payload.RegistrationDto;
import com.apiexamples.examples.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RegistrationServiceImpl implements  RegistrationService {
    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
    Registration registration = mapToEntity(registrationDto);
    Registration savedEntity = registrationRepository.save(registration);
    RegistrationDto dto = mapToDto(savedEntity);
        return dto;
}

    @Override
    public void deleteRegistrationById(long id) {
        registrationRepository.deleteById(id);

    }

    @Override
    public RegistrationDto updateRegistration(long id, RegistrationDto registrationDto) {
        Optional<Registration> opReg= registrationRepository.findById(id);
        Registration registration = opReg.get();
        registration.setName(registrationDto.getName());
        registration.setMobile(registrationDto.getMobile());
        registration.setEmail(registrationDto.getEmail());
        Registration savedEntity = registrationRepository.save(registration);
       return mapToDto(savedEntity);
    }

    @Override
    public RegistrationDto fetchById(long id) {
     Registration byId = registrationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(" Registration not found"));
     return mapToDto(byId);
    }

    Registration mapToEntity(RegistrationDto dto) {

    Registration entity = new Registration();
    entity.setName(dto.getName());
    entity.setEmail(dto.getEmail());
    entity.setMobile(dto.getMobile());
    return entity;

}

RegistrationDto mapToDto(Registration registration) {

    RegistrationDto dto = new RegistrationDto();
    dto.setId(registration.getId());
    dto.setName(registration.getName());
    dto.setEmail(registration.getEmail());
    dto.setMobile(registration.getMobile());
    return dto;
}}