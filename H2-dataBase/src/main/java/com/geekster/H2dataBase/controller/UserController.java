package com.geekster.H2dataBase.controller;

import com.geekster.H2dataBase.models.Users;
import com.geekster.H2dataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService serveUser;

    @GetMapping
    public Iterable<Users> getAllUser(){
        return serveUser.getAllUser();
    }

    @PostMapping
    public String insertUser(@RequestBody List<Users> users){
        return serveUser.addUsers(users);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Integer id){
        return serveUser.deleteUser(id);
    }

    @DeleteMapping(value = "/")
    public String deleteAllUser(@RequestBody List<Integer> ids){
        return serveUser.deleteUsers(ids);
    }

}
