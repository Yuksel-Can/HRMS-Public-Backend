//package com.kodlama.io.hrmsPublic.business.concrete;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kodlama.io.hrmsPublic.business.abtracts.EducationService;
//import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
//import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
//import com.kodlama.io.hrmsPublic.dataAccess.abstracts.EducationDao;
//import com.kodlama.io.hrmsPublic.entities.concrete.Education;
//
//@Service
//public class EducationManager  implements EducationService{
//
//	private EducationDao educationDao;
//	
//	@Autowired
//	public EducationManager(EducationDao educationDao) {
//		super();
//		this.educationDao = educationDao;
//	}
//
//	@Override
//	public Result add(Education education) {
//		educationDao.save(education);
//		return new SuccessResult("Ekleme başarılı");
//	}
//
//	@Override
//	public DataResult<List<Education>> getAll() {
//		return new SuccessDataResult<List<Education>>(educationDao.findAll(),"Başarıyla listelendi");
//	}
//
//}
