package com.ats.webapi.controller.catstock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.catstock.CategoryWiseOrderData;
import com.ats.webapi.repository.catstock.CategoryWiseOrderDataRepository;

@RestController
public class CategoryStockUtilityController {
	
	@Autowired
	CategoryWiseOrderDataRepository categoryWiseOrderDataRepository;

	
	@RequestMapping(value = "/getCategoryWiseOrderDataReport", method = RequestMethod.POST)
	public @ResponseBody List<CategoryWiseOrderData> getCategoryWiseOrderDataReport(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("frId") List<String> frId, @RequestParam("subCatList") List<String> subCatList) {

		String fromDateYMD = Common.convertToYMD(fromDate);
		String toDateYMD = Common.convertToYMD(toDate);
		List<CategoryWiseOrderData> catReportList = categoryWiseOrderDataRepository.getSubCatStockReport(fromDateYMD,toDateYMD, frId, subCatList);
		return catReportList;

	}
	@RequestMapping(value = "/getCategoryWiseItemOrderDataReport", method = RequestMethod.POST)
	public @ResponseBody List<CategoryWiseOrderData> getCategoryWiseItemOrderDataReport(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("frId") List<String> frId, @RequestParam("itemId") int itemId) {

		String fromDateYMD = Common.convertToYMD(fromDate);
		String toDateYMD = Common.convertToYMD(toDate);
		List<CategoryWiseOrderData> catReportList = categoryWiseOrderDataRepository.getItemSubCatStockReport(fromDateYMD,toDateYMD, frId, itemId);
		return catReportList;

	}
	

}
