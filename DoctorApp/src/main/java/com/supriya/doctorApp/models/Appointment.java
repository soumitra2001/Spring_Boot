package com.supriya.doctorApp.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @EmbeddedId
    private AppointmentKey appointmentKey;

    @Nullable
    private LocalTime appointmentValidTime;

    @ManyToOne
    @JoinColumn(name = "fk_doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "fk_patient_id")
    private Patient patient;

    public Appointment(LocalTime time,Doctor doctor,Patient patient){
        this.appointmentKey.setAppointmentTime(time);
        int minute=LocalTime.now().getMinute()+30;
        int hour=LocalTime.now().getHour()+(minute/60);
        minute = minute%60;
        this.appointmentValidTime=LocalTime.of(hour,minute);

        this.doctor=doctor;
        this.patient=patient;
    }

}
