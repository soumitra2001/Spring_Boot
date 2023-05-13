package com.supriya.doctorApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @Embedded
    private AppointmentKey appointmentKey;

    @ManyToOne
    @JoinColumn(name = "fk_doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "fk_patient_id")
    private Patient patient;

}
