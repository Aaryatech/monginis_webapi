package com.ats.webapi.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.ats.webapi.repository.GetFrItemStockConfigurationRepository;
import com.ats.webapi.repository.PostFrOpStockDetailRepository;
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

	@Autowired
	GetFrItemStockConfigurationRepository getFrItemStockConfigurationRepository;

	@RequestMapping(value = "/getMonthwiseStock", method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStockDetails> getStockBetweenMonth(@RequestParam("frId") int frId,
			@RequestParam("fromMonth") int fromMonth, @RequestParam("toMonth") int toMonth,
			@RequestParam("currentMonth") int currentMonth, @RequestParam("itemIdList") List<Integer> itemIdList) {

		System.out.println("inside rest getCurrentStock : I/p : itemIdList: " + itemIdList.toString());

		List<GetCurrentStockDetails> stockBetweenMonthList = postFrOpStockService.getStockBetweenMonth(frId, fromMonth,
				toMonth, itemIdList);

		return stockBetweenMonthList;

	}

	@RequestMapping(value = "/getStockForAutoGrnGvn", method = RequestMethod.POST)
	public @ResponseBody List<StockForAutoGrnGvn> GetPurchaseAndSell(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("fromDateTime") String fromDateTime,
			@RequestParam("toDateTime") String toDateTime, @RequestParam("currentMonth") int currentMonth,
			@RequestParam("year") int year, @RequestParam("itemIdList") List<Integer> itemIdList,
			@RequestParam("catId") int catId) {

		System.out.println("inside rest getStockForAutoGrnGvn : I/p : frId: " + frId);
		System.out.println(" I/p : fromDate: " + fromDate);
		System.out.println(" I/p : fromDateTime: " + fromDateTime);
		System.out.println(" I/p : toDateTime: " + toDateTime);

		System.out.println(" I/p : currentMonth: " + currentMonth);
		System.out.println(" I/p : year: " + year);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date todaysDate = new Date();
		System.out.println(dateFormat.format(todaysDate));

		Calendar cal = Calendar.getInstance();
		cal.setTime(todaysDate);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		Date firstDay = cal.getTime();

		String strFirstDay = dateFormat.format(firstDay);

		System.out.println("First Day of month " + firstDay);
		strFirstDay = strFirstDay + " 00:00:00";
		System.out.println("First Day timestamp " + strFirstDay);

		RegularSpecialStockCal totalPurchaseUptoDateTime = new RegularSpecialStockCal();

		RegularSpecialStockCal totalSellUptoDateTime = new RegularSpecialStockCal();

		List<Item> itemsList = itemService.findItemsByItemId(itemIdList);

		List<StockForAutoGrnGvn> stockDetailsList = new ArrayList<StockForAutoGrnGvn>();

		PostFrItemStockDetail postFrItemStockDetail = new PostFrItemStockDetail();

		for (int i = 0; i < itemsList.size(); i++) {

			int itemId = itemsList.get(i).getId();

			// current stock
			int grnGvn = getItemStockService.getTotalGrnGvnUptoDateTime(frId, strFirstDay, fromDateTime, itemId);

			totalSellUptoDateTime = getItemStockService.getTotalSellUpToDateTime(frId, strFirstDay, fromDateTime,
					itemId);

			totalPurchaseUptoDateTime = getItemStockService.getTotalPurchaseUptoDateTime(frId, strFirstDay,
					fromDateTime, itemId);

			postFrItemStockDetail = getItemStockService.getOpeningStock(frId, currentMonth, year, itemId, catId);

			int regOpStock = postFrItemStockDetail.getRegOpeningStock();
			int spOpStock = postFrItemStockDetail.getSpOpeningStock();

			int regCurrentStock = (regOpStock + totalPurchaseUptoDateTime.getReg())
					- (grnGvn + totalSellUptoDateTime.getReg());
			int spCurrentStock = (spOpStock + totalPurchaseUptoDateTime.getSp()) - (totalSellUptoDateTime.getSp());

			// purchase qty

			// RegularSpecialStockCal totalPurchaseOfDate =
			// getItemStockService.getTotalPurchaseOfDate(frId, fromDate,
			// itemId);

			// sell
			RegularSpecialStockCal totalSellBetweenDate = getItemStockService.getRegTotalSellBetweenDateTime(frId,
					fromDateTime, toDateTime, itemId);

			// grn/gvn
			int grnGvnBetweenDate = getItemStockService.getTotalGrnGvnUptoDateTime(frId, fromDateTime, toDateTime,
					itemId);

			StockForAutoGrnGvn autoGrnGvnStock = new StockForAutoGrnGvn();

			autoGrnGvnStock.setId(itemId);
			autoGrnGvnStock.setItemId(itemsList.get(i).getItemId());
			autoGrnGvnStock.setItemName(itemsList.get(i).getItemName());

			autoGrnGvnStock.setRegCurrentStock(regCurrentStock);
			autoGrnGvnStock.setSpCurrentStock(spCurrentStock);

			// autoGrnGvnStock.setPurchaseQty(totalPurchaseOfDate.getReg());
			// autoGrnGvnStock.setPushQty(totalPurchaseOfDate.getSp());

			autoGrnGvnStock.setPurchaseQty(0);
			autoGrnGvnStock.setPushQty(0);

			autoGrnGvnStock.setRegSellQty(totalSellBetweenDate.getReg());
			autoGrnGvnStock.setSpSellQty(totalSellBetweenDate.getSp());

			autoGrnGvnStock.setGrnGvnQty(grnGvnBetweenDate);

			stockDetailsList.add(autoGrnGvnStock);

		}
		return stockDetailsList;

	}

	@RequestMapping(value = "/getStockBetweenDates", method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStockDetails> getStockBetweenDates(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String strFromDate, @RequestParam("toDate") String strToDate,
			@RequestParam("itemIdList") List<Integer> itemIdList, @RequestParam("catId") int catId,
			@RequestParam("frStockType") int frStockType) {

		System.out.println("inside rest getCurrentStock : I/p : itemIdList: " + itemIdList.toString());
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		List<GetCurrentStockDetails> stockDetailsList = new ArrayList<GetCurrentStockDetails>();

		try {
			Date fromDate = f.parse(strFromDate);

			Date toDate = f.parse(strToDate);
			int n = differenceInMonths(fromDate, toDate);
			
			
			System.out.println("Month Diff Is " + n);

			
			PostFrItemStockDetail postFrItemStockDetail = new PostFrItemStockDetail();

			Calendar cal = Calendar.getInstance();
			cal.setTime(fromDate);
			cal.add(Calendar.DATE, -1);
			Date dateBefore1Day = cal.getTime();
			System.out.println("Day " + fromDate + " Before One day " + dateBefore1Day);

			Date firstDayFromDate = getFirstDateOfMonth(fromDate);
			Date firstDayToDate = getFirstDateOfMonth(toDate);

			DateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");

			String strFirstDay = ymdFormat.format(firstDayFromDate);
			String strBefore1Day = ymdFormat.format(dateBefore1Day);

			String strFirstDayToDate = ymdFormat.format(firstDayToDate);

			System.out.println("first Day " + strFirstDay + " Before One day " + strBefore1Day);

			Calendar calendar = new GregorianCalendar();
			calendar.setTime(firstDayFromDate);
			int year = calendar.get(Calendar.YEAR);
			// Add one to month {0 - 11}
			int month = calendar.get(Calendar.MONTH) + 1;
			
			System.out.println("year "+year+" month "+month);

			calendar.setTime(toDate);
			int toYear = calendar.get(Calendar.YEAR);
			// Add one to month {0 - 11}
			int toMonth = calendar.get(Calendar.MONTH) + 1;

			List<Item> itemsList = itemService.findAllItemsByItemId(itemIdList);

			RegularSpecialStockCal totalRegPurchase = new RegularSpecialStockCal();

			RegularSpecialStockCal totalRegSell = new RegularSpecialStockCal();

			for (int i = 0; i < itemsList.size(); i++) {

				int itemId = itemsList.get(i).getId();

				totalRegPurchase = getItemStockService.getRegTotalPurchase(frId, strFirstDay, strBefore1Day, itemId);

				int totalRegGrnGvn = getItemStockService.getRegTotalGrnGvn(frId, strFirstDay, strBefore1Day, itemId);

				totalRegSell = getItemStockService.getRegTotalSell(frId, strFirstDay, strBefore1Day, itemId);

				System.out.println("Reg Purchase " + totalRegPurchase.toString());

				int regOpFromDate = 0;
				int spOpFromDate = 0;
				int regPurFromDate = 0;
				int spPurFromDate = 0;
				int regSellFromDate = 0;
				int spSellFromDate = 0;
				int grngvnFromDate = 0;

				try {

					System.out.println("for ItemId " + itemId);
					postFrItemStockDetail = new PostFrItemStockDetail();
					postFrItemStockDetail = getItemStockService.getOpeningStock(frId, month, year, itemId, catId);
					
					if (postFrItemStockDetail != null) { 
						System.out.println("fr stock response " + postFrItemStockDetail.toString());
						int regOp = postFrItemStockDetail.getRegOpeningStock();
						int spOp = postFrItemStockDetail.getSpOpeningStock();
						
					
						regOpFromDate = (regOp + totalRegPurchase.getReg()) - (totalRegGrnGvn + totalRegSell.getReg());
						spOpFromDate = (spOp + totalRegPurchase.getSp()) - (totalRegSell.getSp());

					} else {

						regOpFromDate = 0;
						spOpFromDate = 0;

					}

					if (n == 0) { // Same Month
						RegularSpecialStockCal totalLastRegPurchase = getItemStockService.getRegTotalPurchase(frId,
								strFromDate, strToDate, itemId);

						int totalLastRegGrnGvn = getItemStockService.getRegTotalGrnGvn(frId, strFromDate, strToDate,
								itemId);

						RegularSpecialStockCal totalLastRegSell = getItemStockService.getRegTotalSell(frId, strFromDate,
								strToDate, itemId);

						System.out.println("Reg Purchase of same month " + totalLastRegPurchase.toString());

						GetCurrentStockDetails getCurrentStockDetails = new GetCurrentStockDetails();

						getCurrentStockDetails.setStockHeaderId(0);
						getCurrentStockDetails.setStockDetailId(0);
						getCurrentStockDetails.setRegOpeningStock(regOpFromDate);
						getCurrentStockDetails.setSpOpeningStock(spOpFromDate);
						getCurrentStockDetails.setRegTotalGrnGvn(totalLastRegGrnGvn);
						getCurrentStockDetails.setRegTotalPurchase(totalLastRegPurchase.getReg());
						getCurrentStockDetails.setSpTotalPurchase(totalLastRegPurchase.getSp());
						getCurrentStockDetails.setRegTotalSell(totalLastRegSell.getReg());
						getCurrentStockDetails.setSpTotalSell(totalLastRegSell.getSp());
						getCurrentStockDetails.setId(itemsList.get(i).getId());
						getCurrentStockDetails.setItemId(itemsList.get(i).getItemId());
						getCurrentStockDetails.setItemName(itemsList.get(i).getItemName());
						getCurrentStockDetails.setReOrderQty(0);
						getCurrentStockDetails.setCurrentRegStock((regOpFromDate + totalLastRegPurchase.getReg())
								- (totalLastRegGrnGvn + totalLastRegSell.getReg()));
						getCurrentStockDetails.setCurrentSpStock(
								(spOpFromDate + totalLastRegPurchase.getSp()) - (totalLastRegSell.getSp()));

						stockDetailsList.add(getCurrentStockDetails);

					} else { // Different Month
						
						
						RegularSpecialStockCal totalLastRegPurchase = getItemStockService.getRegTotalPurchase(frId,
								strFromDate, strToDate, itemId);

						int totalLastRegGrnGvn = getItemStockService.getRegTotalGrnGvn(frId, strFromDate, strToDate,
								itemId);

						RegularSpecialStockCal totalLastRegSell = getItemStockService.getRegTotalSell(frId, strFromDate,
								strToDate, itemId);

						System.out.println("Reg Purchase of same month " + totalLastRegPurchase.toString());

						GetCurrentStockDetails getCurrentStockDetails = new GetCurrentStockDetails();

						getCurrentStockDetails.setStockHeaderId(0);
						getCurrentStockDetails.setStockDetailId(0);
						getCurrentStockDetails.setRegOpeningStock(regOpFromDate);
						getCurrentStockDetails.setSpOpeningStock(spOpFromDate);
						getCurrentStockDetails.setRegTotalGrnGvn(totalLastRegGrnGvn);
						getCurrentStockDetails.setRegTotalPurchase(totalLastRegPurchase.getReg());
						getCurrentStockDetails.setSpTotalPurchase(totalLastRegPurchase.getSp());
						getCurrentStockDetails.setRegTotalSell(totalLastRegSell.getReg());
						getCurrentStockDetails.setSpTotalSell(totalLastRegSell.getSp());
						getCurrentStockDetails.setId(itemsList.get(i).getId());
						getCurrentStockDetails.setItemId(itemsList.get(i).getItemId());
						getCurrentStockDetails.setItemName(itemsList.get(i).getItemName());
						getCurrentStockDetails.setReOrderQty(0);
						getCurrentStockDetails.setCurrentRegStock((regOpFromDate + totalLastRegPurchase.getReg())
								- (totalLastRegGrnGvn + totalLastRegSell.getReg()));
						getCurrentStockDetails.setCurrentSpStock(
								(spOpFromDate + totalLastRegPurchase.getSp()) - (totalLastRegSell.getSp()));

						stockDetailsList.add(getCurrentStockDetails);
		 
						 
						 
						
//						String strCalFromDate=strFromDate;
//						String strCalToDate=strToDate;
//						
//						for(int d=1;d<=n;d++) {
//														
//							if(d==n) {
//								
//								getTransactionBetweenDates(strCalFromDate,strCalToDate,itemsList.get(i),frId, catId);
//								
//							}else {
//								
//								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//								LocalDate localDate = LocalDate.parse(strCalFromDate,formatter);
//								LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
//
//								 strCalToDate = lastDayOfMonth.format(formatter);
//								 								 
//								getTransactionBetweenDates(strCalFromDate,strCalToDate,itemsList.get(i),frId, catId);
//														
//								Date lastDay = f.parse(strCalToDate);
//								
//								cal.setTime(lastDay);
//								cal.add(Calendar.DATE, 1);
//								Date incrDate = cal.getTime();
//								strCalFromDate= f.format(incrDate);
//								
//							}
							
							
							
						}
						
					

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stockDetailsList;

	}

	private void getTransactionBetweenDates(String strFromDate, String strToDate, Item item, int frId,  int catId) throws ParseException {
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(f.parse(strFromDate));
		int year = calendar.get(Calendar.YEAR);
		
		int month = calendar.get(Calendar.MONTH) + 1;
		
		System.out.println("year "+year+" month "+month);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate localDate = LocalDate.parse(strFromDate,formatter);
		LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
		LocalDate firstDayOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());

		String strLastDate = lastDayOfMonth.format(formatter);
		String strFirstDate = firstDayOfMonth.format(formatter);

		if(strFromDate.equalsIgnoreCase(strFirstDate) && strToDate.equalsIgnoreCase(strLastDate)) {
			
			
		}
		
		
		PostFrItemStockDetail postFrItemStockDetail = new PostFrItemStockDetail();
		postFrItemStockDetail = getItemStockService.getOpeningStock(frId, month, year, item.getId(),
				catId);

		RegularSpecialStockCal totalLastRegPurchase = getItemStockService.getRegTotalPurchase(frId,
				strFromDate, strToDate, item.getId());

		int totalLastRegGrnGvn = getItemStockService.getRegTotalGrnGvn(frId, strFromDate,
				strToDate,  item.getId());

		RegularSpecialStockCal totalLastRegSell = getItemStockService.getRegTotalSell(frId,
				strFromDate, strToDate, item.getId());


		
		
	}

	public static Date getFirstDateOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
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
		String regData = JsonUtil.javaToJson(franchiseeList);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();
		// responseHeaders.set("charset", "utf-8");
		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
		responseHeaders.setContentLength(output.length);
		responseHeaders.set("Content-disposition", "attachment; filename=allfr.txt");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/getCurrentStock", method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStockDetails> getCurrentStock(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("currentMonth") int currentMonth, @RequestParam("year") int year,
			@RequestParam("itemIdList") List<Integer> itemIdList, @RequestParam("catId") int catId,
			@RequestParam("frStockType") int frStockType) {

		System.out.println("inside rest getCurrentStock : I/p : frId: " + frId);
		System.out.println("inside rest getCurrentStock : I/p : frStockType: " + frStockType);
		System.out.println("inside rest getCurrentStock : I/p : fromDate: " + fromDate);
		System.out.println("inside rest getCurrentStock : I/p : toDate: " + toDate);
		System.out.println("inside rest getCurrentStock : I/p : currentMonth: " + currentMonth);
		System.out.println("inside rest getCurrentStock : I/p : year: " + year);
		System.out.println("inside rest getCurrentStock : I/p : itemIdList: " + itemIdList.toString());

		List<GetCurrentStockDetails> stockDetailsList = new ArrayList<GetCurrentStockDetails>();
		PostFrItemStockDetail postFrItemStockDetail = new PostFrItemStockDetail();

		List<Item> itemsList = itemService.findAllItemsByItemId(itemIdList);

		RegularSpecialStockCal totalRegPurchase = new RegularSpecialStockCal();

		RegularSpecialStockCal totalRegSell = new RegularSpecialStockCal();

		for (int i = 0; i < itemsList.size(); i++) {

			int itemId = itemsList.get(i).getId();

			totalRegPurchase = getItemStockService.getRegTotalPurchase(frId, fromDate, toDate, itemId);

			int totalRegGrnGvn = getItemStockService.getRegTotalGrnGvn(frId, fromDate, toDate, itemId);

			totalRegSell = getItemStockService.getRegTotalSell(frId, fromDate, toDate, itemId);

			System.out.println("Reg Purchase " + totalRegPurchase.toString());

			int reorderQty = 0;

			try {
				reorderQty = getFrItemStockConfigurationRepository.findByItemIdAndType(itemId, frStockType);
			} catch (Exception e) {
				reorderQty = 0;
			}

			try {

				System.out.println("for ItemId " + itemId);
				postFrItemStockDetail = getItemStockService.getOpeningStock(frId, currentMonth, year, itemId, catId);

				if (postFrItemStockDetail != null) {
					System.out.println("fr stock response " + postFrItemStockDetail.toString());

					GetCurrentStockDetails getCurrentStockDetails = new GetCurrentStockDetails();

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
					getCurrentStockDetails.setItemId(itemsList.get(i).getItemId());
					getCurrentStockDetails.setItemName(itemsList.get(i).getItemName());
					getCurrentStockDetails.setReOrderQty(reorderQty);
					getCurrentStockDetails
							.setCurrentRegStock((postFrItemStockDetail.getRegOpeningStock() + totalRegPurchase.getReg())
									- (totalRegGrnGvn + totalRegSell.getReg()));
					getCurrentStockDetails
							.setCurrentSpStock((postFrItemStockDetail.getSpOpeningStock() + totalRegPurchase.getSp())
									- (totalRegSell.getSp()));

					if (itemsList.get(i).getDelStatus() == 0) {
						stockDetailsList.add(getCurrentStockDetails);

					} else if (itemsList.get(i).getDelStatus() == 1) {

						if (getCurrentStockDetails.getCurrentRegStock() > 0) {
							stockDetailsList.add(getCurrentStockDetails);
						}

					}

				} else {

					GetCurrentStockDetails getCurrentStockDetails = new GetCurrentStockDetails();

					getCurrentStockDetails.setStockHeaderId(0);
					getCurrentStockDetails.setStockDetailId(0);
					getCurrentStockDetails.setRegOpeningStock(0);
					getCurrentStockDetails.setSpOpeningStock(0);
					getCurrentStockDetails.setRegTotalGrnGvn(totalRegGrnGvn);
					getCurrentStockDetails.setRegTotalPurchase(totalRegPurchase.getReg());
					getCurrentStockDetails.setSpTotalPurchase(totalRegPurchase.getSp());
					getCurrentStockDetails.setRegTotalSell(totalRegSell.getReg());
					getCurrentStockDetails.setSpTotalSell(totalRegSell.getSp());
					getCurrentStockDetails.setId(itemsList.get(i).getId());
					getCurrentStockDetails.setItemId(itemsList.get(i).getItemId());
					getCurrentStockDetails.setItemName(itemsList.get(i).getItemName());
					getCurrentStockDetails
							.setCurrentRegStock((totalRegPurchase.getReg()) - (totalRegGrnGvn + totalRegSell.getReg()));
					getCurrentStockDetails.setCurrentSpStock(totalRegPurchase.getSp() - totalRegSell.getSp());

					if (itemsList.get(i).getDelStatus() == 0) {
						stockDetailsList.add(getCurrentStockDetails);

					} else if (itemsList.get(i).getDelStatus() == 1) {

						if (getCurrentStockDetails.getCurrentRegStock() > 0) {
							stockDetailsList.add(getCurrentStockDetails);
						}

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.out.println("getCurrentStock Result: " + stockDetailsList.toString());

		return stockDetailsList;

	}

	// 31-10-2017
	@RequestMapping(value = { "/updateEndMonth" }, method = RequestMethod.POST)
	public @ResponseBody Info updateEndMonth(@RequestBody PostFrItemStockHeader postFrItemStockHeader) {

		System.out.println("updateEndMonth Request Data:  " + postFrItemStockHeader.toString());

		int a = postFrOpStockService.updateEndMonth(postFrItemStockHeader);

		Info info = new Info();

		if (a > 0) {
			info.setError(false);
			info.setMessage("End Month  Successfully");
		} else {
			info.setError(true);
			info.setMessage("End Month Unsuccessfull : RestApi");
		}

		return info;

	}

	@RequestMapping(value = "/getRunningMonth", method = RequestMethod.POST)
	public @ResponseBody PostFrItemStockHeader getRunningMonth(@RequestParam("frId") int frId) {

		System.out.println("inside rest getRunningMonth");

		PostFrItemStockHeader frItemStockHeader = postFrOpStockService.getRunningMonth(frId);

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
		} else {
			info.setError(true);
			info.setMessage("Error in post Fr Stock header insertion : RestApi");
		}

		return info;

	}

	@RequestMapping(value = { "/getPostFrOpStock" }, method = RequestMethod.POST)
	public @ResponseBody PostFrItemStockHeader getPostFrOpStock(@RequestParam("month") int month,
			@RequestParam("year") int year, @RequestParam("frId") int frId)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		PostFrItemStockHeader postFrItemStockHeader;

		postFrItemStockHeader = postFrOpStockService.getFrOpStockHeader(frId, month, year);
		System.out.println("Data Common " + postFrItemStockHeader.toString());

		Info info = new Info();

		if (postFrItemStockHeader.toString() != null) {
			info.setError(false);
			info.setMessage("post Fr Stock header inserted  Successfully");
		} else {
			info.setError(true);
			info.setMessage("Error in post Fr Stock header insertion : RestApi");
		}

		return postFrItemStockHeader;

	}

	private static int differenceInMonths(Date s1, Date s2) {
		final Calendar d1 = Calendar.getInstance();
		d1.setTime(s1);
		final Calendar d2 = Calendar.getInstance();
		d2.setTime(s2);
		int diff = (d2.get(Calendar.YEAR) - d1.get(Calendar.YEAR)) * 12 + d2.get(Calendar.MONTH)
				- d1.get(Calendar.MONTH);
		return diff;
	}
}
