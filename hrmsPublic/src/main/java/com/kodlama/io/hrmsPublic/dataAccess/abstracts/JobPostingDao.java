package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

	 List<JobPosting> findByIsVisibleAndEmployer_companyName(boolean isVisible, String companyName);
	 List<JobPosting> findByIsVisible(boolean isVisible,Sort sort);
	 List<JobPosting> findByEmployer_companyName(String companyName);
	 JobPosting findByIdAndEmployer_id(int id, int EmployerId);
	 List<JobPosting> findByIsVisibleAndWayOfWorking(boolean isVisible, String wayOfWorking);
	 //List<JobPosting> findByIsVisibleAndOrderByEndedDateAsc(boolean isVisible);
}
