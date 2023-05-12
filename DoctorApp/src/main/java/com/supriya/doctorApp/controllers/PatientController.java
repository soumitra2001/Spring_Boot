package com.supriya.doctorApp.controllers;

import com.supriya.doctorApp.dto.SignInInput;
import com.supriya.doctorApp.dto.SignInOutput;
import com.supriya.doctorApp.dto.SignUpInput;
import com.supriya.doctorApp.dto.SignUpOutput;
import com.supriya.doctorApp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

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



}
