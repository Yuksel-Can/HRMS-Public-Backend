package com.kodlama.io.hrmsPublic.entities.concrete;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Resume.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@NotBlank(message="Boş geçilemez")
	@Column(name="company_name")
	private String companyName;
	
	//@ManyToOne(targetEntity=JobTitle.class, fetch = FetchType.LAZY,optional = false)
	//@JoinColumn(name="job_position_id", referencedColumnName="id", nullable=false)		//bağlanacakları kısmı belirtiyor
	
	@NotBlank(message="Boş geçilemez")
	@Column(name="position_name")
	private String positionName;
	

	//@Temporal(TemporalType.DATE)		//ikiside oluyor		//util.date den alınır
	//@CreationTimestamp				//ikiide oluyor

	
	@NotBlank(message="Boş geçilemez")
	@Column(name="started_date")
	private Date startedDate;		//date i java sql den almak zorundasın
	
	@Column(name="ended_date")
	private Date endedDate;	
	
	@CreationTimestamp
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@JsonIgnore
	@Column(name="update_date")
	private Date updateDate;
}
