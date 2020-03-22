package com.leadproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.Followup;

/**
 * 
 */
@Repository
public interface MeetingRepository extends JpaRepository<Followup, Long> {

}
