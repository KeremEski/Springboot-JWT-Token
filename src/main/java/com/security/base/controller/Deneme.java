package com.security.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.base.entity.User;
import com.security.base.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Deneme {

    @Autowired
    private UserService userService;

    @GetMapping("/hi")
    public String deneme(){
        return "hi";
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        userService.register(user);
        return user;
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }
    
}
