package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.GetBmsCurrentStock;
import com.ats.webapi.model.stock.GetBmsCurrentStockList;
import com.ats.webapi.repository.bmsstock.GetCurrentBmsStockRepo;

@RestController
public class BmsStockController {

	@Autowired
	GetCurrentBmsStockRepo currentBmsStockRepo;

	@RequestMapping(value = { "/getCuurentBmsStock" }, method = RequestMethod.GET)
	public @ResponseBody GetBmsCurrentStockList getCurrentBmsStockList() {

		Info info = new Info();

		GetBmsCurrentStockList bmsStockList = new GetBmsCurrentStockList();

		try {

			List<GetBmsCurrentStock> bmsCurrentStock = currentBmsStockRepo.getBmsCurStock();

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
}
