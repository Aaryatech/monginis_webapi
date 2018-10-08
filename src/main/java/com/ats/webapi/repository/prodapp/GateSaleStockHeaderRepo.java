package com.ats.webapi.repository.prodapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.prodapp.GateSaleStockHeader;

public interface GateSaleStockHeaderRepo extends JpaRepository<GateSaleStockHeader, Integer>{
	
	GateSaleStockHeader save(GateSaleStockHeader gateSaleStockHeader );
	
	
	GateSaleStockHeader findByStockStatusAndDelStatus(int stockStatus,int delStatus);
	

}
