package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.prodapp.StockTransfType;

public interface StockTransfTypeRepo extends JpaRepository<StockTransfType, Integer> {
	
	List<StockTransfType> findByDelStatus(int delStatus);
	

}
