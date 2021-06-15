package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrmsPublic.entities.concrete.Education;
import com.kodlama.io.hrmsPublic.entities.concrete.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	boolean existsById(int id);
	@Query("From Resume where candidate.id =:id ")
	List<Resume> getResumeWithUserId(int id);
}
