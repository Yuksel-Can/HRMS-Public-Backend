package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.dtos.JobExperienceWithResumeDto;
import com.kodlama.io.hrmsPublic.dtos.TechnologyWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Technology;

public interface TechnologyService {

	Result add(Technology technology);
	DataResult<List<Technology>> getAll();
	DataResult<List<TechnologyWithResumeDto>> getJobExperienceDetailsWithResumeOrderByDesc(int id);

}
