package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrmsPublic.entities.concrete.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	List<Candidate> findAllByEmail(String email);
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
}
