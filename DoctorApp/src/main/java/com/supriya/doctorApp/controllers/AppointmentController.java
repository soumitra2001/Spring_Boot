package com.supriya.doctorApp.controllers;

import com.supriya.doctorApp.models.Appointment;
import com.supriya.doctorApp.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/patient")
    public String bookAppointment(@PathVariable String token, @Valid @RequestBody Appointment appointment){
        return appointmentService.bookAppointment(token,appointment);
    }
}
