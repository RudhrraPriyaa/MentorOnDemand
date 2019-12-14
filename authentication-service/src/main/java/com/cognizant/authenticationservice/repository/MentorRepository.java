package com.cognizant.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, String> {

	@Query("FROM Mentor m where m.mentorName=?1")
	public Mentor findByUsername(String userName);
}
