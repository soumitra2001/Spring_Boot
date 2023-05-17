package com.supriya.doctorApp.repositories;

import com.supriya.doctorApp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient,Long> {

    Patient findByPatientEmail(String userEmail);

    Patient getByPatientEmail(String userEmail);
}
