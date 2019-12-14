package com.cognizant.trainingservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.trainingservice.exception.BookingAlreadyExistsException;
import com.cognizant.trainingservice.model.Training;
import com.cognizant.trainingservice.repository.MentorRepository;
import com.cognizant.trainingservice.repository.SkillsRepository;
import com.cognizant.trainingservice.repository.TraineeRepository;
import com.cognizant.trainingservice.repository.TrainingRepository;

@Service
public class TrainingService {
	@Autowired
	TrainingRepository trainingRepository;

	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	TraineeRepository traineeRepository;

	@Autowired
	SkillsRepository skillsRepository;

	@Transactional
	public void setRequestStatus(String mentorName, String traineeName, String techName)
			throws BookingAlreadyExistsException {
		Training training = new Training();
		Integer mentorId = mentorRepository.findByUserID(mentorName).getId();
		Integer traineeId = traineeRepository.findByUserID(traineeName).getId();
		Integer techId = skillsRepository.findBySkillName(techName).getId();
		Training booked = trainingRepository.isAlreadyBooked(mentorId, traineeId, techId);
		if (booked == null) {
			training.setMentorId(mentorRepository.findByUserID(mentorName));
			training.setTraineeId(traineeRepository.findByUserID(traineeName));
			training.setSkillId(skillsRepository.findBySkillName(techName));
			training.setProposalStatus("PENDING");
			trainingRepository.save(training);
		} else {
			throw new BookingAlreadyExistsException();
		}
	}

	@Transactional
	public List<Training> getPendingTrainee(String mentorName) {
		Integer id = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.getPendingList(id);
		// return trainingRepository.findAll();
	}

	@Transactional
	public void getAcceptedTrainees(Integer trainingId) {
		Training training = trainingRepository.findAllById(trainingId);
		training.setProposalStatus("APPROVED");
		trainingRepository.save(training);
	}

	@Transactional
	public void declineRequest(Integer trainingId) {
		Training training = this.trainingRepository.findAllById(trainingId);
		this.trainingRepository.delete(training);

	}

	@Transactional
	public List<Training> getAllTrainings(String mentorName) {

		Integer mentorId = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.findTraineeByMentor(mentorId);
	}

	@Transactional
	public List<Training> getAllTraineeTrainingList(String traineeName) {
		Integer traineeId = traineeRepository.findByUserID(traineeName).getId();
		return trainingRepository.findTraineeByTrainee(traineeId);
	}

	public void completedList(Integer trainingId) {
		Training training = this.trainingRepository.findAllById(trainingId);
		training.setProposalStatus("COMPLETED");
		this.trainingRepository.save(training);

	}

	@Transactional
	public List<Training> getTraineeIncompletedList(String traineeName) {
		Integer traineeId = traineeRepository.findByUserID(traineeName).getId();
		return trainingRepository.getTraineeInCompleteList(traineeId);
	}

	@Transactional
	public List<Training> getTraineecompletedList(String traineeName) {
		Integer traineeId = traineeRepository.findByUserID(traineeName).getId();
		return trainingRepository.getTraineeCompleteList(traineeId);
	}

	@Transactional
	public List<Training> getMentorIncompletedList(String mentorName) {
		Integer mentorId = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.getMentorInCompleteList(mentorId);
	}

	@Transactional
	public List<Training> getMentorcompletedList(String mentorName) {
		Integer mentorId = mentorRepository.findByUserID(mentorName).getId();
		return trainingRepository.getMentorCompleteList(mentorId);
	}

	public void getPaidList(Integer trainingId) {
		Training training = this.trainingRepository.findAllById(trainingId);
		training.setProposalStatus("APPROVEDPAID");
		this.trainingRepository.save(training);

	}

}
