package com.ats.webapi.controller;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetMixingList;
import com.ats.webapi.model.MixingHeader;
import com.ats.webapi.model.bom.BillOfMaterialHeader;
import com.ats.webapi.model.bom.GetBillOfMaterialList;
import com.ats.webapi.service.BillOfMaterialService;
import com.ats.webapi.service.productionplan.MixingService;

@RestController
public class ProductionPlanController {
	

	@Autowired
	MixingService mixingService;
	
	@Autowired
	BillOfMaterialService billOfMaterialService;

	
	
	@RequestMapping(value = { "/insertMixingHeaderndDetailed" }, method = RequestMethod.POST)
	@ResponseBody
	public MixingHeader insertMixingHeaderndDetailed(@RequestBody MixingHeader MixingHeader) {
		
		MixingHeader mixingHeaderndDetail=new MixingHeader();
		try {
			
			System.out.println("MixingHeader :" + MixingHeader);
			mixingHeaderndDetail = mixingService.insertMixingHeaderndDetailed(MixingHeader);


		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return mixingHeaderndDetail;

	}
	
	
	@RequestMapping(value = { "/getMixingHeaderList" }, method = RequestMethod.POST)
	@ResponseBody
	public GetMixingList getMixingHeaderList(@RequestParam("frmdate")String frmdate, @RequestParam("todate")String todate) {
		
		GetMixingList getMixingList=new GetMixingList();
		try {
			
			
			getMixingList = mixingService.gettMixingHeaderndDetailed(frmdate,todate);


		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getMixingList;

	}
	
	
	@RequestMapping(value = { "/gettodaysMixingRequest" }, method = RequestMethod.GET)
	@ResponseBody
	public GetMixingList gettodaysMixingRequest() {
		
		GetMixingList getMixingList=new GetMixingList();
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String reportDate = dateFormat.format(date);
			String today=Common.convertToYMD(reportDate);
			System.out.println("current date "+reportDate);
			
			getMixingList = mixingService.gettMixingHeaderndDetailed(today,today);
			

		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getMixingList;

	}
	
	@RequestMapping(value = { "/getDetailedwithMixId" }, method = RequestMethod.POST)
	@ResponseBody
	public MixingHeader getDetailedwithMixId(@RequestParam("mixId")int mixId) {
		
		MixingHeader mixingHeader=new MixingHeader();
		try {
			
			
			
			mixingHeader = mixingService.gettMixingdetaildwithId(mixId);
			

		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return mixingHeader;

	}
	
	
	@RequestMapping(value = { "/getBOMHeaderList" }, method = RequestMethod.POST)
	@ResponseBody
	public GetBillOfMaterialList getBOMHeaderList(@RequestParam("frmdate")String frmdate, @RequestParam("todate")String todate) {
		
		GetBillOfMaterialList getBillOfMaterialList=new GetBillOfMaterialList();
		try {
			
			
			getBillOfMaterialList = billOfMaterialService.getBillOfMaterialithDate(frmdate, todate);


		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getBillOfMaterialList;

	}
	
	
	@RequestMapping(value = { "/getDetailedwithreqId" }, method = RequestMethod.POST)
	@ResponseBody
	public BillOfMaterialHeader getDetailedwithreqId(@RequestParam("reqId")int reqId) {
		
		BillOfMaterialHeader billOfMaterialHeader=new BillOfMaterialHeader();
		try {
			
			billOfMaterialHeader = billOfMaterialService.gettBomdetaildwithId(reqId);
			

		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return billOfMaterialHeader;

	}
	
	/*@RequestMapping(value = { "/updatestatus" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage updatestatus(@RequestParam("reqId")int reqId) {
		
		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
			errorMessage = billOfMaterialService.updatestatus(reqId);
			

		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return errorMessage;

	}*/
	
	

}
