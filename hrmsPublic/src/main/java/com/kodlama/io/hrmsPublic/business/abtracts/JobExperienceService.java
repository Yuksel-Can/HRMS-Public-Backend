package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.dtos.JobExperienceWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.JobExperience;

public interface JobExperienceService {

	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAll();
	DataResult<	List<JobExperienceWithResumeDto>> getJobExperienceDetailsWithResumeOrderByDesc(int id);

}
