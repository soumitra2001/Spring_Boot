package com.geekster.H2dataBase.service;

import com.geekster.H2dataBase.models.Users;
import com.geekster.H2dataBase.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepo;

    private List<Users> allUser;

    public Iterable<Users> getAllUser(){
        return userRepo.findAll();
    }

    public String addUsers(List<Users> users) {
        allUser= (List<Users>)userRepo.saveAll(users);
        if(allUser.size()>0){
            return "Users added successfully...!";
        }
        return "Invalid user input...!";
    }

    public String deleteUser(int id){
        allUser = (List<Users>) getAllUser();
        for(Users user:allUser){
            if(user.getId().equals(id)){
                userRepo.deleteById(id);
                return "User deleted successfully...!";
            }
        }
        return "Invalid user input...!";
    }

    public String deleteUsers(List<Integer> listOfId){
        if(listOfId.size()!=0) {
            userRepo.deleteAllById(listOfId);
            return "The users ware deleted if ids ware presented earlier.";
        }
        return "Invalid user input...!";
    }


}
