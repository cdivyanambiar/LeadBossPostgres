package com.leadproject.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;

import com.leadproject.model.UserData;

public interface UserDataService {

    String login(String username, String password);
    Optional<User> findByToken(String token);
    UserData findById(Long id);
}
