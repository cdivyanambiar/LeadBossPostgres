package com.leadproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.UserData;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {

    @Query(value = "SELECT u FROM UserData u where u.userName = ?1 and u.password = ?2 ")
    Optional<UserData> login(String username,String password);

    Optional<UserData> findByToken(String token);
}
