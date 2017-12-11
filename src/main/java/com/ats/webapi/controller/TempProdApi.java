package com.ats.webapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.prod.GetProdPlanDetail;
import com.ats.webapi.model.prod.GetProdPlanDetailList;
import com.ats.webapi.model.prod.GetProdPlanHeader;
import com.ats.webapi.model.prod.GetProdPlanHeaderList;
import com.ats.webapi.repository.prod.GetProdHeaderRepo;
import com.ats.webapi.repository.prod.GetProdPlanDetailRepo;

@RestController
public class TempProdApi {

	@Autowired
	GetProdHeaderRepo prodHeaderRepo;
	
	@Autowired
	GetProdPlanDetailRepo prodDetaiRepo;
	
	
	@RequestMapping(value = { "/getProdPlanHeader" }, method = RequestMethod.POST)
	public @ResponseBody GetProdPlanHeaderList getProdPlanHeader(@RequestParam("fromDate") String fromDate,  @RequestParam("toDate") String toDate) {

		GetProdPlanHeaderList prodPlanHeaderList = new GetProdPlanHeaderList();
		
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		Info info=new Info();

		try {
		
		List<GetProdPlanHeader> prodPlanHeader=prodHeaderRepo.getProdPlanHeader(fromDate, toDate);
		
		if(!prodPlanHeader.isEmpty()) {
			
			info.setError(false);
			info.setMessage("success");
			
		}
		else {
			info.setError(false);
			info.setMessage("success");
		}
  
		prodPlanHeaderList.setProdPlanHeader(prodPlanHeader);
		prodPlanHeaderList.setInfo(info);
			
		}catch (Exception e) {
			System.out.println("Error getting prod Plan ");
			e.printStackTrace();
			
		}
			return prodPlanHeaderList;
	  }
	
	
	@RequestMapping(value = { "/getProdPlanDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetProdPlanDetailList getProdPlanDetail(@RequestParam("planHeaderId") int planHeaderId) {

		GetProdPlanDetailList prodDetailList = new GetProdPlanDetailList();
		
		Info info=new Info();

		try {
		
		List<GetProdPlanDetail> prodPlanDetail=prodDetaiRepo.getProdPlanDetailByHeaderId(planHeaderId);
		
		if(!prodPlanDetail.isEmpty()) {
			
			info.setError(false);
			info.setMessage("success");
			
		}
		else {
			info.setError(true);
			info.setMessage("failed");
		}
  
		prodDetailList.setProdPlanDetail(prodPlanDetail);
		prodDetailList.setInfo(info);
		
		
		}catch (Exception e) {
			System.out.println("Error getting prod Plan detail ");
			e.printStackTrace();
			
		}
			return prodDetailList;
	  }
	
}
