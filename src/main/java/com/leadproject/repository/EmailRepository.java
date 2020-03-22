package com.leadproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> 
{
    public Optional<Email> findById(String id);
}
