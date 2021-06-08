package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.kodlama.io.hrmsPublic.entities.concrete.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

	List<JobTitle> findAllByTitle(String title);
	//JobTitle findById(int id);
	JobTitle findById(@Param("") int id);
}
