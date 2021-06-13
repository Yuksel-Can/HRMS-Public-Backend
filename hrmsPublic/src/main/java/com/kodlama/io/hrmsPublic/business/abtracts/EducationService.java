package com.kodlama.io.hrmsPublic.business.abtracts;

import java.util.List;

import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
import com.kodlama.io.hrmsPublic.dtos.EducationWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Education;

public interface EducationService {

	Result add(Education education);
	
	DataResult<List<Education>> getAll();
	//DataResult<List<Education>> getById(int id);
//	DataResult<List<Education>> findAllByResume_ResumeId(int id);

	//DataResult<List<Education>> findAllByResumeIdOrderByEndedDateDesc(int id);
	//DataResult<List<Education>> getEducationOrderByEndedDateDESC(int id);
	//DataResult<List<Education>> orderCvEducationsByGraduationYearDesc(int id);

	DataResult<List<Education>> namesEducation(int id);
	DataResult<List<Education>> namesEducation2(int id);

	DataResult<List<EducationWithResumeDto>> getEducationDetailsWithResumeOrderByDesc(int id);

}
