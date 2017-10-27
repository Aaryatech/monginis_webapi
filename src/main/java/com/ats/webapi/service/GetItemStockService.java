package com.ats.webapi.service;

import java.util.Date;

import org.springframework.data.repository.query.Param;

public interface GetItemStockService {


	int getTotalPurchase(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);
	

	int getTotalGrnGvn( @Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);
	
	int getTotalSell( @Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);
	
}
