package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.EmailVerificationService;
import com.kodlama.io.hrmsPublic.business.abtracts.EmployerService;
import com.kodlama.io.hrmsPublic.business.abtracts.UserService;
import com.kodlama.io.hrmsPublic.core.services.verifiers.eMailValidation;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.EmployerDao;
import com.kodlama.io.hrmsPublic.entities.concrete.Candidate;
import com.kodlama.io.hrmsPublic.entities.concrete.EmailVerification;
import com.kodlama.io.hrmsPublic.entities.concrete.Employer;

@Service
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	UserService userService;
	EmailVerificationService emailVerificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService, EmailVerificationService emailVerificationService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailVerificationService = emailVerificationService;
		
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "İş Veren Listeleme İşlemi Başarılı");
	}

	@Override
	public DataResult<Employer> add(Employer employer) {

		if(!companyNameinEmpty(employer)) {
			return new ErrorDataResult<Employer>(employer, "Şirket Adı Boş Olamaz");
		}
		if(!webAddressisEmpty(employer)) {
			return new ErrorDataResult<Employer>(employer, "Web Adresi Alanı Boş Olamaz");
		}
		if(!eMailisEmpty(employer)) {
			return new ErrorDataResult<Employer>(employer,"E Mail Boş Olamaz");
		}
		if(!passwordisEmpty(employer)) {
			return new ErrorDataResult<Employer>(employer,"Şifre Alanı Olamaz");
		}
		if(!phoneNumberisEmpty(employer)) {
			return new ErrorDataResult<Employer>(employer,"Telefon Alanı Olamaz");
		}
		if(!eMailValidation.isRealUser(employer.getEmail())) {
			return new ErrorDataResult<Employer>(employer,"Geçersiz E Mail Girilemez");
		}
		
		if(this.employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0){
			return new ErrorDataResult<Employer>(employer, "Bu Mail Adresi Daha Önce Kayıt Edilmiş");
		}
			
		if(!eMailValidation.isRealCompany(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorDataResult<Employer>(employer, "Mail, Web Sitesi ile aynı domaine sahip olmalıdır");
		}
		if(!phoneNumberisValid(employer)) {
			return new ErrorDataResult<Employer>(employer, "Telefon Numarası Geçersiz");
		}
		
		
		
		
		this.employerDao.save(employer);
		if(!this.emailVerificationService.generate(employer, new EmailVerification())) {
			return new ErrorDataResult<Employer>(employer, "Email Doğrulama Kodu Oluşturulurken Hata Oluştu");
		}
		return new SuccessDataResult<Employer>(employer, "İş veren Ekleme Başarılı, Doğrulama Kodu Gönderildi");

		//***//
		/*
		this.userService.add(employer);
		
		if(!this.emailVerificationService.generate(employer, new EmailVerification())) {
			return new ErrorDataResult<Employer>(employer, "Email Doğrulama Kodu Oluşturulurken Hata Oluştu");
		}
		
		this.employerDao.save(employer);
		
		return new SuccessDataResult<Employer>(employer, "İş veren Ekleme Başarılı, Doğrulama Kodu Gönderildi");
		*/
		//***//
	}

	
	private boolean companyNameinEmpty(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	private boolean webAddressisEmpty(Employer employer) {
		if(employer.getWebAddress().isBlank() || employer.getWebAddress().equals(null)) {
			return false;
		}
		return true;
	}
	private boolean eMailisEmpty(Employer employer) {
		if(employer.getEmail().isBlank() || employer.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	private boolean passwordisEmpty(Employer employer) {
		if(employer.getPassword().isBlank() || employer.getPassword().equals(null)) {
			return false;
		}
		return true;
	}
	private boolean phoneNumberisEmpty(Employer employer) {
		if(employer.getPhoneNumber().isBlank() || employer.getPhoneNumber().equals(null)) {
			return false;
		}
		return true;
	}
	private boolean phoneNumberisValid(Employer employer) {
		if((employer.getPhoneNumber().length() == 11) || (employer.getPhoneNumber().length() == 10)){
			String truePhone =  "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
				      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
				      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
			Pattern pattern = Pattern.compile(truePhone);
			return pattern.matcher(employer.getPhoneNumber()).find();
		}
		return false;
	}

	@Override
	public DataResult<Employer> findById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id), "Aranan işveren listelendi");
	}
}
