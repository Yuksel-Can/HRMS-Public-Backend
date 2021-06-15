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

import com.kodlama.io.hrmsPublic.business.abtracts.LanguageService;
import com.kodlama.io.hrmsPublic.business.abtracts.TechnologyService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.dtos.TechnologyWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Language;
import com.kodlama.io.hrmsPublic.entities.concrete.Technology;

@RestController
@RequestMapping("/api/technology")
public class TechnologysController {
	
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologysController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	public DataResult<List<Technology>> getAll(){
		return this.technologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Technology technology) {
		return this.technologyService.add(technology);
		
	}

	@GetMapping("/getJobExperienceDetailsWithResumeOrderByDesc")
	public DataResult<List<TechnologyWithResumeDto>> getJobExperienceDetailsWithResumeOrderByDesc(@RequestParam int id){
		return this.technologyService.getJobExperienceDetailsWithResumeOrderByDesc(id);
	}
}
