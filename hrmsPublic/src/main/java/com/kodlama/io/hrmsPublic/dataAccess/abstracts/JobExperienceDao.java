package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrmsPublic.dtos.EducationWithResumeDto;
import com.kodlama.io.hrmsPublic.dtos.JobExperienceWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	
	@Query("Select new com.kodlama.io.hrmsPublic.dtos.JobExperienceWithResumeDto(r.id, j.companyName, j.positionName, j.startedDate, j.endedDate, j.updateDate) From Resume r Inner Join r.jobExperiences j where r.candidate.id =:id order by j.endedDate desc")
	List<JobExperienceWithResumeDto> getJobExperienceDetailsWithResumeOrderByDesc(int id);
}
