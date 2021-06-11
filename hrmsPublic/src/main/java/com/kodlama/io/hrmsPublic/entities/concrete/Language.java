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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Resume.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="resume_id", referencedColumnName="id", nullable=false)
	private Resume resume;
	
	@NotBlank(message="Boş geçilemez")
	@Column(name="language_name")
	private String languageName;
	
	@NotBlank(message="Boş geçilemez")
	@Column(name="language_level")
	private char languageLevel;
	
	@CreationTimestamp
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@UpdateTimestamp
	@JsonIgnore
	@Column(name="update_date")
	private Date updateDate;
}
