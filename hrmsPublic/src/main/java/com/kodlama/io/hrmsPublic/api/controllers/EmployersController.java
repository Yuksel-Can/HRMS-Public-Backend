package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.EmployerService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.Employer;

@CrossOrigin
@RestController
@RequestMapping("/api/employer")
public class EmployersController {

	EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return employerService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<Employer> add(@RequestBody Employer employer){
		return employerService.add(employer);
	}
	@GetMapping("/findById")
	public DataResult<Employer> findById(@RequestParam int id){
		return employerService.findById(id);
	}
}
