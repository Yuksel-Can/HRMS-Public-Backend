//package com.kodlama.io.hrmsPublic.entities.concrete;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name="resume_techs")
//public class Technology {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//	
//	@ManyToOne(targetEntity = Resume.class)
//	@JoinColumn(name="resume_id")
//	private Resume resume;
//	
//	@Column(name="description")
//	@NotBlank(message="boş geçilemez")
//	private String description;
//	
//	@Column(name="created_date")
//	private Date createDate;
//}
