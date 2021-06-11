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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","edu"})		
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)	//sadece yazarken getirir bu sutunu yani add yaoarken getirir
	@ManyToOne(targetEntity=Resume.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="resume_id", referencedColumnName="id", nullable=false)		//bağlanacakları kısmı belirtiyor
	private Resume resume;
	
	/* Önemli */
	@ManyToOne(targetEntity=EducationLevel.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="educationLevel_id", referencedColumnName="id", nullable=false)		//bağlanacakları kısmı belirtiyor
	private EducationLevel educationLevel;
	/* Önemli */
	
	@Column(name="school_name")
	@NotBlank(message="Boş geçilemez")
	private String schoolName;
	
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="started_date")
	@NotBlank(message="Boş geçilemez")
	private Date startedDate;
	
	@Column(name="ended_date")
	private Date endedDate;

	//@Temporal			//kayıt oluştururkenki tarih ve saati kendisi yazıyor
	@NotBlank(message="Boş geçilemez")
	@CreationTimestamp
	//@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="update_date")
	private Date updateDate;
}