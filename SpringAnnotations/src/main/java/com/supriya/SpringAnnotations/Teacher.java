package com.supriya.SpringAnnotations;

import org.springframework.stereotype.Component;

@Component
public class Teacher {

    public Teacher() {
        System.out.println("Teacher Constructor Called..");
    }

    public String teach(){
        return "Teacher is teaching Spring Boot";
    }
}
