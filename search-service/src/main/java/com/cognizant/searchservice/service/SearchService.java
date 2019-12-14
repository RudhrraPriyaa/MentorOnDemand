package com.cognizant.searchservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.searchservice.model.MentorSkills;
import com.cognizant.searchservice.model.Skills;
import com.cognizant.searchservice.repository.MentorSkillsRepository;
import com.cognizant.searchservice.repository.SkillsRepository;

@Service
public class SearchService {

	@Autowired
	MentorSkillsRepository mentorSkillsRepository;

	@Autowired
	SkillsRepository skillsRepository;

	public List<MentorSkills> search(String skillName) {
		Skills skills = skillsRepository.findBySkillName(skillName);
		long id = skills.getId();
		return mentorSkillsRepository.getBySkillID(id);

	}
	
	public List<MentorSkills> searchAll() {
		return mentorSkillsRepository.findAll();
	}
}
