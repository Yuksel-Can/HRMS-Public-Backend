package com.kodlama.io.hrmsPublic.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrmsPublic.entities.concrete.WorkingTime;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer>{

}
