package com.kodlama.io.hrmsPublic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.WorkingTimeService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.entities.concrete.WorkingTime;

@CrossOrigin
@RestController
@RequestMapping("/api/workingtime")
public class WorkingTimesController {

	private WorkingTimeService workingTimeService;
	
	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		this.workingTimeService = workingTimeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingTime>> getAll(){
		return this.workingTimeService.getAll();
	}
}
