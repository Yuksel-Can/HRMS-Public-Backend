package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.CandidateService;
import com.kodlama.io.hrmsPublic.business.abtracts.EmailVerificationService;
import com.kodlama.io.hrmsPublic.business.abtracts.UserService;
import com.kodlama.io.hrmsPublic.core.services.verifiers.FakeMernis;
import com.kodlama.io.hrmsPublic.core.services.verifiers.IdentificationNumberValidation;
import com.kodlama.io.hrmsPublic.core.services.verifiers.eMailValidation;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.CandidateDao;
import com.kodlama.io.hrmsPublic.entities.abstracts.User;
import com.kodlama.io.hrmsPublic.entities.concrete.Candidate;
import com.kodlama.io.hrmsPublic.entities.concrete.EmailVerification;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidatoDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailVerificationService emailVerificationService, UserService userService) {
		this.candidatoDao = candidateDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidatoDao.findAll(),"Tüm Adaylar Başarıyla Listelendi	");
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {

		if(!firstNameisEmpyt(candidate)) {
			return new ErrorDataResult<Candidate>(candidate,"Ad Boş Bırakılamaz");
		}
		if(!lastNameisEmpty(candidate)) {
			return new ErrorDataResult<Candidate>(candidate,"Soyad Boş Bırakılamaz");
		}
		if(!identificationNumberisEmpty(candidate) || identificationNumberisValid(candidate)) {
			return new ErrorDataResult<Candidate>(candidate,"TC Kimlik No Boş Bırakılamaz");
		}
		if(!birthDateisEmpty(candidate)) {
			return new ErrorDataResult<Candidate>(candidate,"Doğum Tarih Bilgisi Boş Bırakılamaz");
		}
		if(!eMailisEmpty(candidate)) {
			return new ErrorDataResult<Candidate>(candidate,"E Mail Boş Bırakılamaz");
		}
		if(!eMailValidation.isRealUser(candidate.getEmail())) {
			return new ErrorDataResult<Candidate>(candidate,"Geçersiz E Mail Girilemez");
		}
		if(!passwordisEmpty(candidate)) {
			return new ErrorDataResult<Candidate>(candidate,"Şifre Alanı Bırakılamaz");
		}
		if(this.candidatoDao.findAllByEmail(candidate.getEmail()).stream().count() != 0){
			return new ErrorDataResult<Candidate>(candidate, "Bu Mail Adresi Daha Önce Kayıt Edilmiş");
		}
		if(this.candidatoDao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream().count() != 0) {
			return new ErrorDataResult<Candidate>(candidate, "Bu TC Kimlik Daha Önce Kayıt Edilmiştir");
		}
		// to-do = mail'lerde sadece dogrulanmış olanların kontrolü yapılmalıdır.

		//to-do = pass son tekrar kontrolü kaldı
		
		if(!FakeMernis.isValidate(Long.parseLong(candidate.getIdentificationNumber()), candidate.getFirstName(), candidate.getLastName(), 1998)){
			return new ErrorDataResult<Candidate>(candidate,"Uyuşmayan Kişisel Bilgiler-Kimlik Doğrulanamadı");
		}

		
		//***//
		//User userAdded = this.userService.add(candidate);
		this.userService.add(candidate);

		if(!this.emailVerificationService.generate(candidate, new EmailVerification())) {
			return new ErrorDataResult<Candidate>(candidate, " Email Doğrulama Kodu Oluşturulurken Hata Oluştu");
		}
		
		this.candidatoDao.save(candidate);
		
		return new SuccessDataResult<Candidate>(candidate, " Aday Ekleme İşlemi Başarılı, Doğrulama Kodu Gönderildi");
		//***//
		
	}


	private boolean firstNameisEmpyt(Candidate candidate) {
		if(candidate.getFirstName().isBlank() || candidate.getFirstName().equals(null)){
			return false;
		}
		return true;
	}
	private boolean lastNameisEmpty(Candidate candidate) {
		if(candidate.getLastName().isBlank() || candidate.getLastName().equals(null)){
			return false;
		}
		return true;
	}
	private boolean identificationNumberisEmpty(Candidate candidate) {
		if(candidate.getIdentificationNumber().isBlank() || candidate.getIdentificationNumber().equals(null)){
			return false;
		}
		return true;
	}
	private boolean identificationNumberisValid(Candidate candidate) {
		String identity = candidate.getIdentificationNumber();
		if(!IdentificationNumberValidation.isValidSize(identity) || !IdentificationNumberValidation.isValidNumber(identity)) {
			return false;
		}
		return true;
	}
	private boolean birthDateisEmpty(Candidate candidate) {
		if(candidate.getBirthDate().equals(null)){
			return false;
		}
		return true;
	}
	private boolean eMailisEmpty(Candidate candidate) {
		if(candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	private boolean passwordisEmpty(Candidate candidate) {
		if(candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	
	
}
