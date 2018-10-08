package com.ats.webapi.repository.prodapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.prodapp.StockTransfHeader;

public interface StockTransfHeaderRepo extends JpaRepository<StockTransfHeader, Integer> {
	
	StockTransfHeader save(StockTransfHeader stockTransfHeader);

}
