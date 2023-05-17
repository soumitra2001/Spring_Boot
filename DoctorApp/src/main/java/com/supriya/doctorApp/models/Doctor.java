package com.supriya.doctorApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @NotBlank
    @Pattern(regexp = "[A-Z][A-Za-z\\D]+")
    private String doctorName;

    @Enumerated(value = EnumType.STRING)
    private Specialization doctorSpecialization;

}
