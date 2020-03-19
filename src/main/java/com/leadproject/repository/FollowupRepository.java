package com.leadproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadproject.model.Followup;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface FollowupRepository extends JpaRepository<Followup, Long> {

}
