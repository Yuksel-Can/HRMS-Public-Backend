package com.kodlama.io.hrmsPublic.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.WayOfWorkingService;
import com.kodlama.io.hrmsPublic.core.utilities.results.DataResult;
import com.kodlama.io.hrmsPublic.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.WayOfWorkingDao;
import com.kodlama.io.hrmsPublic.entities.concrete.WayOfWorking;

@Service
public class WayOfWorkingManager implements WayOfWorkingService{

	private WayOfWorkingDao wayOfWorkingDao;
	
	@Autowired
	public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
		this.wayOfWorkingDao = wayOfWorkingDao;
	}

	@Override
	public DataResult<List<WayOfWorking>> getAll() {
		return new SuccessDataResult<List<WayOfWorking>>(this.wayOfWorkingDao.findAll(), "Tüm çalışma Şekilleri/Biçimleri Listelendi");
	}
}
