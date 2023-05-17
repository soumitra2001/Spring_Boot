package com.supriya.doctorApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignUpInput {

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String userFirstName;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String userLastName;

    @NotBlank
    @Email(message = "Not a valid email...!")
    private  String userEmail;

    @NotBlank
    @Pattern(regexp = "[a-z\\D0-9]+")
    private String userPassword;
}
