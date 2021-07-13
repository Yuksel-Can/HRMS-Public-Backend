package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.WayOfWorkingService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.WayOfWorking;

@CrossOrigin
@RestController
@RequestMapping("/api/wayofworking")
public class WayOfWorkingsController {

	WayOfWorkingService wayOfWorkingService;
	
	@Autowired
	public WayOfWorkingsController(WayOfWorkingService wayOfWorkingService) {
		this.wayOfWorkingService = wayOfWorkingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WayOfWorking>> getAll(){
		return this.wayOfWorkingService.getAll();
	}
}
