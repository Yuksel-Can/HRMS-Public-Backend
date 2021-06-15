package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrmsPublic.dtos.LanguageWithResumeDto;
import com.kodlama.io.hrmsPublic.entities.concrete.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

	@Query("Select new com.kodlama.io.hrmsPublic.dtos.LanguageWithResumeDto(r.id, l.languageName, l.languageLevel, l.updateDate) From Resume r Inner Join r.languages l where r.candidate.id =:id order by l.updateDate desc")
	List<LanguageWithResumeDto> getLanguageDetailsWithResumeIdOrderByDesc(int id);
}
