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

    public void addDoc(Doctor doc) {
        doctorRepo.save(doc);
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> allDoctors = doctorRepo.findAll();
        return allDoctors;

    }
}
