package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> add(JobTitle jobTitle);
	DataResult<JobTitle> findById(int id);

}
