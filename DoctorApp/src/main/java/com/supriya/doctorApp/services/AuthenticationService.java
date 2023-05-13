package com.supriya.doctorApp.services;


import com.supriya.doctorApp.models.AuthenticationToken;
import com.supriya.doctorApp.models.Patient;
import com.supriya.doctorApp.repositories.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    ITokenRepo iTokenRepo;

    public void saveToken(AuthenticationToken token)
    {
        iTokenRepo.save(token);
    }

    public AuthenticationToken getToken(Patient patient) {
        return  iTokenRepo.findByPatient(patient);

    }

    public boolean authenticate(String userEmail, String token) {

        AuthenticationToken authToken = iTokenRepo.findFirstByToken(token);//find token object via token string
        String expectedEmail = authToken.getPatient().getPatientEmail();
        return expectedEmail.equals(userEmail);

    }

}
