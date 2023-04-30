package com.supriya.SpringAnnotations.Controller;

import TestComponentScan.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"TestComponentScan"})
public class TeacherController {

    @Autowired
    Teacher t1;

    @GetMapping("/teach")
    public String teachStudent(){
        return t1.teach();
    }
}
