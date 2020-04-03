package com.leadproject.service;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.leadproject.model.UserData;
import com.leadproject.repository.UserDataRepository;

@Service("userDataService")
public class DefaultUserDataService implements UserDataService {

    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public String login(String username, String password) {
        Optional<UserData> userData = userDataRepository.login(username,password);
        if(userData.isPresent()){
            String token = UUID.randomUUID().toString();
            UserData custom= userData.get();
            custom.setToken(token);
            userDataRepository.save(custom);
            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<UserData> userDataOptional= userDataRepository.findByToken(token);
        if(userDataOptional.isPresent()){
            UserData userData = userDataOptional.get();
            User user= new User(userData.getUserName(), userData.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    @Override
    public UserData findById(Long id) {
        Optional<UserData> userData= userDataRepository.findById(id);
        return userData.orElse(null);
    }
}
