package com.cognizant.trainingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.trainingservice.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, String> {

	@Query(value = "Select * FROM training t WHERE  t.tg_me_id=?1 ", nativeQuery = true)
	public List<Training> getPendingList(Integer id);

	@Query(value = "FROM Training t WHERE t.proposalStatus ='ACCEPTED' AND t.id=?1 ")
	public List<Training> getAcceptedList(Integer id);

	@Query(value = "From Training t where t.id=?1")
	public Training findAllById(Integer trainingId);

	@Query(value = "Select * FROM training t WHERE t.tg_me_id=?1", nativeQuery = true)
	public List<Training> findTraineeByMentor(Integer mentorId);

	@Query(value = "Select * FROM training t WHERE t.tg_tr_id=?1", nativeQuery = true)
	public List<Training> findTraineeByTrainee(Integer traineeId);

	@Query(value = "select * from training t where t.tg_status not like 'COMPLETED' and t.tg_tr_id=?1", nativeQuery = true)
	public List<Training> getTraineeInCompleteList(Integer traineeId);

	@Query(value = "select * from training t where t.tg_status like 'COMPLETED' and t.tg_tr_id=?1", nativeQuery = true)
	public List<Training> getTraineeCompleteList(Integer traineeId);

	@Query(value = "select * from training t where t.tg_status not like 'COMPLETED' and t.tg_me_id=?1", nativeQuery = true)
	public List<Training> getMentorInCompleteList(Integer mentorId);

	@Query(value = "select * from training t where t.tg_status like 'COMPLETED' and t.tg_me_id=?1", nativeQuery = true)
	public List<Training> getMentorCompleteList(Integer mentorId);

	@Query(value = "select * from training t where t.tg_me_id=?1 and t.tg_tr_id=?2 and t.tg_te_id=?3", nativeQuery = true)
	public Training isAlreadyBooked(Integer mentorId, Integer traineeId, Integer techId);

}
