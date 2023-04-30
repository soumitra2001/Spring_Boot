package com.supriya.SpringAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomConfiguration {

@Bean("s1")
@Primary
    public Student getStudent(){

        System.out.println("Student Object created by Spring");
        return new Student("Supriya👨‍🎓");
    }

    @Bean("s2")
    @Lazy
    public Student getStudent2(){

        System.out.println("Student-2 Object created by Spring");
        return new Student("Tomcat😂");
    }
}
