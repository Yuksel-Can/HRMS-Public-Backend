package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.CandidateService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.Candidate;

@RestController
@RequestMapping("/api/candidate")
public class CandidatesController {

	CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall2")
	public DataResult<List<Candidate>> getAll(){
		return candidateService.getAll();
	}
	@PostMapping("/add")
	public DataResult<Candidate> add(@RequestBody Candidate candidate){
		
		return candidateService.add(candidate);
	}
}
