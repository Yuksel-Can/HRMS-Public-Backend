package com.kodlama.io.hrmsPublic.core.services.verifiers;

import java.util.regex.Pattern;

import com.kodlama.io.hrmsPublic.entities.concrete.Candidate;

public class eMailValidation {
/*
	public static boolean isReal(String eMail) {
		//final String trueMail = "^(.+)@(.+)$";
		final String trueMail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(eMail, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(trueMail).find();
	}
	*/
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		
	public static boolean isReal(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}
}
