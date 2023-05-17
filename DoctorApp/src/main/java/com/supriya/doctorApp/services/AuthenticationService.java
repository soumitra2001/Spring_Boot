package com.supriya.doctorApp.services;

import com.supriya.doctorApp.models.AuthenticationToken;
import com.supriya.doctorApp.models.Patient;
import com.supriya.doctorApp.repositories.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public void saveToken(AuthenticationToken token) {
        authenticationRepo.save(token);
    }

    public AuthenticationToken getTokenByPatient(Patient patient) {
        return authenticationRepo.getByPatient(patient);
    }

    public boolean findThisToken(String token) {
        return authenticationRepo.findByToken(token);
    }
}
