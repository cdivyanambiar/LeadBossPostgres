package com.leadproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.Meeting;

/**
 * 
 */
@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> 
{
	List<Meeting> findByLeadId(Long lead_id);
    Optional<Meeting> findByIdAndLeadId(Long id, Long lead_id);
}
