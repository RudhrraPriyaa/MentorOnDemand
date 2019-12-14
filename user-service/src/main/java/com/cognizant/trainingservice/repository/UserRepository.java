package com.cognizant.trainingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.trainingservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("FROM User u where u.userName=?1")
	public User findByUsername(String userName);
}
