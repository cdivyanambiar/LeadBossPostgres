package com.leadproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.Lead;


/**
 * 
 */
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> 
{
    public Optional<Lead> findById(String id);
}
