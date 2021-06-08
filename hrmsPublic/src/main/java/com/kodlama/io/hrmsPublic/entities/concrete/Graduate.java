//package com.kodlama.io.hrmsPublic.entities.concrete;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
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
//@Table(name="edu_graduates")
//public class Graduate {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//	
//	@Column(name="description")
//	@NotBlank(message = "Bu alan boş bırakılamaz")	   //ikisinide yapar hem boşluk hem null
//	private String description;
//	
//	/*
//	@OneToMany(mappedBy ="resume_id")
//	private List<Resume>  .. .... .
//	*/
//}
//
////db de yok daha