package com.cognizant.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.exception.SkillAlreadyAddedException;
import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.MentorSkills;
import com.cognizant.authenticationservice.model.Trainee;
import com.cognizant.authenticationservice.repository.MentorRepository;
import com.cognizant.authenticationservice.repository.MentorSkillsRepository;
import com.cognizant.authenticationservice.security.AppUserDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	MentorSkillsRepository mentorSkillsRepository;

	@PostMapping("/mentor")
	public String signupMentor(@RequestBody Mentor mentorlist) throws UserAlreadyExistsException {
		return appUserDetailsService.signupMentor(mentorlist);
	}

	@PostMapping("/trainee")
	public String signupTrainee(@RequestBody Trainee traineelist) throws UserAlreadyExistsException {
		return appUserDetailsService.signupTrainee(traineelist);
	}

	@GetMapping("/skills")
	public List<Mentor> getMentors() {
		return mentorRepository.findAll();
	}

	@PostMapping("/mentor/{mentorName}/{skillName}")
	public void addSkill(@PathVariable("mentorName") String mentorName, @PathVariable("skillName") String skillName,
			@RequestBody MentorSkills mentorSkills) throws UserAlreadyExistsException,SkillAlreadyAddedException {
		appUserDetailsService.addSkill(mentorName, skillName, mentorSkills);
	}

	@GetMapping("/mentorSkills")
	public List<MentorSkills> getMentorSkills() {
		return mentorSkillsRepository.findAll();
	}

}
