package com.kodlama.io.hrmsPublic.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlama.io.hrmsPublic.entities.abstracts.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="verification_codes")
public class EmailVerification{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;
	
	@JsonIgnore
	@Column(name="code")
	private String code;
	
	@JsonIgnore
	@Column(name="is_verified")
	private boolean isVerified;
	
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	@JsonIgnore
	private User userId;
	
	
	
	
	public boolean isVerified() {
		return this.isVerified;
	}
	
}
