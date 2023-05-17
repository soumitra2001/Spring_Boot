package com.supriya.doctorApp.repositories;

import com.supriya.doctorApp.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor,Long> {

}
