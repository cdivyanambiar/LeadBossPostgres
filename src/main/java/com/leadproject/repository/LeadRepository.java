package com.leadproject.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leadproject.model.Lead;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    public Optional<Lead> findById(String id);

//    @Query("{'dateOfAddition': {$gte: ?0, $lte:?1 }}")
//    public List<Lead> getLeadsByDate(LocalDate from, LocalDate to);
}
