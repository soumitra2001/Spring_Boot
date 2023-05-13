package com.supriya.doctorApp.services;

import com.supriya.doctorApp.models.Appointment;
import com.supriya.doctorApp.models.AppointmentKey;
import com.supriya.doctorApp.repositories.IAppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepo appointmentRepo;

    public void bookAppointment(Appointment appointment) {
        appointmentRepo.save(appointment);
    }

    public void cancelAppointment(AppointmentKey key) {
        appointmentRepo.deleteById(key);
    }

    public boolean checkValidKey(AppointmentKey key) {
        List<Appointment> appointments=appointmentRepo.findAll();

        for(Appointment appointment:appointments){
            if(appointment.getAppointmentKey().equals(key))return true;
        }
        return false;
    }
}
