package com.cognizant.trainingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.trainingservice.exception.BookingAlreadyExistsException;
import com.cognizant.trainingservice.model.Training;
import com.cognizant.trainingservice.service.TrainingService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/proposal")
public class TrainingController {

	@Autowired
	TrainingService trainingService;

	@PostMapping("/{mentorName}/{traineeName}/{techName}")
	public void setRequestStatus(@PathVariable("mentorName") String mentorName,
			@PathVariable("traineeName") String traineeName, @PathVariable("techName") String techName)
			throws BookingAlreadyExistsException {
		trainingService.setRequestStatus(mentorName, traineeName, techName);
	}

	@GetMapping("/pending/{mentorName}")
	public List<Training> getPendingTrainee(@PathVariable("mentorName") String mentorName) {
		return trainingService.getPendingTrainee(mentorName);
	}

	@PutMapping("/accepted/{trainingId}")
	public void getAcceptedTrainees(@PathVariable("trainingId") Integer trainingId) {
		trainingService.getAcceptedTrainees(trainingId);
	}

	@DeleteMapping("/decline/{traineeId}")
	public void declineRequest(@PathVariable("traineeId") String trainingId) {
		Integer id = new Integer(trainingId);
		trainingService.declineRequest(id);
	}

	@GetMapping("/all/{mentorName}")
	public List<Training> getAllTrainings(@PathVariable("mentorName") String mentorName) {
		return trainingService.getAllTrainings(mentorName);
	}

	@GetMapping("/trainee/{traineeName}")
	public List<Training> getAllTraineeTrainingList(@PathVariable("traineeName") String traineeName) {
		return trainingService.getAllTraineeTrainingList(traineeName);
	}

	@PutMapping("/pay/{traineeId}")
	public void getPaidList(@PathVariable("traineeId") Integer traineeId) {
		trainingService.getPaidList(traineeId);
	}

	@PutMapping("/completed/{traineeId}")
	public void getCompletedList(@PathVariable("traineeId") Integer traineeId) {
		trainingService.completedList(traineeId);
	}

	@GetMapping("/trainee/complete/{traineeName}")
	public List<Training> getTraineecompletdeList(@PathVariable("traineeName") String traineeName) {
		return trainingService.getTraineecompletedList(traineeName);
	}

	@GetMapping("/trainee/incomplete/{traineeName}")
	public List<Training> getTraineeIncompletedList(@PathVariable("traineeName") String traineeName) {
		System.out.println("entering-------------");
		return trainingService.getTraineeIncompletedList(traineeName);
	}

	@GetMapping("/mentor/complete/{mentorName}")
	public List<Training> getMentorcompletedList(@PathVariable("mentorName") String mentorName) {
		return trainingService.getMentorcompletedList(mentorName);
	}

	@GetMapping("/mentor/incomplete/{mentorName}")
	public List<Training> getMentorIncompleteList(@PathVariable("mentorName") String mentorName) {
		return trainingService.getMentorIncompletedList(mentorName);
	}

}
