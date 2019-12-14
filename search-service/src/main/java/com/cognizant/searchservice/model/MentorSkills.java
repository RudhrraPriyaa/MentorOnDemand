package com.cognizant.searchservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mentor_skills")
public class MentorSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ms_id")
	private Integer mentorSkillId;

	@Column(name = "Rating")
	private Integer rating;

	@Column(name = "years_of_exp")
	private Integer yearsOfExperience;

	@Column(name = "training_delivered")
	private Integer trainingdelivered;

	@Column(name = "facilities_offered")
	private String facilitiesOffered;

	public String getFacilitiesOffered() {
		return facilitiesOffered;
	}

	public void setFacilitiesOffered(String facilitiesOffered) {
		this.facilitiesOffered = facilitiesOffered;
	}

	@ManyToOne
	@JoinColumn(name = "ms_mentor_id")
	Mentor mentorId;

	@ManyToOne
	@JoinColumn(name = "ms_skill_id")
	Skills skillId;

	public Integer getMentorSkillId() {
		return mentorSkillId;
	}

	public void setMentorSkillId(Integer mentorSkillId) {
		this.mentorSkillId = mentorSkillId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Integer getTrainingdelivered() {
		return trainingdelivered;
	}

	public void setTrainingdelivered(Integer trainingdelivered) {
		this.trainingdelivered = trainingdelivered;
	}

	public Mentor getMentorId() {
		return mentorId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	public Skills getSkillId() {
		return skillId;
	}

	public void setSkillId(Skills skillId) {
		this.skillId = skillId;
	}

	@Override
	public String toString() {
		return "MentorSkills [mentorSkillId=" + mentorSkillId + ", rating=" + rating + ", yearsOfExperience="
				+ yearsOfExperience + ", trainingdelivered=" + trainingdelivered + ", facilitiesOffered="
				+ facilitiesOffered + ", mentorId=" + mentorId + ", skillId=" + skillId + "]";
	}

}
