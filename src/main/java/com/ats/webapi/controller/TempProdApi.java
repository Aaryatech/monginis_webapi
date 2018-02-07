package com.ats.webapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.ats.webapi.model.prod.ProdMixingReqP1;
import com.ats.webapi.model.prod.ProdMixingReqP1List;
import com.ats.webapi.model.prod.mixing.GetSFDataForMixing;
import com.ats.webapi.model.prod.mixing.GetSFDataForMixingList;
import com.ats.webapi.model.prod.mixing.GetSFMixingForBom;
import com.ats.webapi.model.prod.mixing.GetSFMixingForBomList;
import com.ats.webapi.model.prod.mixing.GetSFPlanDetailForMixing;
import com.ats.webapi.model.prod.mixing.GetSFPlanDetailForMixingList;
import com.ats.webapi.model.prod.mixing.GetTempMixItemDetail;
import com.ats.webapi.model.prod.mixing.GetTempMixItemDetailList;
import com.ats.webapi.model.prod.mixing.TempMixing;
import com.ats.webapi.model.prod.mixing.TempMixingList;
import com.ats.webapi.repository.prod.GetProdHeaderRepo;
import com.ats.webapi.repository.prod.GetProdPlanDetailRepo;
import com.ats.webapi.repository.prod.GetSFMixingForBomRepo;
import com.ats.webapi.repository.prod.GetSFPlanDetailForMixingRepo;
import com.ats.webapi.repository.prod.GetTempMixItemDetailRepo;
import com.ats.webapi.repository.prod.ProdMixingReqP1Repo;
import com.ats.webapi.repository.prod.TempMixingRepo;

@RestController
public class TempProdApi {

	@Autowired
	GetProdHeaderRepo prodHeaderRepo;
	
	@Autowired
	GetProdPlanDetailRepo prodDetaiRepo;
	
	
	@Autowired
	ProdMixingReqP1Repo prodMixReqP1;
	
	
	/*@Autowired
	GetItemwiseProdPlanRepo getItemwiseProdPlanRepo;
	
	@Autowired
	GetItemDetailForMixingRepo getItemDetailForMixingRepo;
	
	@Autowired
	GetSfDetailForMixingRepo getSfDetailForMixingRepo;
	
	
	@Autowired
	GetSFDataForMixingRepo getSFDataForMixingRepo;
	*/
	@Autowired
	TempMixingRepo tempMixingRepo;
	
	@Autowired
	GetTempMixItemDetailRepo getTempMixItemDetailRepo;
	
	@Autowired
	GetSFPlanDetailForMixingRepo getSFPlanDetailForMixingRepo; //New And Final
	
	@Autowired
	GetSFMixingForBomRepo getSFMixingForBomRepo;
	// used 1
	
	@RequestMapping(value = { "/getTempMixItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetTempMixItemDetailList getTempMixItemDetailRepo(@RequestParam("prodHeaderId") int prodHeaderId) {
		
		GetTempMixItemDetailList tempMixList=new GetTempMixItemDetailList();
		
		try {
			
			List<GetTempMixItemDetail> tempMixItemDetail=getTempMixItemDetailRepo.getMxItemDetail(prodHeaderId);
			System.out.println(" first List "+tempMixItemDetail.toString());
			
			tempMixList.setTempMixItemDetail(tempMixItemDetail);
			

			System.out.println("in web service /getTempMixItemDetail");
			System.out.println("Phase 2 data temp mix:  "+tempMixList.toString());
			
			if(!tempMixItemDetail.isEmpty()) {
				
				tempMixingRepo.deleteAllInBatch();
				System.out.println("temp mix table deleted ");
			}
			
			
		}catch (Exception e) {
			System.out.println("Get Error Temp Mixing");		
			
		}
		
		
		
		return tempMixList;
		
	}
	
	// used 2
	@RequestMapping(value = { "/insertTempMixing" }, method = RequestMethod.POST)
	public @ResponseBody Info insertTempMixing(@RequestBody List<TempMixing> tempMixing ) {
		
		TempMixing tempMix;
		Info info=new Info();
		
		try {
			
			for(int i=0;i<tempMixing.size();i++) {
				
				 //tempMix=new TempMixing();
				 
				 TempMixing  saveMe=tempMixingRepo.save(tempMixing.get(i));
				  System.out.println("Record Added in tempMix "+saveMe.toString());
			}
			
		}catch (Exception e) {
			System.out.println("Insert Error Temp Mixing");		
			
		}
		
		return info;
		
	}
	
	
	//used 3
	
		@RequestMapping(value = { "/getSfPlanDetailForMixing" }, method = RequestMethod.POST)
		public @ResponseBody ProdMixingReqP1List getSfPlanDetailForMixing(@RequestParam("headerId")int headerId) {

			ProdMixingReqP1List sfAndPlanDetailList = new ProdMixingReqP1List();
			
			Info info=new Info();

			try {
			
				//List<GetSFPlanDetailForMixing> sfPlanDetailForMixing=getSFPlanDetailForMixingRepo.getSFAndPlanDetailForMixing(headerId);
				
				List<ProdMixingReqP1> sfPlanDetailForMixing=prodMixReqP1.getSFAndPlanDetailForMixing(headerId);
			
				
			if(!sfPlanDetailForMixing.isEmpty()) {
				
				info.setError(false);
				info.setMessage("success");
				
			}
			else {
				
				info.setError(true);
				info.setMessage("failed");
			}
	  
			sfAndPlanDetailList.setProdMixingReqP1(sfPlanDetailForMixing);
			System.out.println(" Mixing Phase 1 web service o/p "+ sfAndPlanDetailList.toString() );			
			}catch (Exception e) {
				System.out.println("Error getting sf and Plan Detail For Mixing  Phase 1");
				e.printStackTrace();
				
			}
				return sfAndPlanDetailList;
		  }
		
	
		
		//bom started
		@RequestMapping(value = { "/getSfPlanDetailForBom" }, method = RequestMethod.POST)
		public @ResponseBody GetSFPlanDetailForMixingList getSfPlanDetailForBom(@RequestParam("headerId")int headerId) {

			GetSFPlanDetailForMixingList sfAndPlanDetailList = new GetSFPlanDetailForMixingList();
			
			Info info=new Info();

			try {
			
				List<GetSFPlanDetailForMixing> sfPlanDetailForBom=getSFPlanDetailForMixingRepo.getSfPlanDetailForBom(headerId);
			
			if(!sfPlanDetailForBom.isEmpty()) {
				
				info.setError(false);
				info.setMessage("success");
				
			}
			else {
				
				info.setError(true);
				info.setMessage("failed");
			}
	  
			sfAndPlanDetailList.setSfPlanDetailForMixing(sfPlanDetailForBom);
			sfAndPlanDetailList.setInfo(info);
			
			
			}catch (Exception e) {
				System.out.println("Error getting sf and Plan Detail For Bom ");
				e.printStackTrace();
				
			}
				return sfAndPlanDetailList;
		  }
		
		//bom second web service
		

		@RequestMapping(value = { "/getSFMixingForBom" }, method = RequestMethod.POST)
		public @ResponseBody GetSFMixingForBomList getSFMixingForBom(@RequestParam("mixingId")int mixingId) {

			GetSFMixingForBomList sfMixingForBomList = new GetSFMixingForBomList();
			
			Info info=new Info();

			try {
			
				List<GetSFMixingForBom> sFMixingForBom=getSFMixingForBomRepo.getSFMixingForBom(mixingId);
			
			if(!sFMixingForBom.isEmpty()) {
				
				info.setError(false);
				info.setMessage("success");
				
			}
			else {
				
				info.setError(true);
				info.setMessage("failed");
			}
	  
			sfMixingForBomList.setsFMixingForBom(sFMixingForBom);
			sfMixingForBomList.setInfo(info);
			
			
			}catch (Exception e) {
				System.out.println("Error getting sf Mixing For BOM "+e.getCause());
				
				e.getStackTrace();
				
				e.printStackTrace();
				
			}
				return sfMixingForBomList;
		  }
		
		
		
	@RequestMapping(value = { "/getTempMix" }, method = RequestMethod.POST)
	public @ResponseBody TempMixingList getTempMix(@RequestParam("prodHeaderId") int prodHeaderId) {
		
		TempMixingList tempMix=new TempMixingList();
		
		try {
			
			List<TempMixing> tempMixing=tempMixingRepo.findByProdHeaderId(prodHeaderId);
			
			
			tempMix.setTempMixing(tempMixing);
			
			
		}catch (Exception e) {
			System.out.println("Get Error Temp Mixing");		
			
		}
		
		return tempMix;
		
	}
	
	
	
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
	
	
	/*@RequestMapping(value = { "/getItemwisePlanDetail" }, method = RequestMethod.GET)
	public @ResponseBody GetItemwisePlanDetailList getItemwisePlanDetail() {

		GetItemwisePlanDetailList planDetailList = new GetItemwisePlanDetailList();
		
		Info info=new Info();

		try {
		
			List<GetItemwisePlanDetail> itemWisePlan=getItemwiseProdPlanRepo.getItemQty();
		
		if(!itemWisePlan.isEmpty()) {
			
			info.setError(false);
			info.setMessage("success: list size = "+itemWisePlan.size());
			
		}
		else {
			info.setError(true);
			info.setMessage("failed :");
		}
  
		planDetailList.setItemwisePlanDetail(itemWisePlan);
		planDetailList.setInfo(info);
		
		
		}catch (Exception e) {
			System.out.println("Error getting prod item wise Plan detail ");
			e.printStackTrace();
			
		}
			return planDetailList;
	  }
	
	
	@RequestMapping(value = { "/getItemDetailForMixing" }, method = RequestMethod.POST)
	public @ResponseBody GetItemDetailForMixingList getItemDetailForMixing(@RequestParam("itemIdList") List<String> itemIdList) {
		
		System.out.println("input para "+itemIdList.toString());
		
	//	itemIdList=itemIdList.toString();

		GetItemDetailForMixingList itemMixList = new GetItemDetailForMixingList();
		
		Info info=new Info();

		try {
		
			List<GetItemDetailForMixing> itemForMixing=getItemDetailForMixingRepo.getMixingItem(itemIdList);
		
		if(!itemForMixing.isEmpty()) {
			
			info.setError(false);
			info.setMessage("success: list size = "+itemForMixing.size());
			
		}
		else {
			info.setError(true);
			info.setMessage("failed :");
		}
  
		itemMixList.setItemDetailForMixing(itemForMixing);
		itemMixList.setInfo(info);
		
		
		}catch (Exception e) {
			System.out.println("Error getting prod item wise Mixing detail ");
			e.printStackTrace();
			
		}
		
		System.out.println("output lits mixing "+itemMixList.toString());
		
		return itemMixList;
	  }
	
	
	@RequestMapping(value = { "/getSfDetailForMixing" }, method = RequestMethod.POST)
	public @ResponseBody GetSfDetailForMixingList getSfDetailForMixing(@RequestParam("sfIdList") List<String> sfIdList) {
		
		System.out.println("input para "+sfIdList.toString());
		
	//	itemIdList=itemIdList.toString();

		GetSfDetailForMixingList sfDetailMix = new GetSfDetailForMixingList();
		
		Info info=new Info();

		try {
		
			List<GetSfDetailForMixing> sfDetailLits= getSfDetailForMixingRepo.getSfDetailForMixing(sfIdList);
		
		if(!sfDetailLits.isEmpty()) {
			
			info.setError(false);
			info.setMessage("success: list size = "+sfDetailLits.size());
			
		}
		else {
			info.setError(true);
			info.setMessage("failed :");
		}
  
		sfDetailMix.setSfDetailForMixing(sfDetailLits);
		sfDetailMix.setInfo(info);
		
		
		}catch (Exception e) {
			System.out.println("Error getting sf  detail  for Mixing");
			e.printStackTrace();
			
		}
		
		System.out.println("output lits sf List "+sfDetailMix.toString());
		
		return sfDetailMix;
	  }
*/	
	/*@RequestMapping(value = { "/getSFDataForMixing" }, method = RequestMethod.POST)
	public @ResponseBody GetSFDataForMixingList getSFData(@RequestParam("qty")int qty,@RequestParam("sfId")int sfId) {

		GetSFDataForMixingList sfDataForMixList = new GetSFDataForMixingList();
		
		Info info=new Info();

		try {
		
			List<GetSFDataForMixing> sFDataForMixing=getSFDataForMixingRepo.getSFData(qty, sfId);
		
		if(!sFDataForMixing.isEmpty()) {
			
			info.setError(false);
			info.setMessage("success");
			
		}
		else {
			
			info.setError(true);
			info.setMessage("failed");
		}
  
		sfDataForMixList.setsFDataForMixing(sFDataForMixing);
		sfDataForMixList.setInfo(info);
		
		
		}catch (Exception e) {
			System.out.println("Error getting sf Data For Mixing ");
			e.printStackTrace();
			
		}
		
		System.out.println("sfDataForMixList "+sfDataForMixList.toString());

			return sfDataForMixList;
	  }*/
	
}
