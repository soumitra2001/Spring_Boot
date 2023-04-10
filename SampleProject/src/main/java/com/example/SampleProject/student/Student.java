package com.example.SampleProject.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int studentID;

    private String fName;

    private String lName;

    private String phNo;

    private String email;

}
