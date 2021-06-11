package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.EducationService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.entities.concrete.Education;

@RestController
@RequestMapping("/api/education")
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Education education) {
		return this.educationService.add(education);
		
	}
	/*
	@GetMapping("/getbyid")
	public DataResult<List<Education>> getEducationOrderByEndedDateDESC(@RequestParam int id){
		return this.educationService.getEducationOrderByEndedDateDESC(id);
	}
	*/
	/*
	@GetMapping("/getCandidateSchoolsByGraduationDateDesc")
	public DataResult<List<Education>> orderCvEducationsByGraduationYearDesc(int id) {
		return this.educationService.orderCvEducationsByGraduationYearDesc(id);
	}
	*/
	@GetMapping("/getnames")
	public DataResult<List<Education>> namesEducation(@RequestParam int id){
		return this.educationService.namesEducation(id);
	}
	
	
	@GetMapping("/getnames2")
	public DataResult<List<Education>> namesEducation2(@RequestParam int id){
		return this.educationService.namesEducation2(id);
	}
}
