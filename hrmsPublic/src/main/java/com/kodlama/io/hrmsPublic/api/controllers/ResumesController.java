//package com.kodlama.io.hrmsPublic.api.controllers;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.kodlama.io.hrmsPublic.business.abtracts.ResumeService;
//import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
//import com.kodlama.io.hrmsPublic.entities.concrete.Graduate;
//import com.kodlama.io.hrmsPublic.entities.concrete.Resume;
//
//@RestController
//@RequestMapping("/api/resumes")
//public class ResumesController {
//
//	private ResumeService resumeService;
//	
//	@Autowired
//	public ResumesController(ResumeService resumeService) {
//		super();
//		this.resumeService = resumeService;
//	}
//
//	@GetMapping("/getall")
//	public DataResult<List<Resume>> getAll(){
//		return this.resumeService.getAll();
//	}
//	
//	@GetMapping("/add")
//	public Result add(@Valid @RequestBody Resume resume) {
//		return this.resumeService.add(resume);
//		
//	}
//}
