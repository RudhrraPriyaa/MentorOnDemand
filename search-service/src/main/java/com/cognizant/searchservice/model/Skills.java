package com.cognizant.searchservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Integer id;

	@Column(name = "skill_name")
	private String skillName;

	@Column(name = "skill_toc")
	private String tableOfContents;

	@Column(name = "skill_prerequites")
	private String prerequites;

	@Column(name = "skill_duration")
	private String duration;

	@Column(name = "skill_image")
	private String image;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "skillId")
	@JsonIgnore
	private Set<MentorSkills> mentorSkillList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public String getPrerequites() {
		return prerequites;
	}

	public void setPrerequites(String prerequites) {
		this.prerequites = prerequites;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", skillName=" + skillName + ", tableOfContents=" + tableOfContents
				+ ", prerequites=" + prerequites + ", duration=" + duration + ", image=" + image + "]";
	}

}
