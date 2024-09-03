package com.security.base.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.base.entity.User;
import com.security.base.repository.UserRepository;
import com.security.base.service.JWTService;
import com.security.base.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User register(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userRepository.save(user);
    }
    @Override
    public String verify(User user) {
        Authentication auth = authenticationManager.
        authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getUserPassword()));
        if(auth.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "False";
    }
    
}
