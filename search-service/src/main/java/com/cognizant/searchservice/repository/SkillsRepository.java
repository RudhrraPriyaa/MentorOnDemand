package com.cognizant.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.searchservice.model.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, String> {

	@Query("FROM Skills s WHERE s.skillName=?1")
	public Skills findBySkillName(String name);

}
