package com.supriya.doctorApp.controllers;

import com.supriya.doctorApp.dto.SignInInput;
import com.supriya.doctorApp.dto.SignInOutput;
import com.supriya.doctorApp.dto.SignUpInput;
import com.supriya.doctorApp.dto.SignUpOutput;
import com.supriya.doctorApp.models.AppointmentKey;
import com.supriya.doctorApp.models.Doctor;
import com.supriya.doctorApp.services.AuthenticationService;
import com.supriya.doctorApp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @Autowired
    AuthenticationService authService;

    //sign up

    // sign up input
    //sign up output
    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto)
    {
        return patientService.signUp(signUpDto);
    }

    //sign in

    @PostMapping("/signin")
    public SignInOutput signup(@RequestBody SignInInput signInDto)
    {
        return patientService.signIn(signInDto);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam String userEmail, @RequestParam String token)
    {
        HttpStatus status;
        List<Doctor> allDoctors = null;
        //authenticate

        //token : calculate token -> find email in Db corr to this token-> match the emails
        if(authService.authenticate(userEmail,token))
        {

            allDoctors =  patientService.getAllDoctors();
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }



        return new ResponseEntity<List<Doctor>>(allDoctors, status);
    }


    //todo : move the create appointment in Appointment controller in here along with authentication...!

    //delete my appointment :

    @DeleteMapping("appointment")
    ResponseEntity<Void> cancelAppointment(@RequestParam String userEmail, @RequestParam String token, @RequestBody AppointmentKey key)
    {

        HttpStatus status;
        if(authService.authenticate(userEmail,token) & patientService.isValidKey(key))
        {
            patientService.cancelAppointment(key);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<Void>(status);

    }


}
