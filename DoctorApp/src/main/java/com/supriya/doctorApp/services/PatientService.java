package com.supriya.doctorApp.services;

import com.supriya.doctorApp.dto.SignInInput;
import com.supriya.doctorApp.dto.SignInOutput;
import com.supriya.doctorApp.dto.SignUpInput;
import com.supriya.doctorApp.dto.SignUpOutput;
import com.supriya.doctorApp.models.AuthenticationToken;
import com.supriya.doctorApp.models.Doctor;
import com.supriya.doctorApp.models.Patient;
import com.supriya.doctorApp.repositories.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepo patientRepo;

    @Autowired
    AuthenticationService tokenService;

    @Autowired
    DoctorService doctorService;
    public SignUpOutput signUp(SignUpInput signUpInput) {
        // First check if this patient already registered or not
        Patient patient = patientRepo.findByPatientEmail(signUpInput.getUserEmail());

        if(patient!=null){
            throw new IllegalArgumentException("Patient already exist..SignIn instead");
        }

        // Encrypted the password
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptMyPassword(signUpInput.getUserPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        patient=new Patient(signUpInput.getUserFirstName(),
                signUpInput.getUserLastName(),
                signUpInput.getUserEmail(),
                encryptedPassword);

        patientRepo.save(patient);

        AuthenticationToken token = new AuthenticationToken(patient);

        tokenService.saveToken(token);

        return new SignUpOutput("Patient's signup successful..!", HttpStatus.ACCEPTED);
    }

    private String encryptMyPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digestedPass = md5.digest();

        String encryptPassword = null;
        for (byte val:digestedPass){
            encryptPassword += String.format("%02X",val);
        }
        return encryptPassword;
    }

    public SignInOutput signIn(SignInInput signInInput) throws IllegalAccessException{
        //First check any patient is present or not corresponding the email
        Patient patient = patientRepo.getByPatientEmail(signInInput.getUserEmail());

        if(patient==null){
            throw new IllegalAccessException("User invalid!!...SignUp instead");
        }

        //Now check the Password is correct or not
        String encryptedPassword =null;
        try {
            encryptedPassword=encryptMyPassword(signInInput.getUserPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        boolean isCorrectPassword=patient.getPatientPassword().equals(encryptedPassword);
        if(!isCorrectPassword){
            throw new IllegalAccessException("User Invalid!!...SignUp instead");
        }

        AuthenticationToken token=tokenService.getTokenByPatient(patient);

        return new SignInOutput("Patient's logIn successful..",token.getToken());
    }

    public List<Doctor> findAvailableDoctors(String token){
        boolean isTokenPresent=tokenService.findThisToken(token);
        if(!isTokenPresent){
            throw new IllegalStateException("User Invalid!!..");
        }

        return doctorService.getAllDoctor();
    }

}
