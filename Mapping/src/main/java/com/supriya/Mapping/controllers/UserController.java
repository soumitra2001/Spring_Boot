package com.supriya.Mapping.controllers;

import com.supriya.Mapping.models.User;
import com.supriya.Mapping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/allUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping(value = "/user")
    public String addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping(value = "deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }
}
