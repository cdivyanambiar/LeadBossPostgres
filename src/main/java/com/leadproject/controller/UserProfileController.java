package com.leadproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.UserData;
import com.leadproject.service.UserDataService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest")
public class UserProfileController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping(value = "/user/{id}",produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)  
    public UserData getUserDetail(@PathVariable Long id){
        return userDataService.findById(id);
    }
}
