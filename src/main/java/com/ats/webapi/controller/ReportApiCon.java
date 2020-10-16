package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.OrderDispatchRepDao;
import com.ats.webapi.model.SpCakeWtCount;
import com.ats.webapi.model.report.RouteFrBillDateAnalysis;
import com.ats.webapi.model.reportv2.CrNoteRegItem;
import com.ats.webapi.model.reportv2.CrNoteRegSp;
import com.ats.webapi.model.reportv2.CrNoteRegisterList;
import com.ats.webapi.repository.SpCakeWtCountRepo;
import com.ats.webapi.repository.reportv2.CrNoteRegItemRepo;
import com.ats.webapi.repository.reportv2.CrNoteRegSpRepo;
import com.ats.webapi.repository.reportv2.RouteFrBillDateAnalysisRepo;
import com.ats.webapi.repository.taxreport.OrderDispatchRepDaoRepository;

@RestController
public class ReportApiCon {

	@Autowired
	SpCakeWtCountRepo spCakeWtCountRepo;

	@Autowired
	CrNoteRegSpRepo getCrNoteRegSpRepo;

	@Autowired
	CrNoteRegItemRepo getCrNoteRegItemRepo;
	
	@Autowired
	OrderDispatchRepDaoRepository orderDispatchRepDaoRepository;

	@RequestMapping(value = { "/getSpCakeCountBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<SpCakeWtCount> getSpCakeCountBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("menuIdList") List<String> menuIdList) {
		System.out.println(fromDate);
		System.out.println(toDate);
		List<SpCakeWtCount> spCakeList = null;
		try {

			spCakeList = spCakeWtCountRepo.getSpCakeBetDateCount(fromDate, toDate, menuIdList);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return spCakeList;
	}

	@RequestMapping(value = { "/getCrNoteRegisterDoneByFrId" }, method = RequestMethod.POST)
	public @ResponseBody CrNoteRegisterList getCrNoteRegisterDoneByFrId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		CrNoteRegisterList crNoteList = new CrNoteRegisterList();

		List<CrNoteRegItem> crNoteRegItemList;
		List<CrNoteRegSp> crNoteRegSpList = new ArrayList<CrNoteRegSp>();

		crNoteRegItemList = getCrNoteRegItemRepo.getCrNoteRegItemDoneByFrId(frId, fromDate, toDate);
		crNoteList.setCrNoteRegItemList(crNoteRegItemList);

		// crNoteRegSpList = getCrNoteRegSpRepo.getCrNoteRegSpDoneByFrId(frId, fromDate,
		// toDate);
		crNoteList.setCrNoteRegSpList(crNoteRegSpList);

		System.err.println("size Item  crNoteList " + crNoteList.getCrNoteRegItemList().size());
		System.err.println("size Sp  crNoteList " + crNoteList.getCrNoteRegSpList());

		return crNoteList;
	}
	
	@RequestMapping(value = { "/getOrderDispatchReport" }, method = RequestMethod.POST)
	public @ResponseBody List<OrderDispatchRepDao> getOrderDispatchReport(@RequestParam("deliveryDate") String deliveryDate,
			@RequestParam("catId") int catId,@RequestParam("menuId") List<String> menuId){
		List<OrderDispatchRepDao> orderDispReportList = null;
		try {

			orderDispReportList = orderDispatchRepDaoRepository.getOrderDispatchReport(deliveryDate,catId,menuId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderDispReportList;
	}
	
	//Sachin 16-10-2020
	@Autowired RouteFrBillDateAnalysisRepo routeFrBillDateAnalysRepo;
	
	
	@RequestMapping(value = { "/getRouteFrBillDateAnalysReport" }, method = RequestMethod.POST)
	public @ResponseBody Object getRouteFrBillDateAnalysReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<RouteFrBillDateAnalysis> routeBillAnalyList = new ArrayList<>();
		
		try {
			routeBillAnalyList=routeFrBillDateAnalysRepo.getRouteFrBillDateAnalysisReport(fromDate, toDate);
		}catch (Exception e) {
			routeBillAnalyList = new ArrayList<>();
		}
		
		return routeBillAnalyList;
		
	}
	
	
}
