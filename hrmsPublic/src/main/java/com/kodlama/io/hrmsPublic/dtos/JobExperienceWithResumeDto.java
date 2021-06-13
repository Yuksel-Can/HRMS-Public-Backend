package com.kodlama.io.hrmsPublic.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceWithResumeDto {

	private int id;
	private String companyName;
	private String positionName;
	private Date startedDate;
	private Date endedDate;	
	private Date updateDate;

}
