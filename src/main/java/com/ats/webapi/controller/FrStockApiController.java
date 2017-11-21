package com.ats.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.FrItemStockConfigurePost;
import com.ats.webapi.model.GetCurrentStockDetails;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.RegularSpecialStockCal;
import com.ats.webapi.service.FrItemStockConfigurePostService;
import com.ats.webapi.service.GetItemStockService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.PostFrOpStockService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class FrStockApiController {

	
	@Autowired
	PostFrOpStockService postFrOpStockService;
	
	@Autowired
	private ItemService itemService;

	@Autowired
	FrItemStockConfigurePostService frItemStockConfigurePostService;

	@Autowired
	GetItemStockService getItemStockService;

	
	@RequestMapping(value = "/getMonthwiseStock", method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStockDetails>  getStockBetweenMonth(@RequestParam("frId") int frId, @RequestParam("fromMonth") int fromMonth,
			@RequestParam("toMonth") int toMonth, @RequestParam("currentMonth") int currentMonth,
			@RequestParam("itemIdList") List<Integer> itemIdList) {

		System.out.println("inside rest getCurrentStock");
		
		
		List<GetCurrentStockDetails>stockBetweenMonthList=postFrOpStockService.getStockBetweenMonth(frId, fromMonth, toMonth,itemIdList);
		
	
		
		return stockBetweenMonthList; 

	}
	
	
	@RequestMapping(value = "/getCurrentStock", method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStockDetails>  getCurrentStock(@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("currentMonth") int currentMonth,@RequestParam("year") int year,
			@RequestParam("itemIdList") List<Integer> itemIdList ,@RequestParam("catId") int catId) {

		System.out.println("inside rest getCurrentStock : I/p : frId: "+frId);
		System.out.println("inside rest getCurrentStock : I/p : fromDate: "+fromDate);
		System.out.println("inside rest getCurrentStock : I/p : toDate: "+toDate);
		System.out.println("inside rest getCurrentStock : I/p : currentMonth: "+currentMonth);
		System.out.println("inside rest getCurrentStock : I/p : year: "+year);

		System.out.println("inside rest getCurrentStock : I/p : itemIdList: "+itemIdList.toString());

		
		List<GetCurrentStockDetails> stockDetailsList=new ArrayList<GetCurrentStockDetails>();
		PostFrItemStockDetail postFrItemStockDetail=new PostFrItemStockDetail();
		
		List<Item> itemsList = itemService.findItemsByItemId(itemIdList);
		
		
		RegularSpecialStockCal totalRegPurchase =new RegularSpecialStockCal();
		
		RegularSpecialStockCal totalRegSell =new RegularSpecialStockCal();

		
		for(int i=0;i<itemsList.size();i++) {
			
			int itemId=itemsList.get(i).getId();

	    totalRegPurchase = getItemStockService.getRegTotalPurchase(frId, fromDate, toDate, itemId);

		int totalRegGrnGvn = getItemStockService.getRegTotalGrnGvn(frId, fromDate, toDate, itemId);

		totalRegSell = getItemStockService.getRegTotalSell(frId, fromDate, toDate, itemId);

		
		 System.out.println("Reg Purchase "+totalRegPurchase.toString());
		
		
		try {
		postFrItemStockDetail = getItemStockService.getOpeningStock(frId, currentMonth, year,itemId ,catId);
			
		GetCurrentStockDetails getCurrentStockDetails=new GetCurrentStockDetails();
		
		getCurrentStockDetails.setStockHeaderId(postFrItemStockDetail.getOpeningStockHeaderId());
		getCurrentStockDetails.setStockDetailId(postFrItemStockDetail.getOpeningStockDetailId());
		getCurrentStockDetails.setRegOpeningStock(postFrItemStockDetail.getRegOpeningStock());
		getCurrentStockDetails.setSpOpeningStock(postFrItemStockDetail.getSpOpeningStock());
		getCurrentStockDetails.setRegTotalGrnGvn(totalRegGrnGvn);
		getCurrentStockDetails.setRegTotalPurchase(totalRegPurchase.getReg());
		getCurrentStockDetails.setSpTotalPurchase(totalRegPurchase.getSp());
		getCurrentStockDetails.setRegTotalSell(totalRegSell.getReg());
		getCurrentStockDetails.setSpTotalSell(totalRegSell.getSp());
		getCurrentStockDetails.setId(postFrItemStockDetail.getItemId());
		getCurrentStockDetails.setItemId(itemsList.get(i).getItemId() );
		getCurrentStockDetails.setItemName(itemsList.get(i).getItemName());
		getCurrentStockDetails.setCurrentRegStock((postFrItemStockDetail.getRegOpeningStock()+totalRegPurchase.getReg()) - (totalRegGrnGvn+totalRegSell.getReg()));
		getCurrentStockDetails.setCurrentSpStock((postFrItemStockDetail.getSpOpeningStock()+totalRegPurchase.getSp()) - (totalRegSell.getSp()));

		stockDetailsList.add(getCurrentStockDetails);
		
		}catch (Exception e) {
			
			e.printStackTrace();
			
			}
		 
		 
		}
		
		System.out.println("getCurrentStock Result: "+stockDetailsList.toString());
		
		
		return stockDetailsList; 

	}
	
		
	//31-10-2017
	@RequestMapping(value = { "/updateEndMonth" }, method = RequestMethod.POST)

	public @ResponseBody Info updateEndMonth(@RequestBody PostFrItemStockHeader postFrItemStockHeader)
		//	throws ParseException, JsonParseException, JsonMappingException, IOException 
	{

		System.out.println("updateEndMonth Request Data:  " + postFrItemStockHeader.toString());

		
		int a = postFrOpStockService.updateEndMonth(postFrItemStockHeader);

		Info info = new Info();

		if (a > 0) {

			info.setError(false);
			info.setMessage("End Month  Successfully");

		}

		else {

			info.setError(true);
			info.setMessage("End Month Unsuccessfull : RestApi");

		}

		
		
		
		
		return info;

	}
	
	
	
	
	
	@RequestMapping(value = "/getRunningMonth", method = RequestMethod.POST)
	public @ResponseBody PostFrItemStockHeader  getRunningMonth(@RequestParam("frId") int frId ) {

		System.out.println("inside rest getRunningMonth");
		
		PostFrItemStockHeader frItemStockHeader=postFrOpStockService.getRunningMonth(frId);
		
		return frItemStockHeader; 

	}
	
	
	
	
	@RequestMapping(value = { "/postFrOpStock" }, method = RequestMethod.POST)

	public @ResponseBody Info postFrOpStock(@RequestBody PostFrItemStockHeader postFrItemStockHeader)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Data Common " + postFrItemStockHeader.toString());

		List<PostFrItemStockHeader> jsonBillHeader;

		jsonBillHeader = postFrOpStockService.saveFrOpStockHeader(postFrItemStockHeader);

		Info info = new Info();

		if (jsonBillHeader.size() > 0) {

			info.setError(false);
			info.setMessage("post Fr Stock header inserted  Successfully");

		} 

		else {

			info.setError(true);
			info.setMessage("Error in post Fr Stock header insertion : RestApi");

		}

		return info;

	}
	
	
	@RequestMapping(value = { "/getPostFrOpStock" }, method = RequestMethod.POST)

	public @ResponseBody PostFrItemStockHeader getPostFrOpStock(@RequestParam("month") int month,
			@RequestParam("year") int year, @RequestParam("frId") int frId )
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		
		PostFrItemStockHeader postFrItemStockHeader;

		postFrItemStockHeader = postFrOpStockService.getFrOpStockHeader(frId, month, year);
		System.out.println("Data Common " + postFrItemStockHeader.toString());

		Info info = new Info();

		if (postFrItemStockHeader.toString()!=null) {

			info.setError(false);
			info.setMessage("post Fr Stock header inserted  Successfully");

		}

		else {

			info.setError(true);
			info.setMessage("Error in post Fr Stock header insertion : RestApi");

		}

		return postFrItemStockHeader;

	}
	
	

	@RequestMapping(value = { "/frItemStockPost" }, method = RequestMethod.POST)
	public @ResponseBody Info info(@RequestBody List<FrItemStockConfigurePost> frItemStockConfigurePosts)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		List<FrItemStockConfigurePost> jsonResult;

		jsonResult = frItemStockConfigurePostService.saveFrItemStockConf(frItemStockConfigurePosts);

		Info info = new Info();

		if (jsonResult.size() > 0) {

			info.setError(false);
			info.setMessage("fr Item stock Inserted Successfully");

		}

		else {
			info.setError(true);
			info.setMessage("Error in frItem Stock Insertion  : RestApi");
		}

		return info;

	}

	
	
	

	

	
	
}
