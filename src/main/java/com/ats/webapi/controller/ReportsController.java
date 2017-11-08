package com.ats.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.BillWisePurchaseList;
import com.ats.webapi.model.BillWiseTaxReportList;
import com.ats.webapi.model.ItemWiseDetailList;
import com.ats.webapi.model.ItemWiseReportList;
import com.ats.webapi.model.MonthWiseReportList;
import com.ats.webapi.service.ReportsService;

@RestController
public class ReportsController {
	
	
	@Autowired
	ReportsService reportsService;
	
	@RequestMapping(value = { "/showBillWisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody BillWisePurchaseList showBillWisePurchase(@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate) {

		    BillWisePurchaseList billWisePurchaseList=reportsService.getBillWisePurchaseReport(frId,fromDate,toDate);
		    
			return billWisePurchaseList;
	  }
	@RequestMapping(value = { "/showItemWiseDetailsReport" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseDetailList showItemWiseDetail(@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate,@RequestParam("catId") int catId) {

		ItemWiseDetailList ItemWiseDetailList=reportsService.getItemWiseDetailReport(frId,catId,fromDate,toDate);
		    
			return ItemWiseDetailList;
	  }
	
	
	@RequestMapping(value = { "/showItemWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseReportList showItemWiseReport(@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate,@RequestParam("catId") int catId) {

		ItemWiseReportList ItemWiseReportList=reportsService.getItemWiseReport(frId,catId,fromDate,toDate);
		    
			return ItemWiseReportList;
	  }
	
	@RequestMapping(value = { "/showMonthWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody MonthWiseReportList showMonthWiseReport(@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate) {

		MonthWiseReportList monthWiseReportList=reportsService.getMonthWiseReport(frId,fromDate,toDate);
		    
			return monthWiseReportList;
	  }
	
	@RequestMapping(value = { "/showBillWiseTaxReport" }, method = RequestMethod.POST)
	public @ResponseBody BillWiseTaxReportList showBillWiseTaxReport(@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate) {

		BillWiseTaxReportList billWiseTaxReportList=reportsService.getBillWiseTaxReport(frId,fromDate,toDate);
		    
			return billWiseTaxReportList;
	  }
}
	

