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
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee extends User{
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
}
