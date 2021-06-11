package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.EducationLevelService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.EducationLevelDao;
import com.kodlama.io.hrmsPublic.entities.concrete.EducationLevel;

@Service
public class EducationLevelManager implements EducationLevelService{

	private EducationLevelDao educationLevelDao;
	
	@Autowired
	public EducationLevelManager(EducationLevelDao educationLevelDao) {
		super();
		this.educationLevelDao = educationLevelDao;
	}

	@Override
	public DataResult<List<EducationLevel>> getAll() {

		return new SuccessDataResult<List<EducationLevel>>(this.educationLevelDao.findAll(), "Eğitim Seviyesi Listelendi");
	}

	@Override
	public Result add(EducationLevel educationLevel) {
		/*
		if(educationLevelDao.existByLevelName(educationLevel.getLevelName())) {
			return new ErrorResult("Daha önce eklendi");
		}
		*/
		this.educationLevelDao.save(educationLevel);
		return new SuccessResult("Eğitim Seviyesi Eklendi");
	}

}
