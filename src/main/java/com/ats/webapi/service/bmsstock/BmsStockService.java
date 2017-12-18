package com.ats.webapi.service.bmsstock;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.BmsStockDetailed;
import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.model.stock.GetBmsStock;

public interface BmsStockService {
	
	BmsStockHeader insertBmsStock(BmsStockHeader bmsStockHeader);

	List<BmsStockDetailed> getBmsStock(String fromDate, String toDate, int rmType);

	 

}
