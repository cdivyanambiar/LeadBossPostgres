package com.leadproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.PhoneCall;

/**
 * 
 */
@Repository
public interface PhoneCallRepository extends JpaRepository<PhoneCall, Long>
{
	List<PhoneCall> findByLeadId(Long lead_id);
    Optional<PhoneCall> findByIdAndLeadId(Long id, Long lead_id);
}
