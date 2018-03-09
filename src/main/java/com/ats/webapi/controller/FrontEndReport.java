package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.TSellReport; 
import com.ats.webapi.repository.TSellReportRepository; 

@RestController
public class FrontEndReport {
	
	@Autowired
	TSellReportRepository tSellReportRepository;
	
	@RequestMapping(value = { "/tSellReport" }, method = RequestMethod.POST)
	public @ResponseBody List<TSellReport> tSellReport(@RequestParam("frId")int frId,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate)
	{
		List<TSellReport> tSellReport = new ArrayList<TSellReport>();
		try
		{
			System.out.println("suppId : "+frId);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			tSellReport = tSellReportRepository.hsnCodeWiseReport(frId, fromDate, toDate);
		}catch(Exception e)
		{
			
		}
		  return tSellReport ;

	}

}
