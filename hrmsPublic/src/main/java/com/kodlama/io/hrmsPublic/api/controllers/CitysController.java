package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.CandidateService;
import com.kodlama.io.hrmsPublic.business.abtracts.CityService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.Candidate;
import com.kodlama.io.hrmsPublic.entities.concrete.City;

@CrossOrigin
@RestController
@RequestMapping("/api/city")
public class CitysController {
	CityService cityService;
	
	@Autowired
	public CitysController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return cityService.getAll();
	}
}
