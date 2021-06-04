package com.kodlama.io.hrmsPublic.core.services.verifiers;

import java.util.regex.Pattern;

public class IdentificationNumberValidation {

	public static boolean isValidNumber(String identity) {

		final String trueIdentification = "^[0-9]+$";
		Pattern pattern = Pattern.compile(identity);
		return pattern.matcher(trueIdentification).find();
	}

	public static boolean isValidSize(String identity) {

		if (identity.length() != 11) {
			return false;
		}
		return true;
	}
}
