package com.kodlama.io.hrmsPublic.entities.concrete;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodlama.io.hrmsPublic.entities.abstracts.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")

//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})		
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})			

public class Candidate  extends User{
	
	@NotBlank(message="İsim boş olamaz")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message="Soyisim Boş olamaz")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message="TC Kimlik Numarası Alanı Boş Olamaz") 
	@Size(min = 11, max=11, message = "TCKimlik No 11 hane olmalıdır")
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@NotBlank(message="Doğum Yılı Alanı Boş Olamaz")
	@Column(name = "birth_date")
	private Date birthDate;  
	
	
}