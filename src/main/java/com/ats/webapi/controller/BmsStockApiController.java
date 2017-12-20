package com.ats.webapi.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.BmsStockDetailed;
import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.model.stock.GetBmsStock;
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
	
	@RequestMapping(value = { "/getBmsStock" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBmsStock> getBmsStock(@RequestParam("fromDate")String fromDate , @RequestParam("toDate")String toDate , @RequestParam("rmType")int rmType) {

		List<GetBmsStock> bmsStockDetailedList = new ArrayList<GetBmsStock>();
		try {

	
			bmsStockDetailedList = bmsStockService.getBmsStock(fromDate, toDate, rmType );
			
			if(bmsStockDetailedList!=null && !bmsStockDetailedList.isEmpty())
			{
				System.out.println("successfully  ");
			}
			

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock   " + e.getMessage());
		}

		return bmsStockDetailedList;

	}
	
	@RequestMapping(value = { "/getBmsStockHeader" }, method = RequestMethod.POST)
	public @ResponseBody BmsStockHeader getBmsStockHeader(@RequestParam("stockDate")String stockDate ,  @RequestParam("rmType")int rmType) {

		BmsStockHeader bmsStockHeader = new BmsStockHeader();
		try {

	System.out.println("Date : "+stockDate +"And rmType : "+rmType);
			bmsStockHeader = bmsStockService.getBmsStockHeader(stockDate,  rmType );
			
			if(bmsStockHeader!=null )
			{
				System.out.println("successfully  ");
			}
			
System.out.println("Response from getBms Header  : "+bmsStockHeader.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock   " + e.getMessage());
		}

		return bmsStockHeader;

	}

}
