package com.kodlama.io.hrmsPublic.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.EmailVerificationService;
import com.kodlama.io.hrmsPublic.core.utilities.GenerateRandomCode;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.EmailVerificationDao;
import com.kodlama.io.hrmsPublic.entities.abstracts.User;
import com.kodlama.io.hrmsPublic.entities.concrete.EmailVerification;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	EmailVerificationDao emailVerificationDao;
	
	@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		this.emailVerificationDao = emailVerificationDao;
	}
	
	@Override
	public boolean generate(User user, EmailVerification emailVerification) {
		try {
			emailVerification.setCode(GenerateRandomCode.generate());
			emailVerification.setVerified(false);
			emailVerification.setUserId(user.getId());
			emailVerificationDao.save(emailVerification);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
