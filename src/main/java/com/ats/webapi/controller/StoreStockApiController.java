package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.StockDate;
import com.ats.webapi.model.stock.GetPoGenItemStock;
import com.ats.webapi.model.stock.GetStoreCurrentStock;
import com.ats.webapi.model.stock.StoreStockDetail;
import com.ats.webapi.model.stock.StoreStockDetailList;
import com.ats.webapi.model.stock.StoreStockHeader;
import com.ats.webapi.repository.StockDateStRepository;
import com.ats.webapi.repository.storestock.GetPoGeneratedItemStockRepository;
import com.ats.webapi.service.storestock.StoreStockService;

@RestController
public class StoreStockApiController {

	@Autowired
	StoreStockService storeStockService;
	
	@Autowired
	StockDateStRepository stkDateReposiory;
	
	@Autowired
	GetPoGeneratedItemStockRepository getPoGeneratedItemStockRepository;
	
	@RequestMapping(value = { "/insertStoreOpeningStock" }, method = RequestMethod.POST)
	public @ResponseBody StoreStockHeader insertStoreOpeningStock(@RequestBody StoreStockHeader storeStockHeader)
	{
		Info info=new Info();
		storeStockHeader=storeStockService.insertStoreOpStock(storeStockHeader);
		
		
		return storeStockHeader;
	}
	@RequestMapping(value = { "/getStoreStockDates" }, method = RequestMethod.GET)
	public @ResponseBody StockDate getStoreStockDates()
	{
		StockDate stockDateRes=stkDateReposiory.getStockDates();
		
		
		return stockDateRes;
	}
	
	@RequestMapping(value = { "/getMonthWiseStoreStock" }, method = RequestMethod.POST)
	public @ResponseBody StoreStockDetailList getMonthWiseStoreStock(@RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate,@RequestParam("grpId")int grpId) {
		
		System.out.println("Dates from "+fromDate+"  toDate  "+toDate);
		StoreStockDetailList storeStockDetailList=new StoreStockDetailList();
		List<StoreStockDetail> resStoreStockDetailList=new ArrayList<>();
		Info info=new Info();
		
		resStoreStockDetailList=storeStockService.getMonthWiseStoreStock(fromDate,toDate,grpId);
		System.out.println("Return List"+resStoreStockDetailList.toString());
		
		if(resStoreStockDetailList!=null && !resStoreStockDetailList.isEmpty())
		{
			info.setError(false);
			info.setMessage("Success");
			storeStockDetailList.setStoreStockDetailList(resStoreStockDetailList);
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed");
		}
		storeStockDetailList.setInfo(info);
		return storeStockDetailList;
	}
	
	@RequestMapping(value = { "/getCurrentStoreStock" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStoreCurrentStock> getCurrentStoreStock(@RequestParam("grpId")int grpId,@RequestParam("deptId")int deptId) {
	
		List<GetStoreCurrentStock> getStoreCurrentStockList=storeStockService.getCurrentStock(grpId,deptId);
		
		return getStoreCurrentStockList;
	}
	@RequestMapping(value = { "/getCurrentStoreStockReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStoreCurrentStock> getCurrentStoreStockReport(@RequestParam("grpId")int grpId,@RequestParam("deptId")int deptId) {
	
		List<GetStoreCurrentStock> getStoreCurrentStockList=storeStockService.getCurrentStockReport(grpId,deptId);
		
		return getStoreCurrentStockList;
	}
	@RequestMapping(value = { "/getCurrentStoreStockHeader" }, method = RequestMethod.POST)
	public @ResponseBody StoreStockHeader getCurrentStoreStockHeader(@RequestParam("subCatId")int subCatId,@RequestParam("status")int status) {
		
		StoreStockHeader storeStockHeader = new StoreStockHeader();
		try
		{
			storeStockHeader=storeStockService.getCurrentStockHeader(subCatId,status);
			if(storeStockHeader==null)
			{
				storeStockHeader = new StoreStockHeader();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		 
		
		return storeStockHeader;
	}
	
	@RequestMapping(value = { "/getCurrentStoreStockPoReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoGenItemStock> getCurrentStoreStockPoReport(@RequestParam("grpId")int grpId,@RequestParam("deptId")int deptId) {
		List<GetPoGenItemStock> getStoreCurrentStockList=new ArrayList<GetPoGenItemStock>();

		if(grpId==4)
		{
			 getStoreCurrentStockList=getPoGeneratedItemStockRepository.getCurrentStockGrp2POReport(4,18);
			 for(int i=0;i<getStoreCurrentStockList.size();i++)
				{
					float closingQty=getStoreCurrentStockList.get(i).getStoreOpeningStock()-getStoreCurrentStockList.get(i).getBmsIssueQty()+getStoreCurrentStockList.get(i).getPurRecQty();
					getStoreCurrentStockList.get(i).setStoreClosingStock(closingQty);
				}

		}else if(grpId==5)
		{
			 getStoreCurrentStockList=getPoGeneratedItemStockRepository.getCurrentStockGrp2POReport(5,19);
			 for(int i=0;i<getStoreCurrentStockList.size();i++)
				{
					float closingQty=getStoreCurrentStockList.get(i).getStoreOpeningStock()-getStoreCurrentStockList.get(i).getBmsIssueQty()+getStoreCurrentStockList.get(i).getPurRecQty();
					getStoreCurrentStockList.get(i).setStoreClosingStock(closingQty);
				}

		}else
		{
		 getStoreCurrentStockList=getPoGeneratedItemStockRepository.getCurrentStockPOReport(grpId,deptId);
		for(int i=0;i<getStoreCurrentStockList.size();i++)
		{
			float closingQty=getStoreCurrentStockList.get(i).getStoreOpeningStock()-getStoreCurrentStockList.get(i).getBmsIssueQty()+getStoreCurrentStockList.get(i).getPurRecQty();
			getStoreCurrentStockList.get(i).setStoreClosingStock(closingQty);
		}
		}
		return getStoreCurrentStockList;
	}
}
