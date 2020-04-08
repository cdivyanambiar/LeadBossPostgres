package com.leadproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.SalesActivity;

@Repository
public interface SalesActivityRepository extends JpaRepository<SalesActivity, Long> 
{
	public Optional<SalesActivity> findById(String id);
	List<SalesActivity> findByLeadId(Long lead_id);
    Optional<SalesActivity> findByIdAndLeadId(Long id, Long lead_id);
}
