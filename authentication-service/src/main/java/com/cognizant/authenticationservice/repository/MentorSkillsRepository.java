package com.cognizant.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.MentorSkills;

@Repository
public interface MentorSkillsRepository extends JpaRepository<MentorSkills, String> {

}
