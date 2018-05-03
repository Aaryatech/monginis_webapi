package com.ats.webapi.controller.salescompare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ats.webapi.model.report.salecompare.SalesComparison;
import com.ats.webapi.model.report.salecompare.SalesComparisonReport;
import com.ats.webapi.repository.salecomparereport.SalesComparisonReportRepo;

@RestController
public class SalesCompareReportController {
	
	@Autowired
	SalesComparisonReportRepo salesComparisonReportRepo;
	
	@RequestMapping(value = { "/getSalesReportComparion" }, method = RequestMethod.POST)
	public @ResponseBody SalesComparison getSalesReportComparion(@RequestParam("monthNumber") int monthNumber) {
		SalesComparison saleCompare=new SalesComparison();
		
		try {
			
		List<SalesComparisonReport> billTotalList =salesComparisonReportRepo.getSalesReportComparisonBillTotal(monthNumber);
		
		List<SalesComparisonReport> grnGvnTotalList =salesComparisonReportRepo.getSalesReportComparisonGrnGvnTotal(monthNumber);
		
		saleCompare.setBillTotalList(billTotalList);
		saleCompare.setGrnGvnTotalList(grnGvnTotalList);
		
		}catch (Exception e) {
			
			System.err.println(" Error In web service @ /getSalesReportComparion In /SalesCompareReportController ");
			e.printStackTrace();
		}

		return saleCompare;

	}
	
}
