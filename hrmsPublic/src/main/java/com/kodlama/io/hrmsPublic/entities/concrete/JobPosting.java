package com.kodlama.io.hrmsPublic.entities.concrete;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_postings")
public class JobPosting {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=Employer.class)
	@JoinColumn(name="employer_id", referencedColumnName="id", nullable=false)
	private Employer employer; //employerId;
	

	@ManyToOne(targetEntity = JobTitle.class)
	@JoinColumn(name="job_title_id", referencedColumnName = "id", nullable=false)
	private JobTitle jobTitle;
	
	@NotBlank(message = "Açıklama alanı boş bırakılamaz")
	@Column(name="description")
	private String description;
	
	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
	private City city;
	
	@Column(name="min_salary")
	private String minSalary;
	
	@Column(name="max_salary")
	private String maxSalary;
	
	@NotBlank(message = "Açık pozisyon alanı boş bırakılamaz")
	@Column(name="open_position")
	private int openPosition;
	
	
	@CreationTimestamp
	@Column(name="started_date")
	private Date startedDate;
	
	@NotBlank(message ="İlan bitiş alanı boş bırakılamaz")
	@Column(name="ended_date")
	private Date endedDate;
	
	
	@Column(name="is_visible")
	private boolean isVisible=false;
	
	//update project ( way of working added)
	//@NotBlank(message ="Çalışma biçimi boş bırakılamaz")
	//@Column(name="way_of_working")
	//private String wayOfWorking2;
	
	@ManyToOne(targetEntity = WayOfWorking.class)
	@JoinColumn(name="way_of_working_id", referencedColumnName = "id", nullable=false)
	private WayOfWorking wayOfWorking;
	
	@ManyToOne(targetEntity = WorkingTime.class) 
	@JoinColumn(name="working_time_id", referencedColumnName = "id", nullable=false)
	private WorkingTime workingTime;

}
