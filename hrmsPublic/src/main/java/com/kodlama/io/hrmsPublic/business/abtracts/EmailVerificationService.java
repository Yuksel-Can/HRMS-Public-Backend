package com.kodlama.io.hrmsPublic.business.abtracts;

import com.kodlama.io.hrmsPublic.entities.abstracts.User;
import com.kodlama.io.hrmsPublic.entities.concrete.EmailVerification;

public interface EmailVerificationService {

	public boolean generate(User user, EmailVerification emailVerification);
}
