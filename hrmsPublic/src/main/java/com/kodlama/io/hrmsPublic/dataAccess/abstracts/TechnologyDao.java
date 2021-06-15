package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kodlama.io.hrmsPublic.dtos.TechnologyWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{

	//@Query("Select new com.kodlama.io.hrmsPublic.dtos.TechnologyWithResumeDto(r.id, j.technologyName, j.updateDate) From Resume r Inner Join r.technologies t where r.id =:id order by t.updateDate desc")

	@Query("Select new com.kodlama.io.hrmsPublic.dtos.TechnologyWithResumeDto(r.id, t.technologyName, t.updateDate) From Resume r Inner Join r.technologies t where r.candidate.id =:id order by t.updateDate desc")
	List<TechnologyWithResumeDto> getTechnologyDetailsWithResumeIdOrderByDesc(int id);
}
