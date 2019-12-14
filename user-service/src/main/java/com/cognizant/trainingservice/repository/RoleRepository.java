package com.cognizant.trainingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.trainingservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Role findByName(String userName);
}
