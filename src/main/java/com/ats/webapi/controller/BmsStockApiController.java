package com.ats.webapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.service.bmsstock.BmsStockService;


@RestController
public class BmsStockApiController {
	
	@Autowired
	BmsStockService bmsStockService;
	
	@RequestMapping(value = { "/insertBmsStock" }, method = RequestMethod.POST)
	public @ResponseBody BmsStockHeader insertBmsStock(@RequestBody BmsStockHeader bmsStockHeader) {

		BmsStockHeader bmsStockHeaderloc = new BmsStockHeader();
		try {

	
			bmsStockHeaderloc = bmsStockService.insertBmsStock(bmsStockHeader);
			
			if(bmsStockHeaderloc!=null)
			{
				System.out.println("successfully inserted");
			}
			

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock Insert " + e.getMessage());
		}

		return bmsStockHeaderloc;

	}
	
	
	

}