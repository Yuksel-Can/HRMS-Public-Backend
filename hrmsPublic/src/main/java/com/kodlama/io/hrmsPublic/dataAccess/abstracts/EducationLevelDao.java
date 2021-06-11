package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlama.io.hrmsPublic.entities.concrete.EducationLevel;

public interface EducationLevelDao extends JpaRepository<EducationLevel, Integer>{
	
	List<EducationLevel> findAll();
	//boolean existByLevelName(String levelName);
} 
