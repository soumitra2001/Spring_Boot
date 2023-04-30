package com.supriya.SpringAnnotations;

import org.springframework.stereotype.Component;


public class Student {

    private String name;

    Student(){
        System.out.println("Student no args constructor called..");
    }

    Student(String name){
        this.name=name;
        System.out.println("Student args constructor called..");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
