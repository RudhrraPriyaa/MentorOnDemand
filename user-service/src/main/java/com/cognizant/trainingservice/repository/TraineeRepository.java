package com.cognizant.trainingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.trainingservice.model.Trainee;
import com.cognizant.trainingservice.model.Training;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, String> {

	@Query("FROM Trainee t where t.traineeName=?1")
	public Trainee findByUsername(String userName);

	@Query("FROM Trainee t WHERE t.traineeName=?1")
	public Trainee findByUserID(String userID);

	@Query(value = "Select * FROM training t WHERE t.tg_status='PENDING' AND t.tg_me_id=?1 ", nativeQuery = true)
	public List<Training> getPendingList(Long id);

	@Query(value = "FROM Training t WHERE t.proposalStatus ='ACCEPTED' AND t.id=?1 ")
	public List<Training> getAcceptedList(Long id);
}
