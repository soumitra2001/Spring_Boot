package com.example.SampleProject.controller;

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
    public String setUserInfo(@RequestBody String data) {
        JSONObject obj = new JSONObject(data);
        String name=obj.getString("name");
        int age=obj.getInt("age");
        String email=obj.getString("email");
        System.out.println("Name: "+name+" Age: "+age+" email: "+email);
        return "Value is => "+data;
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
