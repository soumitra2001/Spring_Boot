package com.supriya.doctorApp.controllers;

import com.supriya.doctorApp.models.Doctor;
import com.supriya.doctorApp.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService docService;

    @PostMapping()
    void addDoctors(@RequestBody Doctor doc)
    {
        docService.addDoc(doc);
    }
}