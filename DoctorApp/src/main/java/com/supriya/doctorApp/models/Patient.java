package com.supriya.doctorApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String patientFirstName;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String patientLastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String patientEmail;

    @NotBlank
    @Pattern(regexp = "[a-z\\D0-9]+")
    private String patientPassword;

    @Pattern(regexp = "[0-9]+")
    private String patientPhoneNumber;

    public Patient(String userFirstName, String userLastName, String userEmail, String encryptedPassword) {
        this.patientFirstName=userFirstName;
        this.patientLastName=userLastName;
        this.patientEmail=userEmail;
        this.patientPassword=encryptedPassword;
    }
}
