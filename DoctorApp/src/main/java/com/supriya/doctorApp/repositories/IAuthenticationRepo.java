package com.supriya.doctorApp.repositories;

import com.supriya.doctorApp.models.AuthenticationToken;
import com.supriya.doctorApp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken getByPatient(Patient patient);

    boolean findByToken(String token);

}
