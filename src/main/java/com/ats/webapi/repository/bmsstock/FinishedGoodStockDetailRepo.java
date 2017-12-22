package com.ats.webapi.repository.bmsstock;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.stock.FinishedGoodStockDetail;

public interface FinishedGoodStockDetailRepo  extends JpaRepository<FinishedGoodStockDetail, Integer> {

	
	FinishedGoodStockDetail save(FinishedGoodStockDetail finishedGoodStockDetail);
	
	
	List<FinishedGoodStockDetail> findByStockDate(Date stockDate);
}
