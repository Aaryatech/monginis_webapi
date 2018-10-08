package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.prodapp.GateSaleStockDetail;

public interface GateSaleStockDetailRepo extends JpaRepository<GateSaleStockDetail, Integer> {
	
	
	GateSaleStockDetail save(GateSaleStockDetail detail);
	
	List<GateSaleStockDetail> findByGateSaleStockHeaderId(int saleStockHeaderId);
}
