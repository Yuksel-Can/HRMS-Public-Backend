package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.JobPostingService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.JobPostingDao;
import com.kodlama.io.hrmsPublic.entities.concrete.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostiongDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostiongDao) {
		super();
		this.jobPostiongDao = jobPostiongDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {

		return new SuccessDataResult<List<JobPosting>>(this.jobPostiongDao.findAll(), "İlan listeleme başarılı");
	}

	@Override
	public DataResult<JobPosting> add(JobPosting jobPosting) {
		//jobPostiongDao.save(jobPosting);
		return new SuccessDataResult<JobPosting>(this.jobPostiongDao.save(jobPosting), "İlan başarıyla eklendi");
	}

}
