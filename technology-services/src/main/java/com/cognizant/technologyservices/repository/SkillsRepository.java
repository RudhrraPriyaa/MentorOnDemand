package com.cognizant.technologyservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.technologyservices.model.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, String> {

}
