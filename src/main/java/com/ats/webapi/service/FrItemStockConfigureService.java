package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.FrItemStockConfigure;

public interface FrItemStockConfigureService {
	
	 public List<FrItemStockConfigure> getFrItemConfigure();

	public int findTotalAvailableSlot();

}
