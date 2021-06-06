package com.kodlama.io.hrmsPublic.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.EmailVerificationService;
import com.kodlama.io.hrmsPublic.core.utilities.GenerateRandomCode;
import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
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
	@Override
	public Result verify(String code) {
		if(code.length()==0) {
			return new ErrorResult("Mail Doğrulama Kod Alanı Boş Olamaz");
		}
		if(this.emailVerificationDao.findAllByCode(code.trim()).stream().count() ==0) {
			return new ErrorResult("Mail Doğrulama Kodu Bulunamadı");
		}
		EmailVerification emailVerification = this.emailVerificationDao.getByCode(code);
		if(emailVerification.isVerified() ==true) {
			return new ErrorResult("Mail Doğrulama Daha Önceden Yapılmıştır");
		}
		emailVerification.setVerified(true);
		emailVerificationDao.save(emailVerification);
		return new SuccessResult("Mail Doğrulama İşlemi Başarılı Sayın:"+emailVerification.getUserId());
	}

}
