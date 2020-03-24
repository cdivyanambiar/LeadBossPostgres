package com.leadproject.service;

import com.leadproject.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}