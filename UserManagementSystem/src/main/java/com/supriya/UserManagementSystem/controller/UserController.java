package com.supriya.UserManagementSystem.controller;

import com.supriya.UserManagementSystem.model.User;
import com.supriya.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/addUser")
    public String addUser(@Valid @RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping(value = "getAllUser")
    public List<User> getAllUser(){
        return service.getAll();
    }

    @GetMapping(value = "getUser/{id}")
    public User getUser(@PathVariable String id){
        return service.getUserById(id);
    }

    @PutMapping(value = "updateUserInfo/{id}")
    public String updateUser(@PathVariable String id,@Valid @RequestBody User user){
        return service.updateUserInfo(id,user);
    }

    @DeleteMapping(value = "deleteUser")
    public String deleteUser(@RequestParam String id){
        return service.deleteUser(id);
    }
}
