package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.remarks.GetAllRemarks;

public interface GetAllRemarksRepo extends JpaRepository<GetAllRemarks, Integer> {

	
	
	List<GetAllRemarks> findAll();
}
