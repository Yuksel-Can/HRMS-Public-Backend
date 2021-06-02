package com.kodlama.io.hrmsPublic.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kodlama.io.hrmsPublic.entities.abstracts.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User {

	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_address")
	private String webAddress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
}