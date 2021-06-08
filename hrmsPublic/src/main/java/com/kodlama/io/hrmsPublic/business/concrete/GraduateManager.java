//package com.kodlama.io.hrmsPublic.business.concrete;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kodlama.io.hrmsPublic.business.abtracts.GraduateService;
//import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.ErrorResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.Result;
//import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
//import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessResult;
//import com.kodlama.io.hrmsPublic.dataAccess.abstracts.GraduateDao;
//import com.kodlama.io.hrmsPublic.entities.concrete.Graduate;
//
//@Service
//public class GraduateManager implements GraduateService{
//
//	private GraduateDao graduateDao;
//	
//	@Autowired
//	public GraduateManager(GraduateDao graduateDao) {
//		super();
//		this.graduateDao = graduateDao;
//	}
//
//	@Override
//	public DataResult<List<Graduate>> getAll() {
//
//		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(), "Data Listelendi");
//	}
//
//	@Override
//	public Result add(Graduate graduate) {
//		if(graduateDao.existByDescription(graduate.getDescription())) {
//			return new ErrorResult("Daha önce eklendi");
//		}
//		this.graduateDao.save(graduate);
//		return new SuccessResult("Eklendi");
//	}
//
//}
