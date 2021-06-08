package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

	 List<JobPosting> findByIsVisibleAndEmployer_companyName(boolean isVisible, String companyName);
	 List<JobPosting> findByIsVisible(boolean isVisible);
	 List<JobPosting> findByEmployer_companyName(String companyName);
	 JobPosting findByIdAndEmployer_id(int id, int EmployerId);
}
