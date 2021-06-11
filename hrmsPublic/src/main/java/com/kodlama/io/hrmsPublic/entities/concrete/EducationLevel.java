package com.kodlama.io.hrmsPublic.entities.concrete;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="education_level")	
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "educations"})		
public class EducationLevel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="level_name")
	@NotBlank(message = "Bu alan boş bırakılamaz")	   //ikisinide yapar hem boşluk hem null
	private String levelName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "educationLevel")							
	private List<Education> educations;
	
	
	
}