//package com.kodlama.io.hrmsPublic.entities.concrete;
//
//import java.sql.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;
//
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name="resumes")	
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","education"})		
//public class Resume {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//	
//	@ManyToOne(targetEntity=Candidate.class)	//bir kişinin 1 cv si olsun istersek OneToOne yapılır
//	@JoinColumn(name="candidate_id", referencedColumnName="id", nullable=false)
//	private Candidate candidate;
//	
//	@Column(name="github_link")
//	private String githubLink;
//	
//	@Column(name="linked_link")
//	private String linkedinLink;
//	
//	@Column(name="photo")
//	private String photo;
//	
//	@Column(name="descrition")
//	private String description;
//	
//	@Column(name="created_date")
//	private Date createdDate;
//	
//	@Column(name="update_date")
//	private Date updateDate;
//	
//	@Column(name="is_active")
//	private boolean isActive=true;
//	
//	@OneToMany(mappedBy = "resume")							
//	private List<Language> languages;	//git al gel demektir
//	
//	@OneToMany(mappedBy = "resume")							
//	private List<Technology> technologies;
//	
//	@OneToMany(mappedBy = "resume")							
//	private List<Education> education;
//	
//	@OneToMany(mappedBy = "resume")							
//	private List<JobExperience> jobExperiences;
//}
