package com.cognizant.trainingservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mentor")
public class Mentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mentor_id")
	private Integer id;

	@Column(name = "mentor_name")
	@Size(min = 4, max = 15, message = "Username should be within 4-50 characters")
	private String mentorName;

	@Column(name = "mentor_last_name")
	@Size(min = 4, max = 15, message = "Last Name should be within 4-50 characters")
	private String mentorLastName;

	@Column(name = "mentor_first_name")
	@Size(min = 4, max = 15, message = "First Name should be within 4-50 characters")
	private String mentorFirstName;

	@Column(name = "mentor_contact")
	private String mentorContact;

	@Column(name = "mentor_linkedinUrl")
	private String linkedinUrl;

	@Column(name = "mentor_yearsOfExp")
	private Long yearsOfExperience;

	@Column(name = "mentor_password")
	private String password;

	@Column(name = "mentor_confirm_password")
	private String confirmPassword;

	@Column(name = "mentor_email")
	private String email;

	@Column(name = "mentor_active")
	private Boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mentorId")
	private Set<MentorSkills> mentorSkillsSet;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mentorId")
	@JsonIgnore
	private Set<Training> mentorsList;

	public Set<Training> getMentorsList() {
		return mentorsList;
	}

	public void setMentorsList(Set<Training> mentorsList) {
		this.mentorsList = mentorsList;
	}

	public Set<MentorSkills> getMentorSkillsSet() {
		return mentorSkillsSet;
	}

	public void setMentorSkillsSet(Set<MentorSkills> mentorSkillsSet) {
		this.mentorSkillsSet = mentorSkillsSet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getMentorLastName() {
		return mentorLastName;
	}

	public void setMentorLastName(String mentorLastName) {
		this.mentorLastName = mentorLastName;
	}

	public String getMentorFirstName() {
		return mentorFirstName;
	}

	public void setMentorFirstName(String mentorFirstName) {
		this.mentorFirstName = mentorFirstName;
	}

	public String getMentorContact() {
		return mentorContact;
	}

	public void setMentorContact(String mentorContact) {
		this.mentorContact = mentorContact;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public Long getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Long yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	// public Set<MentorSkills> getMentorSkillsSet() {
	// return mentorSkillsSet;
	// }
	//
	// public void setMentorSkillsSet(Set<MentorSkills> mentorSkillsSet) {
	// this.mentorSkillsSet = mentorSkillsSet;
	// }

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", mentorName=" + mentorName + ", mentorLastName=" + mentorLastName
				+ ", mentorFirstName=" + mentorFirstName + ", mentorContact=" + mentorContact + ", linkedinUrl="
				+ linkedinUrl + ", yearsOfExperience=" + yearsOfExperience + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", email=" + email + ", active=" + active + "]";
	}

}
