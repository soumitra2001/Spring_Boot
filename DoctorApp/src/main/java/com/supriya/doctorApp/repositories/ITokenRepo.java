package com.supriya.doctorApp.repositories;


import com.supriya.doctorApp.models.AuthenticationToken;
import com.supriya.doctorApp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {


    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}