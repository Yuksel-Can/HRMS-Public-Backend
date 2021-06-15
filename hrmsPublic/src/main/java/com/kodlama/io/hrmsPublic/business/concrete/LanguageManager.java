package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.LanguageService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.LanguageDao;
import com.kodlama.io.hrmsPublic.dtos.LanguageWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}
	
	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Dil başarıyla eklendi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Tüm diller listelendi");
	}

	@Override
	public DataResult<List<LanguageWithResumeDto>> getLanguageDetailsWithResumeIdOrderByDesc(int id) {
		return new SuccessDataResult<List<LanguageWithResumeDto>>(this.languageDao.getLanguageDetailsWithResumeIdOrderByDesc(id), "Kullanıcının bildiği diller listelendi");
	}

	
}
