package com.ats.webapi.repository.prodapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.prodapp.StockTransfDetail;

public interface StockTransfDetailRepo extends JpaRepository<StockTransfDetail, Integer> {
	
	StockTransfDetail save(StockTransfDetail stockTransfDetail);

}
