package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.entities.concrete.EducationLevel;

public interface EducationLevelService {
	
	DataResult<List<EducationLevel>> getAll();
	Result add(EducationLevel educationLevel);
	
	
}
