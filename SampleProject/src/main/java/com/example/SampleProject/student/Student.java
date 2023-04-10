package com.example.SampleProject.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int studentID;

    private String firstName;

    private String lastName;

    private String DOB;

    private String email;


}
