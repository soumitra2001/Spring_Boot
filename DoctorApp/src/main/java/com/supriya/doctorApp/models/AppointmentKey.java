package com.supriya.doctorApp.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@Data
public class AppointmentKey implements Serializable {

    private Long appointmentId;

    private LocalTime appointmentTime;

}
