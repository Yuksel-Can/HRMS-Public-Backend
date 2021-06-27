package com.kodlama.io.hrmsPublic.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrmsPublic.business.abtracts.EmailVerificationService;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;

@CrossOrigin
@RestController
@RequestMapping("/api/email")
public class EmailVerificationsController {

	EmailVerificationService emailVerificationService;
	
	@Autowired
	public EmailVerificationsController(EmailVerificationService emailVerificationService) {
		this.emailVerificationService = emailVerificationService;
	}
	
	@PostMapping("/verify")
	public Result verify( String code) {
		return emailVerificationService.verify(code);
	}
}
