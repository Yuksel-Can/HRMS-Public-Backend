package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	DataResult<Employer> add(Employer employer);
}
