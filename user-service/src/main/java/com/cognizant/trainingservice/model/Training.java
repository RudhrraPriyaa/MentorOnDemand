package com.cognizant.trainingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tg_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "tg_me_id")
	private Mentor mentorId;

	@ManyToOne
	@JoinColumn(name = "tg_tr_id")
	private Trainee traineeId;

	@ManyToOne
	@JoinColumn(name = "tg_te_id")
	private Skills skillId;

	public Skills getSkillId() {
		return skillId;
	}

	public void setSkillId(Skills skillId) {
		this.skillId = skillId;
	}

	@Column(name = "tg_status")
	private String proposalStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mentor getMentorId() {
		return mentorId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	public Trainee getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Trainee traineeId) {
		this.traineeId = traineeId;
	}

	public String getProposalStatus() {
		return proposalStatus;
	}

	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	@Override
	public String toString() {
		return "MentorTrainee [id=" + id + ", mentorId=" + mentorId + ", traineeId=" + traineeId + ", proposalStatus="
				+ proposalStatus + "]";
	}

}