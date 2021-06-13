package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrmsPublic.dtos.EducationWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	
	//@Query("From education e where education_resume_candidate_id =:id")			/denenecek

	@Query("From Education where resume.candidate.id =:id ")
	List<Education> namesEducation(int id);
	
	@Query("From Education e where resume.candidate.id =:id order by endedDate asc ")
	List<Education> namesEducation2(int id);
	
	
	//select p.productId, p.productName, c.categoryName from Category c inner join Product p on c.categoryId = p.categoryId
	//jpql
	//her zaman OneToMany ilerle yani ana tablodan ilerle yani önce category(one olduğu için) sonra product(many old için)(alt satırda yazdım)
	//@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	//on koşulu jpql de yazılması gerekmiyor
	//@Query("Select new com.kodlama.io.hrmsPublic.dtos.EducationWithResumeDto(e.id, e.schoolName, e.departmentName, e.startedDate, e.endedDate, e.updateDate) From Resume r Inner Join r.educations e")
	@Query("Select new com.kodlama.io.hrmsPublic.dtos.EducationWithResumeDto(r.id, e.schoolName, e.departmentName, e.startedDate, e.endedDate, e.updateDate) From Resume r Inner Join r.educations e where r.id =:id order by e.endedDate desc")

	List<EducationWithResumeDto> getEducationDetailsWithResumeOrderByDesc(int id);
	
	
	
	
}
