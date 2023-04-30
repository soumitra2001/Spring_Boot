package com.supriya.SpringAnnotations.Controller;

import com.supriya.SpringAnnotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    @Qualifier("s1")
    Student s1;
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String getStudent(){
        System.out.println("Student Object returned..");
        return s1.toString();
    }
}
