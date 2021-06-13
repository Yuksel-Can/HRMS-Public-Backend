package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.EducationService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.EducationDao;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.ResumeDao;
import com.kodlama.io.hrmsPublic.dtos.EducationWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Education;

@Service
public class EducationManager  implements EducationService{

	private EducationDao educationDao;
	private ResumeDao resumeDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao, ResumeDao resumeDao) {
		super();
		this.educationDao = educationDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(Education education) {
		educationDao.save(education);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Başarıyla listelendi");
	}
/*
	@Override
	public DataResult<List<Education>> findAllByResume_ResumeId(int id) {
	
		//return new SuccessDataResult<List<Education>>(this.educationDao.getById(id), "Adaya ait okul bilgileri listelendi");
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByResume_ResumeId(id), "Adaya ait okul bilgileri listelendi");

	}
*//*
	@Override
	public DataResult<List<Education>> getEducationOrderByEndedDateDESC(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getEducationOrderByEndedDateDESC(id), "Adaya ait okul bilgileri listelendi");
	}
	*/
/*
	@Override
	public DataResult<List<Education>> orderCvEducationsByGraduationYearDesc(int id) {
		if (this.resumeDao.existsById(id)) {
			return new SuccessDataResult<List<Education>>
			(this.educationDao.getCvEducationOrderByGraduationYearDesc(id),"Aranan eğitimler listelendi.");
		}
		
		return new ErrorDataResult<List<Education>>
		("Cv ID bulunamadı.");
	}
	*/
	/*
	@Override
	public DataResult<List<CvEducation>> orderCvEducationsByGraduationYearDesc(int id) {
		if (this.cvDao.existsById(id)) {
			return new SuccessDataResult<List<CvEducation>>
			(this.cvEducationDao.getCvEducationOrderByGraduationYearDesc(id),"Aranan eğitimler listelendi.");
		}
		
		return new ErrorDataResult<List<CvEducation>>
		("Cv ID bulunamadı.");
	}
*/

	@Override
	public DataResult<List<Education>> namesEducation(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.namesEducation(id),"Listelendi)");
	}

	@Override
	public DataResult<List<Education>> namesEducation2(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.namesEducation2(id),"Tersten listelendi)");
	}

	@Override
	public DataResult<List<EducationWithResumeDto>> getEducationDetailsWithResumeOrderByDesc(int id) {
		return new SuccessDataResult<List<EducationWithResumeDto>>(this.educationDao.getEducationDetailsWithResumeOrderByDesc(id),"Listelendi");
	}
}
