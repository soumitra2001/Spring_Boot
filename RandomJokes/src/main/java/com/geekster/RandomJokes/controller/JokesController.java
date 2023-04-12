package com.geekster.RandomJokes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JokesController {
    static ArrayList<String> jokes=new ArrayList<>();
    JokesController(){
        jokes.add("Why did the tomato turn red? Because it saw the salad dressing!");
        jokes.add("Why don't scientists trust atoms? Because they make up everything!");
        jokes.add("What do you call fake spaghetti? An impasta!");
        jokes.add("How do you organize a space party? You planet!");
        jokes.add("Why did the chicken cross the playground? To get to the other slide!");
        jokes.add("Why did the hipster burn his tongue? He drank his coffee before it was cool.");
    }
    @GetMapping(value="/jokes")
    public String getJokes(){

        int idx=0+(int)(Math.random()*((jokes.size()-1-0)+1));
        return jokes.get(idx);
    }

    @PostMapping(value="/jokes")
    public String postJokes(@RequestBody String joke){
        jokes.add(joke);
        return "Joke saved";
    }
}
