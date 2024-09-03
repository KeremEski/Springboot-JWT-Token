package com.security.base.service;

import com.security.base.entity.User;

public interface UserService {
    User register(User user);
    String verify(User user);
} 
