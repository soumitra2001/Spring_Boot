package com.supriya.doctorApp.controllers;

import com.supriya.doctorApp.dto.SignInInput;
import com.supriya.doctorApp.dto.SignInOutput;
import com.supriya.doctorApp.dto.SignUpInput;
import com.supriya.doctorApp.dto.SignUpOutput;
import com.supriya.doctorApp.models.Doctor;
import com.supriya.doctorApp.models.Patient;
import com.supriya.doctorApp.services.PatientService;
import jakarta.validation.Valid;
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

    @PostMapping("/signUp")
    public SignUpOutput signUp(@RequestBody SignUpInput input){
        return patientService.signUp(input);
    }

    @PostMapping("/signIn")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInInput) {
        try {
            return patientService.signIn(signInInput);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/doctors/{token}")
    public ResponseEntity<List<Doctor>> availableDoctors(@PathVariable String token){
        List<Doctor> doctors=patientService.findAvailableDoctors(token);
        return new ResponseEntity<>(doctors,doctors!=null? HttpStatus.OK:HttpStatus.NO_CONTENT);
    }



}
