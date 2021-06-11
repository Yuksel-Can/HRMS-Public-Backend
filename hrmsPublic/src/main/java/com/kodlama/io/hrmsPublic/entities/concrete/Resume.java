package com.kodlama.io.hrmsPublic.entities.concrete;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")	
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations"})		
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations", "jobExperiences", "languages", "technologies"})	
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Candidate.class)	
	@JoinColumn(name="candidate_id", referencedColumnName="id", nullable=false)
	private Candidate candidate;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="photo")
	private String photo;
	
	@CreationTimestamp
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@JsonIgnore
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="is_active")
	@JsonIgnore
	private boolean isActive=true;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume" , fetch = FetchType.LAZY)							
	private List<Education> educations;
	
	@OneToMany(mappedBy = "resume")							
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "resume")							
	private List<Language> languages;
	
	
	@OneToMany(mappedBy = "resume")							
	private List<Technology> technologies;
}
