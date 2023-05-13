package com.supriya.doctorApp.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentKey implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer appointmentId;

    public LocalDate appointmentTime;

}
