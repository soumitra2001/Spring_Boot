package com.supriya.SpringAnnotations.Controller;

import com.supriya.SpringAnnotations.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    Teacher t1;

    @GetMapping("/teach")
    public String teachStudent(){
        return t1.teach();
    }
}
