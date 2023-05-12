package com.supriya.doctorApp.repositories;

import com.supriya.doctorApp.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor,Integer> {

}
