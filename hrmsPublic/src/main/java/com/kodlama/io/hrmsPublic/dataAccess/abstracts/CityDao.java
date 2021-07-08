package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrmsPublic.entities.concrete.City;

public interface CityDao extends JpaRepository<City, Integer>{
	List<City> findAll();

}
