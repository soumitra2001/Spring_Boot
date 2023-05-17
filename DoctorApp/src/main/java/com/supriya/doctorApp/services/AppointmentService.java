package com.supriya.doctorApp.services;

import com.supriya.doctorApp.models.Appointment;
import com.supriya.doctorApp.repositories.IAppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepo appointmentRepo;

    @Autowired
    AuthenticationService tokenService;
    public String bookAppointment(String token, Appointment appointment) {
        //First check if the token is valid or not
        boolean isValidToken= tokenService.findThisToken(token);

        if(!isValidToken){
            try {
                throw new IllegalAccessException("User Invalid..!");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        //Check which appointment time patient choose is available or not
        boolean isValidTime=checkAppointmentTime(appointment.getAppointmentKey().getAppointmentTime());

        Appointment myAppointment=new Appointment(appointment.getAppointmentKey().getAppointmentTime(),appointment.getDoctor(),appointment.getPatient());

        appointmentRepo.save(myAppointment);

        return "Your Appointment booked successfully..!";

    }

    private boolean checkAppointmentTime(LocalTime appointmentTime) {
        int hour=appointmentTime.getHour();
        int minute=appointmentTime.getMinute();

    }
}
