package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.JobTitleService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.JobTitleDao;
import com.kodlama.io.hrmsPublic.entities.concrete.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	
	JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		
		return new SuccessDataResult<List<JobTitle>> (jobTitleDao.findAll(), "Tüm iş pozisyonları listelendi");
	}

	@Override
	public DataResult<JobTitle> add(JobTitle jobTitle) {

		if(!JobTitleValid(jobTitle.getTitle())) {
			return new ErrorDataResult<JobTitle>(jobTitle, "Bu İş Alanı Daha Önce Eklenmiş");
		}
		
		return new SuccessDataResult<JobTitle>(jobTitleDao.save(jobTitle), "Yeni iş pozisyonu eklendi");
	}
	
	@Override
	public DataResult<JobTitle> findById(int id) {
		
		return new SuccessDataResult<JobTitle>(jobTitleDao.findById(id)," İş ilanı başarılı bir şekilde listelendi");
	}
	
	
	public boolean JobTitleValid(String title) {
		if(jobTitleDao.findAllByTitle(title).stream().count() !=0) {
			return false;
		}
		return true;
	}
	

}
