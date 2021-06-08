package com.kodlama.io.hrmsPublic.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrmsPublic.business.abtracts.UserService;
import com.kodlama.io.hrmsPublic.dataAccess.abstracts.UserDao;
import com.kodlama.io.hrmsPublic.entities.abstracts.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User add(User user) {
		
		//this.userDao.save(user);
		return user;
	}

}
