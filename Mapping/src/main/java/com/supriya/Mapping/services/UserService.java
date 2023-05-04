package com.supriya.Mapping.services;

import com.supriya.Mapping.models.User;
import com.supriya.Mapping.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userDao;

    public List<User> getAllUser(){
        return (List<User>) userDao.findAll();
    }

    public String addUser(User user){
        userDao.save(user);
        return "User added successfully..!";

    }

    public String deleteUser(String id){
        List<User> users=getAllUser();
        for(User user:users){
            if(user.getUserId()==Long.parseLong(id)){
                userDao.deleteById(Long.parseLong(id));
                return "User deleted successfully..(*_*)";
            }
        }
        return "Invalid user input";
    }
}
