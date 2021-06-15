package com.kodlama.io.hrmsPublic.dtos;

//import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import com.kodlama.io.hrmsPublic.entities.concrete.EducationLevel;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EducationWithResumeDto {


	private int id;		//resume id
	private String schoolName;

	private String departmentName;
	private String levelName;
	private Date startedDate;
	private Date endedDate;
	private Date updateDate;
	
	
}
