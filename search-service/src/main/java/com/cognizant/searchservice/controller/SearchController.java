package com.cognizant.searchservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.searchservice.model.MentorSkills;
import com.cognizant.searchservice.service.SearchService;

@RestController
@RequestMapping("/search")
@CrossOrigin("http://localhost:4200")
public class SearchController {

	@Autowired
	SearchService searchService;

	@GetMapping("/{skillName}")
	public List<MentorSkills> search(@PathVariable("skillName") String skillName) {
		return searchService.search(skillName);
	}

	@GetMapping("")
	public List<MentorSkills> searchAll() {
		return searchService.searchAll();
	}
}