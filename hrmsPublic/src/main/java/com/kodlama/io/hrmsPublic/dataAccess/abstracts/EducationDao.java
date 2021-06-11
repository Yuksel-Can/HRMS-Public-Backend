package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrmsPublic.entities.concrete.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	//List<Education> findAllByResume_ResumeId(int id);
	//List<Education> findAllByResumeIdOrderByEnded(int id);
	//List<Education> findAllByResumeIdOrderByEndedDateDesc(int id);
	
	//@Query	
	//@Query("From education e where resume_resumeId=:id")
	//List<Education> getEducationOrderByEndedDateDESC(int id);
	
	//@Query("From education e where education_resume_candidate_id =:id")			/denenecek

	@Query("From Education where resume.candidate.id =:id ")
	List<Education> namesEducation(int id);
	
	@Query("From Education e where resume.candidate.id =:id order by endedDate asc ")
	List<Education> namesEducation2(int id);
	
	
	
}
