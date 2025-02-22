package com.apiexamples.examples.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class RegistrationDto {

    private Long id;
@Size(min = 2, max = 30, message = "name should be between 3-3- characters")
    private String name;

    private String email;

    private String mobile;
    @JsonIgnore
    private String message;

}