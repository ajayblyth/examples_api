package com.apiexamples.examples.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Transient;
import lombok.Data;

@Data

public class RegistrationDto {

    private Long id;

    private String name;

    private String email;

    private String mobile;
    @JsonIgnore
    private String message;

}