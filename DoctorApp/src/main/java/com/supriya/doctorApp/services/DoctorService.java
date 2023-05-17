package com.supriya.doctorApp.services;

import com.supriya.doctorApp.models.Doctor;
import com.supriya.doctorApp.repositories.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IDoctorRepo doctorRepo;

    public List<Doctor> getAllDoctor(){
        return doctorRepo.findAll();
    }

}
