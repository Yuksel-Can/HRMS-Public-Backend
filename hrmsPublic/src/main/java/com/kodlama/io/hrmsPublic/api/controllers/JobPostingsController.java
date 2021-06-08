package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.JobPostingService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.JobPosting;

@RestController
@RequestMapping("/api/jobposting")
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<JobPosting> add(@RequestBody JobPosting jobPosting){
		return this.jobPostingService.add(jobPosting);
	}
}
