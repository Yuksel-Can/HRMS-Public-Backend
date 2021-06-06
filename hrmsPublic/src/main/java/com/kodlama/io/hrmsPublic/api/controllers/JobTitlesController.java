package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.JobTitleService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.JobTitle;

@RestController
@RequestMapping("/api/jobtitle")
public class JobTitlesController {

	JobTitleService jobTitleService;
	
	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll(){
		return jobTitleService.getAll();
	}
	@PostMapping("/add")
	public DataResult<JobTitle> add(@RequestBody JobTitle jobTitle){
		return jobTitleService.add(jobTitle);
	}
	
}
