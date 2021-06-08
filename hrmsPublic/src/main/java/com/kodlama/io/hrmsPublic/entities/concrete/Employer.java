package com.kodlama.io.hrmsPublic.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name=" employers")

@PrimaryKeyJoinColumn (name=" id")


public class Employer extends User {//üst kısım user_id olabilir

	@NotBlank(message="Şirket İsmi Boş Olamaz")
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message="Web Sitesi Boş Olamaz")
	@Column(name = "web_address")
	private String webAddress;
	
	@NotBlank(message="Telefon Numarası Alanı Boş Olamaz")
	@Column(name = "phone_number")
	private String phoneNumber;
}