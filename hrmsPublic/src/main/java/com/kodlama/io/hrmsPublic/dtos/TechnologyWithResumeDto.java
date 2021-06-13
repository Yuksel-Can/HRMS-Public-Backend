package com.kodlama.io.hrmsPublic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyWithResumeDto {

	private int id;	//user id
	private String technologyName;
}
