package com.ats.webapi.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrItemStockConfigurePost;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.FranchiseeList;
import com.ats.webapi.model.GetCurrentStockDetails;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.RegularSpecialStockCal;
import com.ats.webapi.model.StockForAutoGrnGvn;
import com.ats.webapi.service.FrItemStockConfigurePostService;
import com.ats.webapi.service.FranchiseeService;
import com.ats.webapi.service.GetItemStockService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.PostFrOpStockService;
import com.ats.webapi.util.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class FrStockApiController {

	
	@Autowired
	private FranchiseeService franchiseeService;

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

		
		System.out.println("inside rest getCurrentStock : I/p : itemIdList: "+itemIdList.toString());

		
		List<GetCurrentStockDetails>stockBetweenMonthList=postFrOpStockService.getStockBetweenMonth(frId, fromMonth, toMonth,itemIdList);
		
	
		
		return stockBetweenMonthList; 

	}
	
	
	@RequestMapping(value = "/getStockForAutoGrnGvn", method = RequestMethod.POST)
	public @ResponseBody List<StockForAutoGrnGvn>  GetPurchaseAndSell(@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,@RequestParam("fromDateTime") String fromDateTime,
			@RequestParam("toDateTime") String toDateTime, @RequestParam("currentMonth") int currentMonth,@RequestParam("year") int year,
			@RequestParam("itemIdList") List<Integer> itemIdList ,@RequestParam("catId") int catId) {

		System.out.println("inside rest getPurchaseAndSell : I/p : frId: "+frId);
		System.out.println(" I/p : fromDate: "+fromDate);
		System.out.println(" I/p : fromDateTime: "+fromDateTime);
		System.out.println(" I/p : toDateTime: "+toDateTime);

		System.out.println(" I/p : currentMonth: "+currentMonth);
		System.out.println(" I/p : year: "+year);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date todaysDate = new Date();
		System.out.println(dateFormat.format(todaysDate));

		Calendar cal = Calendar.getInstance();
		cal.setTime(todaysDate);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		Date firstDay = cal.getTime();


		String strFirstDay=dateFormat.format(firstDay);
			
		System.out.println("First Day of month " + firstDay);
		strFirstDay=strFirstDay+" 00:00:00";
		System.out.println("First Day timestamp " + strFirstDay);


		
		RegularSpecialStockCal totalPurchaseUptoDateTime =new RegularSpecialStockCal();
		
		RegularSpecialStockCal totalSellUptoDateTime =new RegularSpecialStockCal();
		
		List<Item> itemsList = itemService.findItemsByItemId(itemIdList);
		
		List<StockForAutoGrnGvn> stockDetailsList=new ArrayList<StockForAutoGrnGvn>();
		
		
		PostFrItemStockDetail postFrItemStockDetail=new PostFrItemStockDetail();

		
		for(int i=0;i<itemsList.size();i++) {
			
			int itemId=itemsList.get(i).getId();
		
		
			// current stock
		int grnGvn = getItemStockService.getTotalGrnGvnUptoDateTime( frId,  strFirstDay,toDateTime, itemId );

		totalSellUptoDateTime = getItemStockService.getTotalSellUpToDateTime( frId,  strFirstDay,  toDateTime, itemId );

		totalPurchaseUptoDateTime=getItemStockService.getTotalPurchaseUptoDateTime(frId, strFirstDay, toDateTime, itemId);
		
		postFrItemStockDetail = getItemStockService.getOpeningStock(frId, currentMonth, year,itemId ,catId);

		
		int regOpStock = postFrItemStockDetail.getRegOpeningStock();
		int spOpStock= postFrItemStockDetail.getSpOpeningStock();
		
		int regCurrentStock = (regOpStock + totalPurchaseUptoDateTime.getReg() ) - ( grnGvn + totalSellUptoDateTime.getReg() );
		int spCurrentStock = (spOpStock + totalPurchaseUptoDateTime.getSp() ) - ( totalSellUptoDateTime.getSp() );
		
		
		//purchase qty
		RegularSpecialStockCal totalPurchaseOfDate=getItemStockService.getTotalPurchaseOfDate(frId, fromDate, itemId);
		
		//sell
		
		RegularSpecialStockCal totalSellBetweenDate=getItemStockService.getRegTotalSellBetweenDateTime(frId, fromDateTime, toDateTime, itemId);

		
		
		//grn/gvn
		
		int grnGvnBetweenDate = getItemStockService.getTotalGrnGvnUptoDateTime( frId,  fromDateTime,toDateTime, itemId );

		
		StockForAutoGrnGvn autoGrnGvnStock=new StockForAutoGrnGvn();
		
		autoGrnGvnStock.setId(itemId);
		autoGrnGvnStock.setItemId(itemsList.get(i).getItemId());
		autoGrnGvnStock.setItemName(itemsList.get(i).getItemName());
		autoGrnGvnStock.setRegCurrentStock(regCurrentStock);
		autoGrnGvnStock.setSpCurrentStock(spCurrentStock);
		
		autoGrnGvnStock.setPurchaseQty(totalPurchaseOfDate.getReg());
		autoGrnGvnStock.setPushQty(totalPurchaseOfDate.getSp());
		
		autoGrnGvnStock.setRegSellQty(totalSellBetweenDate.getReg());
		autoGrnGvnStock.setSpSellQty(totalSellBetweenDate.getSp());
		
		autoGrnGvnStock.setGrnGvnQty(grnGvnBetweenDate);
		
		stockDetailsList.add(autoGrnGvnStock);
		
		
	    
		}
		return stockDetailsList; 

	}
	
	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> getFile() {
		
 
		    List<Franchisee> franchisee = franchiseeService.findAllFranchisee();
			FranchiseeList franchiseeList = new FranchiseeList();
			franchiseeList.setFranchiseeList(franchisee);
			ErrorMessage errorMessage = new ErrorMessage();
			if (franchisee != null) {
				errorMessage.setError(false);
				errorMessage.setMessage("Franchisee displayed Successfully");
				franchiseeList.setErrorMessage(errorMessage);

			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Franchisee Not displayed");
				franchiseeList.setErrorMessage(errorMessage);
			}
			 String regData =JsonUtil.javaToJson(franchiseeList);
					 
				
			    byte[] output = regData.getBytes();

		    
		    
		    HttpHeaders responseHeaders = new HttpHeaders();
		   // responseHeaders.set("charset", "utf-8");
		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
		    responseHeaders.setContentLength(output.length);
		    responseHeaders.set("Content-disposition", "attachment; filename=allfr.txt");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
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
