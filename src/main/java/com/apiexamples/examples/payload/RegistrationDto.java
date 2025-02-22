package com.apiexamples.examples.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class RegistrationDto {

//    Note: @Size(min =1, max = 2) will work for string only
//          for Integer use  @Min(value = ) and @Max(value =)

    private Long id;
    @Size(min = 2, max = 30, message = "name should be between 3-3- characters")
    private String name;

    @Email(message = "wrong email format")
    private String email;

    private String mobile;

    @JsonIgnore
    private String message;

}