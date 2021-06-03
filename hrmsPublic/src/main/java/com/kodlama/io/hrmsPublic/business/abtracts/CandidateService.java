package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.entities.concrete.Candidate;

public interface CandidateService {
	public DataResult<List<Candidate>> getAll();
	public DataResult<Candidate> add(Candidate candidate);
}
