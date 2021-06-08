//package com.kodlama.io.hrmsPublic.business.concrete;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kodlama.io.hrmsPublic.business.abtracts.ResumeService;
//import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
//import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
//import com.kodlama.io.hrmsPublic.dataAccess.abstracts.ResumeDao;
//import com.kodlama.io.hrmsPublic.entities.concrete.Resume;
//
//@Service
//public class ResumeManager implements ResumeService{
//
//	private ResumeDao resumeDao;
//	
//	@Autowired
//	public ResumeManager(ResumeDao resumeDao) {
//		this.resumeDao = resumeDao;
//	}
//	@Override
//	public Result add(Resume resume) {
//		resumeDao.save(resume);
//		return new SuccessResult("cv ekleme başarılı");
//	}
//	@Override
//	public DataResult<List<Resume>> getAll() {
//
//		return new SuccessDataResult<List<Resume>>(resumeDao.findAll()	, "Data Listelendi");
//	}
//
//	
//}
