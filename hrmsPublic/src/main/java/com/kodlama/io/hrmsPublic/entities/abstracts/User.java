package com.kodlama.io.hrmsPublic.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
//@AllArgsConstructor		//uer kısmına constructor koymamak önemli
//@NoArgsConstructor

@Inheritance(strategy =InheritanceType.JOINED)	
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})		

public abstract class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email_address")
	@Email(message="Lütfen Geçerli bir mail adresi giriniz")
	@NotBlank
	private String email;
	
	@Column(name="password")
	@NotBlank
	@Size(min=6, max=16, message ="Şifre en az 6, en fazla 16 karakterden oluşabilir")
	private String password;
	
	@Transient		//veri tabanına yazmıyor
	@NotBlank(message ="Şifre Alanı Boş olamaz")
	@JsonProperty(access = Access.WRITE_ONLY)	//bana sadece yazarken göster demektir
	private String passwordRepeat;
	
}

