package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.JobPostingService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
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
	
	@GetMapping("/sortByDate")
	public DataResult<List<JobPosting>> getAllSortedByDate(){
		return this.jobPostingService.getAllSortedByAndDate();
	}
	
	@GetMapping("/getCompanyName")
	public DataResult<List<JobPosting>> findByIsVisibleAndEmployer_companyName(String companyName){
		return this.jobPostingService.findByIsVisibleAndEmployer(companyName);
	}
	
	@GetMapping("/getCompanyName/{companyName}")
	public DataResult<List<JobPosting>> findByIsVisibleAndEmployer(@PathVariable String companyName){
		return this.jobPostingService.findByIsVisibleAndEmployer(companyName);
	}
	
	@GetMapping("/isActive")
	public DataResult<List<JobPosting>> findByIsVisible(){
		return this.jobPostingService.findByIsVisible();
	}
	
	@PostMapping("/isVisibleClose")
	public Result isVisibleClose(int jobPostingId, int employerId) {
		return this.jobPostingService.isVisibleClose(jobPostingId, employerId);
	}
		
}
