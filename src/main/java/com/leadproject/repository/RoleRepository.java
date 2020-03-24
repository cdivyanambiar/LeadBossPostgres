package com.leadproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leadproject.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{
}
