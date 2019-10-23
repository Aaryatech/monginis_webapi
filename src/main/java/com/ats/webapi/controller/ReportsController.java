package com.ats.webapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.BillWisePurchaseList;
import com.ats.webapi.model.BillWiseTaxReportList;
import com.ats.webapi.model.ItemListWithDateRecord;
import com.ats.webapi.model.ItemRecordByDate;
import com.ats.webapi.model.ItemWiseDetailList;
import com.ats.webapi.model.ItemWiseReportList;
import com.ats.webapi.model.MonthWiseReportList;
import com.ats.webapi.model.report.DispatchReport;
import com.ats.webapi.model.report.GetCustBillTax;
import com.ats.webapi.model.report.GetCustomerBill;
import com.ats.webapi.model.report.GetRepFrDatewiseSell;
import com.ats.webapi.model.report.GetRepItemwiseSell;
import com.ats.webapi.model.report.GetRepMenuwiseSell;
import com.ats.webapi.model.report.GetRepMonthwiseSell;
import com.ats.webapi.model.report.GetRepTaxSell;
import com.ats.webapi.repository.ItemListWithDateRecordRepo;
import com.ats.webapi.repository.ItemRecordByDateRepo;
import com.ats.webapi.service.RepFrSellServise;
import com.ats.webapi.service.ReportsService;

import ch.qos.logback.classic.pattern.DateConverter;

@RestController
public class ReportsController {

	@Autowired
	ReportsService reportsService;

	@Autowired
	RepFrSellServise repFrSellServise;

	@Autowired
	ItemListWithDateRecordRepo itemListWithDateRecordRepo;

	@Autowired
	ItemRecordByDateRepo itemRecordByDateRepo;

	@RequestMapping(value = { "/showBillWisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody BillWisePurchaseList showBillWisePurchase(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		BillWisePurchaseList billWisePurchaseList = reportsService.getBillWisePurchaseReport(frId, fromDate, toDate);

		return billWisePurchaseList;
	}

	@RequestMapping(value = { "/showItemWiseDetailsReport" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseDetailList showItemWiseDetail(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("catId") int catId) {

		ItemWiseDetailList ItemWiseDetailList = reportsService.getItemWiseDetailReport(frId, catId, fromDate, toDate);

		return ItemWiseDetailList;
	}

	@RequestMapping(value = { "/showItemWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseReportList showItemWiseReport(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("catId") int catId) {

		ItemWiseReportList ItemWiseReportList = reportsService.getItemWiseReport(frId, catId, fromDate, toDate);

		return ItemWiseReportList;
	}

	@RequestMapping(value = { "/showMonthWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody MonthWiseReportList showMonthWiseReport(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		MonthWiseReportList monthWiseReportList = reportsService.getMonthWiseReport(frId, fromDate, toDate);

		return monthWiseReportList;
	}

	@RequestMapping(value = { "/showBillWiseTaxReport" }, method = RequestMethod.POST)
	public @ResponseBody BillWiseTaxReportList showBillWiseTaxReport(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		BillWiseTaxReportList billWiseTaxReportList = reportsService.getBillWiseTaxReport(frId, fromDate, toDate);

		return billWiseTaxReportList;
	}

	// -----------------------------------------------------------------------------------
	// Sell Reports start

	@RequestMapping(value = "/getRepDatewiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepFrDatewiseSell> getRepDatewiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepFrDatewiseSell> repFrDatewiseSellList = repFrSellServise.getDatewiseSellReport(fromDate, toDate,
				frId);
		return repFrDatewiseSellList;

	}

	// ---------------------------------Dispatch Item
	// Report-----------------------------------------
	@RequestMapping(value = "/getDispatchItemReport", method = RequestMethod.POST)
	public @ResponseBody List<DispatchReport> getDispatchItemReport(@RequestParam("billDate") String billDate,
			@RequestParam("frId") List<String> frId, @RequestParam("categories") List<String> categories) {

		String billDateYMD = Common.convertToYMD(billDate);
		List<DispatchReport> dispatchReportList = reportsService.getDispatchItemReport(billDateYMD, frId, categories);
		return dispatchReportList;

	}

	// ---------------------------------Dispatch Item
	// Report-----------------------------------------
	@RequestMapping(value = "/getDispatchItemReportByOrder", method = RequestMethod.POST)
	public @ResponseBody List<DispatchReport> getDispatchItemReportByOrder(@RequestParam("billDate") String billDate,
			@RequestParam("frId") List<String> frId, @RequestParam("categories") List<String> categories) {

		String billDateYMD = Common.convertToYMD(billDate);
		List<DispatchReport> dispatchReportList = reportsService.getDispatchItemReportByOrder(billDateYMD, frId,
				categories);
		return dispatchReportList;

	}

	// ---------------------------Station report---------------

	@RequestMapping(value = "/getStationItemReport", method = RequestMethod.POST)
	public @ResponseBody List<DispatchReport> getStationItemReport(@RequestParam("billDate") String billDate,
			@RequestParam("frId") List<String> frId, @RequestParam("itemIdList") List<Integer> itemIdList) {

		System.out.println("itemIdList" + itemIdList.toString());

		String billDateYMD = Common.convertToYMD(billDate);
		List<DispatchReport> dispatchReportList = reportsService.getStationItemReport(billDateYMD, frId, itemIdList);
		return dispatchReportList;

	}

	// ------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getRepMonthwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepMonthwiseSell> getRepMonthwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		System.out.println("from" + fromDate);
		System.out.println("to" + toDate);

		/*
		 * fromDate = Common.convertToYMD(fromDate); toDate =
		 * Common.convertToYMD(toDate);
		 */

		System.out.println("to" + toDate);
		System.out.println("from" + fromDate);
		List<GetRepMonthwiseSell> GetRepMonthwiseSellList = repFrSellServise.getMonthwiseSellReport(fromDate, toDate,
				frId);
		return GetRepMonthwiseSellList;

	}

	@RequestMapping(value = "/getRepItemwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepItemwiseSell> getRepItemwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId,
			@RequestParam("catId") List<String> catId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepItemwiseSell> getRepItemwiseSellList = repFrSellServise.getItemwiseSellReport(fromDate, toDate, frId,
				catId);
		return getRepItemwiseSellList;

	}

	@RequestMapping(value = "/getRepMenuwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepMenuwiseSell> getRepMenuwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepMenuwiseSell> getRepMenuwiseSellList = repFrSellServise.getMenuwiseSellReport(fromDate, toDate,
				frId);
		return getRepMenuwiseSellList;

	}

	@RequestMapping(value = "/getRepDateItemwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepItemwiseSell> getRepDateItemwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId,
			@RequestParam("catId") List<String> catId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepItemwiseSell> getRepItemwiseSellList = repFrSellServise.getDateItemwiseSellReport(fromDate, toDate,
				frId, catId);
		return getRepItemwiseSellList;

	}

	@RequestMapping(value = "/getRepDateCatwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepItemwiseSell> getRepDateCatwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId,
			@RequestParam("catId") List<String> catId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepItemwiseSell> getRepItemwiseSellList = repFrSellServise.getDateCatwiseSellReport(fromDate, toDate,
				frId, catId);
		return getRepItemwiseSellList;

	}

	@RequestMapping(value = "/getRepTaxSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepTaxSell> getRepTaxSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepTaxSell> getRepTaxSellList = repFrSellServise.getTaxSellReport(fromDate, toDate, frId);
		System.out.println("  List  :" + getRepTaxSellList);
		return getRepTaxSellList;

	}

	@RequestMapping(value = "/getRepDatewiseTaxSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepTaxSell> getRepDatewiseTaxSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepTaxSell> getRepTaxSellList = repFrSellServise.getDatewiseTaxSellReport(fromDate, toDate, frId);
		System.out.println("  List  :" + getRepTaxSellList);
		return getRepTaxSellList;

	}

	@RequestMapping(value = "/getRepBillwiseTaxSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepTaxSell> getRepBillwiseTaxSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepTaxSell> getRepTaxSellList = repFrSellServise.getBillwiseTaxSellReport(fromDate, toDate, frId);
		System.out.println("  List  :" + getRepTaxSellList);
		return getRepTaxSellList;

	}

	// Sell Report
	// End-------------------------------------------------------------------

	// customer bill-----------------------

	@RequestMapping(value = "/getCustomerBill", method = RequestMethod.POST)
	public @ResponseBody List<GetCustomerBill> getCustomerBill(@RequestParam("billNo") int billNo) {

		List<GetCustomerBill> getCustomerBillList = repFrSellServise.getCustBill(billNo);
		System.out.println("  List  :" + getCustomerBillList);
		return getCustomerBillList;

	}

	@RequestMapping(value = "/getCustomerBillTax", method = RequestMethod.POST)
	public @ResponseBody List<GetCustBillTax> getCustomerBillTax(@RequestParam("billNo") int billNo) {

		List<GetCustBillTax> getCustBillTaxList = repFrSellServise.getCustBillTax(billNo);
		System.out.println("  List  :" + getCustBillTaxList);
		return getCustBillTaxList;

	}

	@RequestMapping(value = "/getorderreportByItemIdandDate", method = RequestMethod.POST)
	public @ResponseBody List<ItemListWithDateRecord> getorderreportByItemIdandDate(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<ItemListWithDateRecord> list = new ArrayList<>();

		try {

			List<Date> dates = new ArrayList<Date>();

			DateFormat formatter;

			formatter = new SimpleDateFormat("dd-MM-yyyy");

			Date startDate = (Date) formatter.parse(fromDate);

			Date endDate = (Date) formatter.parse(toDate);

			long interval = 24 * 1000 * 60 * 60;

			long endTime = endDate.getTime();

			long curTime = startDate.getTime();

			while (curTime <= endTime) {

				dates.add(new Date(curTime));

				curTime += interval;

			}

			/*for (int i = 0; i < dates.size(); i++) {

				Date lDate = (Date) dates.get(i);

				String ds = formatter.format(lDate);

				System.out.println(" Date -" + ds);

			}*/

			list = itemListWithDateRecordRepo.getorderreportByItemIdandDate(Common.convertToYMD(fromDate), Common.convertToYMD(toDate));

			List<ItemRecordByDate> datewiseList = itemRecordByDateRepo.getorderreportByItemIdandDate(Common.convertToYMD(fromDate), Common.convertToYMD(toDate));

			//System.out.println(datewiseList);
			for (int i = 0; i < list.size(); i++) {
				
				List<DateAndQty> newlist = new ArrayList<>();
				
				for (int k = 0; k < dates.size(); k++) {
					 
					int flag=0;
					
					for (int j = 0; j < datewiseList.size(); j++) {
						
						if(dates.get(k).compareTo(datewiseList.get(j).getDeliveryDate())==0 && datewiseList.get(j).getItemId()==list.get(i).getItemId()) {
							
							DateAndQty DateAndQty = new DateAndQty();
							DateAndQty.setDlvDate(datewiseList.get(j).getDeliveryDate());
							DateAndQty.setQty(datewiseList.get(j).getOrderQty());
							//newlist.add(datewiseList.get(j));
							newlist.add(DateAndQty);
							flag=1;
							break;
						}

					}
					
					if(flag==0) {
						
						DateAndQty itemRecordByDate = new DateAndQty(); 
						itemRecordByDate.setDlvDate(dates.get(k));
						itemRecordByDate.setQty(0);
						newlist.add(itemRecordByDate);
					}
				}
				
				list.get(i).setList(newlist);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
