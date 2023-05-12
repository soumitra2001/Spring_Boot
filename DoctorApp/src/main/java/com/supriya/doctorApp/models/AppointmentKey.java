package com.supriya.doctorApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentKey implements Serializable {

    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public Integer appointmentId;

    public LocalDate appointmentTime;

}
