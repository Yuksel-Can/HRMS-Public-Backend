package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.entities.concrete.JobPosting;

public interface JobPostingService {

	DataResult<List<JobPosting>> getAll();
	DataResult<JobPosting> add(JobPosting jobPosting);
	DataResult<List<JobPosting>> getAllSortedByAndDateDESC();
	DataResult<List<JobPosting>> getAllSortedByAndDateASC();
	DataResult<List<JobPosting>> findByIsVisibleAndEmployer(String companyName);
	DataResult<List<JobPosting>> findByIsVisible();
	//DataResult<List<JobPosting>> findByOrderByEndedDateAscAndIsVisible();
	
	Result isVisibleClose(int id, int employerId);
	
	 DataResult<List<JobPosting>> findByIsVisibleAndWayOfWorking(String wayOfWorking);
}
