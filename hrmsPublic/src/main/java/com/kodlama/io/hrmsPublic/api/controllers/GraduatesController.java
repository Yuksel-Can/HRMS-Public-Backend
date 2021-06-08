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
//import com.kodlama.io.hrmsPublic.business.abtracts.GraduateService;
//import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
//import com.kodlama.io.hrmsPublic.entities.concrete.Graduate;
//
//@RestController
//@RequestMapping("all/graduate")
//public class GraduatesController {
//
//	private GraduateService graduateService;
//	
//	
//	@Autowired
//	public GraduatesController(GraduateService graduateService) {
//		super();
//		this.graduateService = graduateService;
//	}
//
//
//
//	@GetMapping("/getall")
//	public DataResult<List<Graduate>> getAll(){
//		return this.graduateService.getAll();
//	}
//	
//	@GetMapping("/add")
//	public Result add(@Valid @RequestBody Graduate graduate) {
//		return this.graduateService.add(graduate);
//	}
//	
//}
