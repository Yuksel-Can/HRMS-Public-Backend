package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.JobPostingService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
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

	@Override
	public DataResult<List<JobPosting>> getAllSortedByAndDateDESC() {
		Sort sortDesc = Sort.by(Sort.Direction.DESC, "endedDate");
		return new SuccessDataResult<List<JobPosting>> (this.jobPostiongDao.findAll(sortDesc), "Büyükten küçük tarihe göre sıralandı");
	}

	@Override
	public DataResult<List<JobPosting>> getAllSortedByAndDateASC() {
		Sort sortDesc = Sort.by(Sort.Direction.ASC, "endedDate");
		return new SuccessDataResult<List<JobPosting>> (this.jobPostiongDao.findAll(sortDesc), "küçükten büyük tarihe göre sıralandı");
	}
	@Override
	public DataResult<List<JobPosting>> findByIsVisible(){
		
		return new SuccessDataResult<List<JobPosting>> (this.jobPostiongDao.findByIsVisible(true,Sort.by(Sort.Direction.ASC, "endedDate")), "Tüm aktif iş ilanları küçükten büyüğe listelendi");
	}
	/*
	@Override
	public DataResult<List<JobPosting>> findByOrderByEndedDateAscAndIsVisible(){
		
		return new SuccessDataResult<List<JobPosting>> (this.jobPostiongDao.findByIsVisibleAndOrderByEndedDateAsc(true), "Tüm aktif iş ilanları küçükten büyüğelistelendi");
	}
*/
	@Override
	public DataResult<List<JobPosting>> findByIsVisibleAndEmployer(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostiongDao.findByIsVisibleAndEmployer_companyName(true, companyName), " Aktif ve İstenilen şirkete göre listelendi");
	}

	@Override
	public Result isVisibleClose(int id, int employerId) {
		
		JobPosting jobPosting = this.jobPostiongDao.findByIdAndEmployer_id(id, employerId);
		
		if(!jobPosting.isVisible()) {
			return new ErrorResult("Bu ilan daha önceden kapatılmıştır");
		}
		jobPosting.setVisible(false);
		this.jobPostiongDao.save(jobPosting);
		return new SuccessResult("İlan başarıyla kapatıldı");
	}

	@Override
	public DataResult<List<JobPosting>> findByIsVisibleAndWayOfWorking(String wayOfWorking) {

		return new SuccessDataResult<List<JobPosting>>(this.jobPostiongDao.findByIsVisibleAndWayOfWorking(true, wayOfWorking), "İstenilen çalışma türünde, aktif ilanlar listelendi");
	}


}
