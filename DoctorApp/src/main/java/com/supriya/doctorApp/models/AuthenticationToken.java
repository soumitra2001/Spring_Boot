package com.supriya.doctorApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authenticationId;

    private String token;

    private LocalDate tokenGenerationTime;

    @OneToOne
    private Patient patient;

    public AuthenticationToken(Patient patient){
        this.patient=patient;
        this.tokenGenerationTime=LocalDate.now();
        this.token= UUID.randomUUID().toString();
    }

}
