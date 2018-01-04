package com.ats.webapi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.SellBillDetailList;
import com.ats.webapi.model.bill.FrBillHeaderForPrint;
import com.ats.webapi.repository.GetBillHeaderForPrintRepo;

@RestController
public class PrintFrBillController {
	
	@Autowired
	GetBillHeaderForPrintRepo billHeaderForPrintRepo;
	
	
	@RequestMapping(value = { "/getBillHeaderForPrint" }, method = RequestMethod.POST)
	public @ResponseBody List<FrBillHeaderForPrint> getBillHeaderForPrint(
			@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate	) {
		
		List<FrBillHeaderForPrint> billHeaderPrintList=null;
		try {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		
		 billHeaderPrintList=billHeaderForPrintRepo.getFrBillHeaderForPrint(fromDate, toDate);
		
		}catch (Exception e) {
			System.out.println(" Exce in bill Header List for Print " +e.getMessage());
			e.printStackTrace();
		}
			return billHeaderPrintList;
	  }

}
