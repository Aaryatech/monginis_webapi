package com.ats.webapi.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.FrItemStockConfigure;
import com.ats.webapi.model.FrItemStockConfigureList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.GetBmsCurrentStock;
import com.ats.webapi.model.stock.GetBmsCurrentStockList;
import com.ats.webapi.repository.bmsstock.GetCurrentBmsStockRepo;
import com.ats.webapi.service.FrItemStockConfigureService;

@RestController
public class BmsStockController {

	@Autowired
	GetCurrentBmsStockRepo currentBmsStockRepo;
	
	@Autowired
	FrItemStockConfigureService frItemStockConfigureService;

	@RequestMapping(value = { "/getCuurentBmsStock" }, method = RequestMethod.POST)
	public @ResponseBody GetBmsCurrentStockList getCurrentBmsStockList(@RequestParam("prodDeptId") int prodDeptId,
			@RequestParam("mixDeptId") int mixDeptId,@RequestParam("storeDeptId") int storeDeptId,@RequestParam("rmType") int rmType) {

		Info info = new Info();
		
		
		System.out.println(" RM type Received "+rmType);

		java.sql.Date cDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		GetBmsCurrentStockList bmsStockList = new GetBmsCurrentStockList();

		try {

			List<GetBmsCurrentStock> bmsCurrentStock = currentBmsStockRepo.getBmsCurStock(cDate,prodDeptId,mixDeptId, storeDeptId,rmType);

			if (!bmsCurrentStock.isEmpty()) {

				info.setError(false);
				info.setMessage("success stock list ");
				
				bmsStockList.setBmsCurrentStock(bmsCurrentStock);
			} else {

				info.setError(true);
				info.setMessage("Error stock list ");

			}
			
			bmsStockList.setInfo(info);

		} catch (Exception e) {
			
			System.out.println("Exc in Getting Current BMS stock List "+e.getMessage());
			e.printStackTrace();
		}
System.out.println("Stock List BMS "+bmsStockList.toString());
		return bmsStockList;
	}
	
	@RequestMapping(value = { "/getDeptSettingValue" }, method = RequestMethod.POST)
	public @ResponseBody FrItemStockConfigureList getSeetingValueOfDept(@RequestParam("settingKeyList") List<String> settingKeyList ) {

		
		System.out.println("input para "+settingKeyList.toString());
		FrItemStockConfigureList settingList = frItemStockConfigureService.findBySettingKeyList(settingKeyList);

		return settingList;
	}
	
}
