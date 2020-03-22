package com.leadproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.Followup;

/**
 * 
 */
@Repository
public interface FollowupRepository extends JpaRepository<Followup, Long> 
{
	     List<Followup> findByLeadId(Long lead_id);
	     Optional<Followup> findByIdAndLeadId(Long id, Long lead_id);
}
