package com.leadproject.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.UserDto;
import com.leadproject.service.UserDataService;
@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("/login")
    public String getToken(@RequestBody UserDto user){
       System.out.println("" +user.getUsername() +" : "+user.getPassword());
       String token= userDataService.login(user.getUsername(),user.getPassword());
       if(StringUtils.isEmpty(token)){
           return "no token found";
       }
       return token;
    }
}
