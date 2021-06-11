package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlama.io.hrmsPublic.business.abtracts.JobExperienceService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.entities.concrete.JobExperience;

@RestController
@RequestMapping("/api/jobexperience")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		this.jobExperienceService = jobExperienceService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
		
	}
	
	
}
