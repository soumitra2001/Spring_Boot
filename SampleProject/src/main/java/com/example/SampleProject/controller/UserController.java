package com.example.SampleProject.controller;

import com.example.SampleProject.student.Student;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping(value="/user")
    public String getUserInfo(){
        return "I am Supriya, the thing is that I am learning Spring Boot Dev.";
    }

    @PostMapping(value="/user")
    public String setUserInfo(@RequestBody Student info) {
        String fName=info.getFirstName();
        String lName=info.getLastName();
        int id=info.getStudentID();
        String email=info.getEmail();
        System.out.println(fName+"  "+lName+"    "+id+"    "+email);
        return "Value is => "+info;
    }

    @PutMapping(value="/user")
    public String updateUserInfo(@RequestBody String data){
        System.out.println("The data we get is "+data);
        return "User Data Updated";
    }

    @DeleteMapping(value="/user")
    public String deleteUserInfo(){
        return "User info has been deleted.";
    }
}
