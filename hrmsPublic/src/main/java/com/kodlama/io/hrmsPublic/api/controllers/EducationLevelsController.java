package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.EducationLevelService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.entities.concrete.EducationLevel;

@CrossOrigin
@RestController
@RequestMapping("/api/educationlevel")
public class EducationLevelsController {

	private EducationLevelService educationLevelService;
	
	
	@Autowired
	public EducationLevelsController(EducationLevelService educationLevelService) {
		this.educationLevelService = educationLevelService;
	}



	@GetMapping("/getall")
	public DataResult<List<EducationLevel>> getAll(){
		return this.educationLevelService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EducationLevel educationLevel) {
		return this.educationLevelService.add(educationLevel);
	}
	
}
