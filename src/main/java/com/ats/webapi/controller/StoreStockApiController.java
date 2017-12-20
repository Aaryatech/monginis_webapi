package com.ats.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.StoreStockHeader;
import com.ats.webapi.service.storestock.StoreStockService;

@RestController
public class StoreStockApiController {

	@Autowired
	StoreStockService storeStockService;
	
	@RequestMapping(value = { "/insertStoreOpeningStock" }, method = RequestMethod.POST)
	public @ResponseBody StoreStockHeader insertStoreOpeningStock(@RequestBody StoreStockHeader storeStockHeader)
	{
		Info info=new Info();
		storeStockHeader=storeStockService.insertStoreOpStock(storeStockHeader);
		
		
		return storeStockHeader;
	}
}
