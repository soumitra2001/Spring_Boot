package com.geekster.H2dataBase.service;

import com.geekster.H2dataBase.models.Users;
import com.geekster.H2dataBase.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepo;

    public List<Users> getAllUser(){
        return userRepo.findAll();
    }
}
