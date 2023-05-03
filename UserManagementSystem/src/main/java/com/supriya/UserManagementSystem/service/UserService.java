package com.supriya.UserManagementSystem.service;

import com.supriya.UserManagementSystem.model.User;
import com.supriya.UserManagementSystem.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    List<User> users;

    public String addUser(User user){
        if(dao.add(user))return "User added successfully..!";
        return "Invalid user input..!";
    }

    public List<User> getAll(){
        return dao.getAllUser();
    }

    public User getUserById(String id){
        users=dao.getAllUser();
        for(User user:users){
            if(user.getUserId().equals(id))return user;
        }
        return null;
    }

    public String updateUserInfo(String id,User user){
        if(dao.updateInfo(id,user))return "UserInfo updated successfully...!";
        return "Invalid user input...!";
    }

    public String deleteUser(String id){
        if(dao.delete(id))return "User deleted successfully..!";
        return "Invalid user input..!";
    }

}
