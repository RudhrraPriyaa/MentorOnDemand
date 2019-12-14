package com.cognizant.technologyservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.technologyservices.model.Skills;
import com.cognizant.technologyservices.repository.SkillsRepository;
import com.cognizant.technologyservices.service.SkillsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class SkillsController {

	@Autowired
	SkillsService skillsService;

	@Autowired
	SkillsRepository skillsRepository;

	@GetMapping("/allSkills")
	public List<Skills> getAllSkills() {
		return skillsRepository.findAll();
	}
}
