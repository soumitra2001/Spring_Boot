package com.geekster.H2dataBase.controller;

import com.geekster.H2dataBase.models.Users;
import com.geekster.H2dataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService serveUser;

    @GetMapping(value = "/users")
    public List<Users> getAllUser(){
        return serveUser.getAllUser();
    }
}
