package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.CityService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.CityDao;
import com.kodlama.io.hrmsPublic.entities.concrete.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	

	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Tüm Adaylar Başarıyla Listelendi	");
	}

}
