package com.supriya.UserManagementSystem.repo;

import com.supriya.UserManagementSystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class UserDao {

    List<User> users;

    public UserDao(){
        users=new ArrayList<>();
        users.add(new User("0","sample","dummyUser","Heaven","100"));
    }

    public Boolean add(User user){
        return users.add(user);
    }

    public List<User> getAllUser(){
        return users;
    }

    public Boolean updateInfo(String id,User user){
        for(User cust:users){
            if(cust.getUserId().equals(id)){
                if(user.getName()!=null)cust.setName(user.getName());
                if(user.getUserName()!=null)cust.setName(user.getUserName());
                if(user.getAddress()!=null)cust.setName(user.getAddress());
                if(user.getPhone_number()!=null)cust.setName(String.valueOf(user.getPhone_number()));

                return true;
            }
        }
        return false;
    }

    public Boolean delete(String id){
        for(User user:users){
            if(user.getUserId().equals(id))return users.remove(user);
        }
        return false;
    }
}
