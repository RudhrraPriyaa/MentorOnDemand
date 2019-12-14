package com.cognizant.trainingservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trainee")
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trainee_id")
	private Integer id;

	@Column(name = "trainee_name")
	@Size(min = 4, max = 15, message = "Username should be within 4-50 characters")
	private String traineeName;

	@Column(name = "trainee_last_name")
	@Size(min = 4, max = 15, message = "Last Name should be within 4-50 characters")
	private String traineeLastName;

	@Column(name = "trainee_first_name")
	@Size(min = 4, max = 15, message = "First Name should be within 4-50 characters")
	private String traineeFirstName;

	@Column(name = "trainee_contact")
	private String traineeContact;

	@Column(name = "trainee_password")
	private String password;

	@Column(name = "trainee_confirm_password")
	private String confirmPassword;

	@Column(name = "trainee_email")
	private String email;

	@OneToMany(mappedBy = "traineeId")
	@JsonIgnore
	private Set<Training> traineeList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeLastName() {
		return traineeLastName;
	}

	public void setTraineeLastName(String traineeLastName) {
		this.traineeLastName = traineeLastName;
	}

	public String getTraineeFirstName() {
		return traineeFirstName;
	}

	public void setTraineeFirstName(String traineeFirstName) {
		this.traineeFirstName = traineeFirstName;
	}

	public String getTraineeContact() {
		return traineeContact;
	}

	public void setTraineeContact(String traineeContact) {
		this.traineeContact = traineeContact;
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

}
