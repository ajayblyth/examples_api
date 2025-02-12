package com.apiexamples.examples.payload;

import lombok.Data;

@Data

public class RegistrationDto {

    private Long id;

    private String name;

    private String email;

    private String mobile;

}