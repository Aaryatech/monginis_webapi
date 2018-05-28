package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.GrnGvnReport;
import com.ats.webapi.model.TSellReport;
import com.ats.webapi.model.regcakeasspreport.RegCakeAsSpOrderReport;
import com.ats.webapi.repository.GrnGvnReportRepository;
import com.ats.webapi.repository.TSellReportRepository;
import com.ats.webapi.repository.frpurchasereport.RegCakeAsSpOrderReportRepo; 

@RestController
public class FrontEndReport {
	
	@Autowired
	TSellReportRepository tSellReportRepository;
	
	@Autowired
	GrnGvnReportRepository grnGvnReportRepository;
	
	@Autowired
	RegCakeAsSpOrderReportRepo getRegCakeAsSpOrderReportRepo;
	
	@RequestMapping(value = { "/getRegCakeAsSpOrderReport" }, method = RequestMethod.POST)
	public @ResponseBody List<RegCakeAsSpOrderReport> getRegCakeAsSpOrderReport(@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate,@RequestParam("frId") int frId)
	{
		List<RegCakeAsSpOrderReport> getRegCakeAsSpReport = new ArrayList<RegCakeAsSpOrderReport>();
		try
		{
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			getRegCakeAsSpReport = getRegCakeAsSpOrderReportRepo.getRegCakeAsSpOrderReport(fromDate, toDate,frId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		  return getRegCakeAsSpReport ;

	}
	
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
			e.printStackTrace();
		}
		  return tSellReport ;

	}
	
	@RequestMapping(value = { "/grnGvnReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GrnGvnReport> grnGvnReport(@RequestParam("frId")int frId,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate,@RequestParam("isGrn")String isGrn)
	{
		List<GrnGvnReport> tSellReport = new ArrayList<GrnGvnReport>();
		try
		{
			System.out.println("suppId : "+frId);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			System.out.println("isGrn : "+isGrn);
			tSellReport = grnGvnReportRepository.grnGvnReportDateWise(frId, fromDate, toDate, isGrn);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		  return tSellReport ;

	}

}
