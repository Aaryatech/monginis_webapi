package com.ats.webapi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.report.frpurchase.CrnSalesReportDateWise;
import com.ats.webapi.model.report.frpurchase.SalesReportBillwise;
import com.ats.webapi.model.report.frpurchase.SalesReportBillwiseAllFr;
import com.ats.webapi.model.report.frpurchase.SalesReportItemwise;
import com.ats.webapi.model.report.frpurchase.SalesReportRoyalty;
import com.ats.webapi.model.report.frpurchase.SalesReportRoyaltyFr;
import com.ats.webapi.model.report.frpurchase.SalesRoyaltyConsByCat;
import com.ats.webapi.model.reportv2.SubCatCreditGrnFrItemRep;
import com.ats.webapi.model.reportv2.SubCatFrItemRepBill;
import com.ats.webapi.model.reportv2.SubCatItemReport;
import com.ats.webapi.model.salesreport.SubCatBillRep;
import com.ats.webapi.model.salesreport.SubCatCreditGrnFrRep;
import com.ats.webapi.model.salesreport.SubCatCreditGrnRep;
import com.ats.webapi.model.salesreport.SubCatFrRepBill;
import com.ats.webapi.model.salesreport.SubCatFrReport;
import com.ats.webapi.model.salesreport.SubCatReport;
import com.ats.webapi.model.salesvaluereport.SalesReturnItemDaoList;
import com.ats.webapi.model.salesvaluereport.SalesReturnValueItemDao;
import com.ats.webapi.model.taxreport.Tax1Report;
import com.ats.webapi.repository.SubCatBillRepRepo;
import com.ats.webapi.repository.SubCatCreditGrnFrRepRepo;
import com.ats.webapi.repository.SubCatCreditGrnRepRepo;
import com.ats.webapi.repository.SubCatFrRepBillRepo;
import com.ats.webapi.repository.frpurchasereport.CrnSalesReportDateWiseRepo;
import com.ats.webapi.repository.frpurchasereport.SaleReportBillwiseAllFrRepo;
import com.ats.webapi.repository.frpurchasereport.SaleReportBillwiseRepo;
import com.ats.webapi.repository.frpurchasereport.SaleReportItemwiseRepo;
import com.ats.webapi.repository.frpurchasereport.SalesReportRoyaltyFrRepo;
import com.ats.webapi.repository.frpurchasereport.SalesReportRoyaltyRepo;
import com.ats.webapi.repository.frpurchasereport.SalesRoyaltyConsByCatRepo;
import com.ats.webapi.repository.reportv2.SubCatCreditGrnFrItemRepRepo;
import com.ats.webapi.repository.reportv2.SubCatFrItemRepBillRepo;
import com.ats.webapi.repository.reportv2.SubCatItemReportRepository;
import com.ats.webapi.repository.salesreturnrepo.SalesReturnValueItemDaoRepo;
import com.ats.webapi.repository.taxreport.Tax1ReportRepository;
import com.ats.webapi.repository.taxreport.Tax2ReportRepository;

@RestController
public class SalesReportController {

	@Autowired
	SaleReportBillwiseRepo saleReportBillwiseRepo;

	@Autowired
	SalesReportRoyaltyRepo salesReportRoyaltyRepo;

	@Autowired
	SalesReportRoyaltyFrRepo salesReportRoyaltyFrRepo;

	@Autowired
	SaleReportBillwiseAllFrRepo saleReportBillwiseAllFrRepo;// report 7

	@Autowired
	SaleReportItemwiseRepo saleReportItemwiseRepo; // report 8

	@Autowired
	SalesReturnValueItemDaoRepo salesReturnValueItemDaoRepo;

	// Report 1 sales report bill wise order by date
	@RequestMapping(value = { "/getSaleReportBillwise" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwise(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "" + frIdList);
			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwise(frIdList, fromDate, toDate);
			System.out.println("getSaleReportBillwise" + salesReportBillwiseList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// Report 1 sales report bill wise order by date All Fr
	@RequestMapping(value = { "/getSaleReportBillwiseAllFrSelected" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwiseAllFrSelected(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "");
			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseAllFr(fromDate, toDate);
			System.out.println("getSaleReportBillwise" + salesReportBillwiseList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// report 2 sales report Summary Group By Party ie Fr Name
	@RequestMapping(value = { "/getSaleReportBillwiseByFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwiseByFr(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "" + frIdList);

			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByFr(frIdList, fromDate, toDate);
			System.out.println("getSaleReportBillwiseByFr" + salesReportBillwiseList.toString());
		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise  by Fr " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// report 2 sales report Summary Group By Party ie Fr Name All Fr Selected
	@RequestMapping(value = { "/getSaleReportBillwiseByFrAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwiseByFrAllFrSel(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "");

			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByFrAllFr(fromDate, toDate);
			System.out.println("getSaleReportBillwiseByFr" + salesReportBillwiseList.toString());
		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise  by Fr " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// report 3 sales report datewise group by date
	@RequestMapping(value = { "/getSaleReportBillwiseByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwiseByDate(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "" + frIdList);

			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByDate(frIdList, fromDate, toDate);
			System.out.println("getSaleReportBillwiseByDate" + salesReportBillwiseList.toString());
		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise by Date " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// report 3 sales report datewise group by date all Fr Se
	@RequestMapping(value = { "/getSaleReportBillwiseByDateAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwiseByDate(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "");

			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByDateAllFr(fromDate, toDate);
			System.out.println("getSaleReportBillwiseByDate" + salesReportBillwiseList.toString());
		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise by Date " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// report 4
	@RequestMapping(value = { "/getSaleReportBillwiseByMonth" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwiseByMonth(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "" + frIdList);

			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByMonth(frIdList, fromDate, toDate);
			System.out.println("getSaleReportBillwiseByMonth " + salesReportBillwiseList.toString());
		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise by Month " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// report 4 all Fr selected
	@RequestMapping(value = { "/getSaleReportBillwiseByMonthAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getSaleReportBillwiseByMonthAllFrSel(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "");

			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByMonthAllFr(fromDate, toDate);
			System.out.println("getSaleReportBillwiseByMonth " + salesReportBillwiseList.toString());
		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise by Month " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}

	// Royalty report Started
	// Report 5
	@RequestMapping(value = { "/getSalesReportRoyalty" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportRoyalty> getSalesReportRoyalty(@RequestParam("frIdList") List<String> frIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportRoyalty> salesReportRoyaltyList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "" + frIdList);
			salesReportRoyaltyList = salesReportRoyaltyRepo.getSaleReportRoyalty(frIdList, fromDate, toDate);
			System.out.println("getSaleReportBillwise" + salesReportRoyaltyList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sales Report Royalty  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportRoyaltyList;
	}

	// Report 5 all Fr Selected//Ok tested
	@RequestMapping(value = { "/getSalesReportRoyaltyAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportRoyalty> getSalesReportRoyaltyAllFrSelc(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportRoyalty> salesReportRoyaltyList = null;
		//try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate);
			salesReportRoyaltyList = salesReportRoyaltyRepo.getSaleReportRoyaltyAllFr(fromDate, toDate);
			//System.out.println("getSaleReportBillwise" + salesReportRoyaltyList.toString());

		/*} catch (Exception e) {
			System.out.println(" Exce in sales Report Royalty all fr " + e.getMessage());
			e.printStackTrace();
		}*/
		return salesReportRoyaltyList;
	}

	// report no 6
	@RequestMapping(value = { "/getSalesReportRoyaltyFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportRoyaltyFr> getSalesReportRoyaltyFr(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SalesReportRoyaltyFr> salesReportRoyaltyFrList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "" + frIdList);
			salesReportRoyaltyFrList = salesReportRoyaltyFrRepo.getSaleReportRoyaltyFr(frIdList, fromDate, toDate);
			System.out.println("sale sReportRoyalty Fr List" + salesReportRoyaltyFrList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sales Report Royalty Fr  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportRoyaltyFrList;
	}

	// report no 6 All Fr //Ok tested
	@RequestMapping(value = { "/getSalesReportRoyaltyFrAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportRoyaltyFr> getSalesReportRoyaltyFrAllFr(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		System.err.println("in method getSalesReportRoyaltyFrAllFr salesReportController");
		List<SalesReportRoyaltyFr> salesReportRoyaltyFrList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate);
			salesReportRoyaltyFrList = salesReportRoyaltyFrRepo.getSaleReportRoyaltyFrAllFrSel(fromDate, toDate);
			System.out.println("sale getSalesReportRoyaltyFrAllFr Fr List" + salesReportRoyaltyFrList.toString());

		} catch (Exception e) {
			System.out.println(
					" Exce in sales Report Royalty Fr all fr sel /getSalesReportRoyaltyFrAllFr " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportRoyaltyFrList;
	}

	// report 7 by default All Fr report

	@RequestMapping(value = { "/getSaleReportBillwiseAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwiseAllFr> getSaleReportBillwiseAllFr(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportBillwiseAllFr> salesReportBillwiseAllFr = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate);
			salesReportBillwiseAllFr = saleReportBillwiseAllFrRepo.getSaleReportBillwiseAllFr(fromDate, toDate);
			System.out.println("getSaleReportBillwiseAllFr " + salesReportBillwiseAllFr.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise all fr  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseAllFr;
	}

	@RequestMapping(value = { "/getSaleReportItemwise" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportItemwise> getSaleReportItemwise(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SalesReportItemwise> salesReportItemwise = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate);
			salesReportItemwise = saleReportItemwiseRepo.getSaleReportItemwise(fromDate, toDate);
			System.out.println("salesReportItemwise " + salesReportItemwise.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwisesales Report Itemwise " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportItemwise;
	}
	
	
	@Autowired
	SalesRoyaltyConsByCatRepo salesRoyaltyConsByCatRepo;
	
	// Anmol------14-5-2020
		@RequestMapping(value = { "/getSaleRoyConsoByCatReportData" }, method = RequestMethod.POST)
		public @ResponseBody List<SalesRoyaltyConsByCat> getSaleRoyConsoByCatReportData(
				@RequestParam("frIdList") List<String> frIdList, @RequestParam("catIdList") List<String> catIdList,
				@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

			List<SalesRoyaltyConsByCat> salesReportRoyaltyList = null;
			try {
				fromDate = Common.convertToYMD(fromDate);
				toDate = Common.convertToYMD(toDate);

				System.out.println("Input received for report 10 roy by category few fr Selected " + fromDate + "" + toDate
						+ "" + frIdList + "cat=" + catIdList);

				if (catIdList.contains("5")) {
					salesReportRoyaltyList = salesRoyaltyConsByCatRepo.getSaleRoyConsoByCatUnion(catIdList, frIdList,
							fromDate, toDate);
					System.out.println("getSaleReportRoyConsoByCatForSp" + salesReportRoyaltyList.toString());
				} else {
					salesReportRoyaltyList = salesRoyaltyConsByCatRepo.getSaleRoyConsoByCat(catIdList, frIdList, fromDate,
							toDate);
					System.out.println("getSaleReportBillwise" + salesReportRoyaltyList.toString());

				}
			} catch (Exception e) {
				System.out.println(" Exce in sales Report Royalty  By Category " + e.getMessage());
				e.printStackTrace();
			}
			return salesReportRoyaltyList;
		}

		
		

	// report 10 AS OF REPORT 5
	@RequestMapping(value = { "/getSaleReportRoyConsoByCat" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportRoyalty> getSaleReportRoyConsoByCat(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("catIdList") List<String> catIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportRoyalty> salesReportRoyaltyList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			System.out.println("Input received for report 10 roy by category few fr Selected " + fromDate + "" + toDate
					+ "" + frIdList + "cat=" + catIdList);

			if (catIdList.contains("0")) {

				System.err.println("Cat ID List contains zero ");
				catIdList.clear();

				// String s="1"+","+"2"+","+"3"+","+ "4";
				for (int i = 1; i <= 4; i++) {
					String s = new String();

					s = i + ",";

					catIdList.add(s);

				}

				System.err.println("New cat ID List" + catIdList);
			}
			salesReportRoyaltyList = salesReportRoyaltyRepo.getSaleReportRoyConsoByCat(frIdList, catIdList, fromDate,
					toDate);
			System.out.println("getSaleReportBillwise" + salesReportRoyaltyList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sales Report Royalty  By Category " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportRoyaltyList;
	}

	// report no 10 all fr and multiple category

	@RequestMapping(value = { "/getSaleReportRoyConsoByCatAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportRoyalty> getSaleReportRoyConsoByCatAllFr(
			@RequestParam("catIdList") List<String> catIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SalesReportRoyalty> salesReportRoyaltyList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received for report 10 roy by category all fr Selected " + fromDate + "" + toDate
					+ "" + "cat=" + catIdList);

			if (catIdList.contains("0")) {

				System.err.println("Cat ID List contains zero ");
				catIdList.clear();

				// String s="1"+","+"2"+","+"3"+","+ "4";
				for (int i = 1; i <= 4; i++) {
					String s = new String();

					s = i + ",";

					catIdList.add(s);

				}

				System.err.println("New cat ID List" + catIdList);

			}

			salesReportRoyaltyList = salesReportRoyaltyRepo.getSaleReportRoyConsoByCatAllFr(catIdList, fromDate,
					toDate);
			System.out.println("getSaleReportBillwise" + salesReportRoyaltyList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sales Report Royalty  By Category " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportRoyaltyList;
	}

	// report 10 AS OF REPORT 5 for Graph
	@RequestMapping(value = { "/getSaleReportRoyConsoByCatForGraph" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportRoyalty> getSaleReportRoyConsoByCatForGraph(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("catIdList") List<String> catIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportRoyalty> salesReportRoyaltyList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received for report 10 roy by category " + fromDate + "" + toDate + "" + frIdList
					+ "cat=" + catIdList);
			salesReportRoyaltyList = salesReportRoyaltyRepo.getSaleReportRoyConsoByCatForGraph(frIdList, catIdList,
					fromDate, toDate);
			System.out.println("getSaleReportBillwise for Graph r 10 " + salesReportRoyaltyList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sales Report Royalty  By Category For Graph  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportRoyaltyList;
	}

	@Autowired
	Tax1ReportRepository tax1ReportRepository;

	@Autowired
	Tax2ReportRepository tax2ReportRepository;

	@RequestMapping(value = { "/getTax1ReportByFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<Tax1Report> getTax1ReportByFrId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<Tax1Report> tax1ReportList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			tax1ReportList = tax1ReportRepository.getTax1ReportByFrId(frId, fromDate, toDate);
		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return tax1ReportList;
	}

	@Autowired
	SubCatCreditGrnFrItemRepRepo subCatCreditGrnFrItemRepRepo;

	@Autowired
	SubCatFrItemRepBillRepo subCatFrItemRepBillRepo;

	@Autowired
	SubCatItemReportRepository subCatItemReportRepository;
	
	@RequestMapping(value = { "/getSubCatFrItemReportApi" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatItemReport> getSubCatFrItemReportApi(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<Integer> frIdList,
			@RequestParam("subCatIdList") List<Integer> subCatIdList) {

		List<SubCatItemReport> catReportList = new ArrayList<SubCatItemReport>();
		///List<SubCatFrItemRepBill> catReportBill = null;

		///List<SubCatCreditGrnFrItemRep> subCatCreditGrnRep = null;
		///List<SubCatCreditGrnFrItemRep> subCatCreditGvnRep = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			catReportList = subCatItemReportRepository.getData(fromDate, toDate, frIdList, subCatIdList);
            System.err.println("catReportList"+catReportList.size());
		/*	catReportBill = subCatFrItemRepBillRepo.getData(fromDate, toDate, frIdList, subCatIdList);

			subCatCreditGrnRep = subCatCreditGrnFrItemRepRepo.getDataGRN(fromDate, toDate, frIdList, subCatIdList);

			subCatCreditGvnRep = subCatCreditGrnFrItemRepRepo.getDataGVN(fromDate, toDate, frIdList, subCatIdList);

			System.out.println(catReportBill.toString());
			System.out.println(subCatCreditGrnRep.toString());
			System.out.println(subCatCreditGvnRep.toString());

			for (int i = 0; i < catReportBill.size(); i++) {

				SubCatItemReport subCatReport = new SubCatItemReport();

				subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
				subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());
				subCatReport.setFrId(catReportBill.get(i).getFrId());
				subCatReport.setFrName(catReportBill.get(i).getFrName());
				subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
				subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());
				subCatReport.setItemId(catReportBill.get(i).getItemId());
				subCatReport.setItemName(catReportBill.get(i).getItemName());

				catReportList.add(subCatReport);

			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGrnRep.size(); j++) {

					if (catReportList.get(i).getItemId() == subCatCreditGrnRep.get(j).getItemId()
							&& catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()
							&& catReportList.get(i).getFrId() == subCatCreditGrnRep.get(j).getFrId()) {

						catReportList.get(i).setRetAmt(subCatCreditGrnRep.get(j).getVarAmt());
						catReportList.get(i).setRetQty(subCatCreditGrnRep.get(j).getVarQty());
						break;

					} 

				}
			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGvnRep.size(); j++) {

					if (catReportList.get(i).getItemId() == subCatCreditGrnRep.get(j).getItemId()
							&& catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()
							&& catReportList.get(i).getFrId() == subCatCreditGrnRep.get(j).getFrId()) {

						catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
						catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty());
						break;

					} 

				}
			}*/

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}

	@RequestMapping(value = { "/getSalesReturnValueItemReport" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReturnItemDaoList> getSalesReturnValueItemReport(
			@RequestParam("fromYear") int fromYear, @RequestParam("toYear") int toYear,
			@RequestParam("subCatId") List<Integer> subCatId) throws ParseException {

		List<SalesReturnItemDaoList> repList = new ArrayList<>();
		List<String> months = new ArrayList<String>();
		months.add(fromYear + "-04");
		months.add(fromYear + "-05");
		months.add(fromYear + "-06");
		months.add(fromYear + "-07");
		months.add(fromYear + "-08");
		months.add(fromYear + "-09");
		months.add(fromYear + "-10");
		months.add(fromYear + "-11");
		months.add(fromYear + "-12");
		months.add(toYear + "-01");
		months.add(toYear + "-02");
		months.add(toYear + "-03");

		for (int i = 0; i < months.size(); i++) {
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM");
			// output format: yyyy-MM-dd
			SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
			String month = formatter.format(parser.parse(months.get(i)));
			SalesReturnItemDaoList salesReturnItemDaoList = new SalesReturnItemDaoList();
			salesReturnItemDaoList.setMonth(month);
			List<SalesReturnValueItemDao> salesReturnValueDao = null;
			if (subCatId.contains(21)) {// 4 is sp sub cAt
				salesReturnValueDao = salesReturnValueItemDaoRepo.getSalesReturnValueSpReport1(months.get(i));
			} else {
				salesReturnValueDao = salesReturnValueItemDaoRepo.getSalesReturnValueItemReport1(months.get(i),
						subCatId);
			}

			salesReturnItemDaoList.setSalesReturnValueItemDao(salesReturnValueDao);
			repList.add(salesReturnItemDaoList);
			System.out.println(months.toString());
		}

		System.out.println("repListrepListrepListrepListrepListrepList" + repList.toString());
		return repList;

	}
	
	@Autowired
	SubCatBillRepRepo subCatBillRepRepo;

	@Autowired
	SubCatCreditGrnRepRepo subCatCreditGrnRepRepo;
	
	@RequestMapping(value = { "/getSubCatReportApi" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatReport> getSubCatReportApi(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SubCatReport> catReportList = new ArrayList<>();
		List<SubCatBillRep> catReportBill = null;

		List<SubCatCreditGrnRep> subCatCreditGrnRep = new ArrayList<>();
		List<SubCatCreditGrnRep> subCatCreditGvnRep = new ArrayList<>();
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			// catReportList = subCatReportRepo.getData(fromDate, toDate);

			catReportBill = subCatBillRepRepo.getData(fromDate, toDate);

			
			subCatCreditGrnRep = subCatCreditGrnRepRepo.getDataGRN(fromDate, toDate);
			
			System.err.println("Matched -------------------- " + subCatCreditGrnRep);

			subCatCreditGvnRep = subCatCreditGrnRepRepo.getDataGVN(fromDate, toDate);
			System.err.println("Matched -------------------- " + subCatCreditGvnRep);

			for (int i = 0; i < catReportBill.size(); i++) {

				SubCatReport subCatReport = new SubCatReport();

				subCatReport.setCatId(catReportBill.get(i).getCatId());
				subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
				subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());

				subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
				subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());

				catReportList.add(subCatReport);

			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGrnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()) {

						System.err.println("Matched -------------------- " + subCatCreditGrnRep.get(j).getSubCatId());

						catReportList.get(i).setRetQty(subCatCreditGrnRep.get(j).getVarQty());
						catReportList.get(i).setRetAmt(subCatCreditGrnRep.get(j).getVarAmt());
						
						System.err.println("GRN " + subCatCreditGrnRep.get(j).getVarQty());
						System.err.println("GRN AMT  " + subCatCreditGrnRep.get(j).getVarAmt());

						break;

					} else {

						catReportList.get(i).setRetAmt(0);
						catReportList.get(i).setRetQty(0);
					}

				}
			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGvnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGvnRep.get(j).getSubCatId()) {

						catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
						catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty());
						System.err.println("GVN " + subCatCreditGvnRep.get(j).getVarQty());
						System.err.println("GVN AMT  " + subCatCreditGvnRep.get(j).getVarAmt());
						
						break;

					} else {

						catReportList.get(i).setVarAmt(0);
						catReportList.get(i).setVarQty(0);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}

	/*
	 * @Autowired SubCatFrRepBillRepo subCatFrRepBillRepo;
	 * 
	 * @Autowired SubCatCreditGrnFrRepRepo subCatCreditGrnFrRepRepo;
	 */

	/*
	 * @RequestMapping(value = { "/getSubCatFrReportApi" }, method =
	 * RequestMethod.POST) public @ResponseBody List<SubCatFrReport>
	 * getSubCatFrReportApi(@RequestParam("fromDate") String fromDate,
	 * 
	 * @RequestParam("toDate") String toDate, @RequestParam("frIdList")
	 * List<Integer> frIdList,
	 * 
	 * @RequestParam("subCatIdList") List<Integer> subCatIdList) {
	 * 
	 * List<SubCatFrReport> catReportList = new ArrayList<>(); List<SubCatFrRepBill>
	 * catReportBill = null;
	 * 
	 * List<SubCatCreditGrnFrRep> subCatCreditGrnRep = null;
	 * List<SubCatCreditGrnFrRep> subCatCreditGvnRep = null; try { fromDate =
	 * Common.convertToYMD(fromDate); toDate = Common.convertToYMD(toDate);
	 * 
	 * // catReportList = subCatReportRepo.getData(fromDate, toDate);
	 * 
	 * catReportBill = subCatFrRepBillRepo.getData(fromDate, toDate, frIdList,
	 * subCatIdList);
	 * 
	 * subCatCreditGrnRep = subCatCreditGrnFrRepRepo.getDataGRN(fromDate, toDate,
	 * frIdList, subCatIdList);
	 * 
	 * subCatCreditGvnRep = subCatCreditGrnFrRepRepo.getDataGVN(fromDate, toDate,
	 * frIdList, subCatIdList);
	 * 
	 * System.out.println(catReportBill.toString());
	 * System.out.println(subCatCreditGrnRep.toString());
	 * System.out.println(subCatCreditGvnRep.toString());
	 * 
	 * for (int i = 0; i < catReportBill.size(); i++) {
	 * 
	 * SubCatFrReport subCatReport = new SubCatFrReport();
	 * 
	 * subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
	 * subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());
	 * subCatReport.setFrId(catReportBill.get(i).getFrId());
	 * subCatReport.setFrName(catReportBill.get(i).getFrName());
	 * subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
	 * subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());
	 * subCatReport.setBillDetailNo(catReportBill.get(i).getBillDetailNo());
	 * 
	 * catReportList.add(subCatReport);
	 * 
	 * }
	 * 
	 * for (int i = 0; i < catReportList.size(); i++) { for (int j = 0; j <
	 * subCatCreditGrnRep.size(); j++) {
	 * 
	 * if (catReportList.get(i).getFrId() == subCatCreditGrnRep.get(j).getFrId() &&
	 * catReportList.get(i).getSubCatId() ==
	 * subCatCreditGrnRep.get(j).getSubCatId()) {
	 * 
	 * catReportList.get(i).setRetAmt(subCatCreditGrnRep.get(j).getVarAmt());
	 * catReportList.get(i).setRetQty(subCatCreditGrnRep.get(j).getVarQty()); break;
	 * 
	 * } else {
	 * 
	 * catReportList.get(i).setRetAmt(0); catReportList.get(i).setRetQty(0); }
	 * 
	 * } }
	 * 
	 * for (int i = 0; i < catReportList.size(); i++) { for (int j = 0; j <
	 * subCatCreditGvnRep.size(); j++) {
	 * 
	 * if (catReportList.get(i).getFrId() == subCatCreditGrnRep.get(j).getFrId() &&
	 * catReportList.get(i).getSubCatId() ==
	 * subCatCreditGrnRep.get(j).getSubCatId()) {
	 * 
	 * catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
	 * catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty()); break;
	 * 
	 * } else {
	 * 
	 * catReportList.get(i).setVarAmt(0); catReportList.get(i).setVarQty(0); }
	 * 
	 * } }
	 * 
	 * } catch (Exception e) { System.out.println(" Exce in Tax1 Report " +
	 * e.getMessage()); e.printStackTrace(); } return catReportList; }
	 */
	
	@RequestMapping(value = { "/getTcsReportSelectedFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getTcsReportSelectedFr(
			@RequestParam("frIdList") List<String> frIdList,@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "");
			salesReportBillwiseList = saleReportBillwiseRepo.getTcsReport(frIdList, fromDate, toDate);
			System.out.println("getSaleReportBillwise" + salesReportBillwiseList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}
	
	@RequestMapping(value = { "/getTcsReportByAllFr" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportBillwise> getTcsReportByAllFr(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReportBillwise> salesReportBillwiseList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			System.out.println("Input received " + fromDate + "" + toDate + "");
			salesReportBillwiseList = saleReportBillwiseRepo.getTcsReportByAllFr(fromDate, toDate);
			System.out.println("getSaleReportBillwise" + salesReportBillwiseList.toString());

		} catch (Exception e) {
			System.out.println(" Exce in sale Report Billwise  " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportBillwiseList;
	}
	
	
	@Autowired CrnSalesReportDateWiseRepo crnSalesRepo;
	@RequestMapping(value = { "/getCrnSaleReportDateWise" }, method = RequestMethod.POST)
	public @ResponseBody List<CrnSalesReportDateWise> getCrnSaleReportDateWise(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<CrnSalesReportDateWise> crnList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			
			if(frIdList.contains("-1")) {	
				crnList = new ArrayList<CrnSalesReportDateWise>();
				crnList = crnSalesRepo.getCrnSalesDateReportAllFr(fromDate, toDate);
			}else {
				crnList = new ArrayList<CrnSalesReportDateWise>();
				crnList = crnSalesRepo.getCrnSalesDateReport(frIdList, fromDate, toDate);
			}
			
		} catch (Exception e) {
			System.out.println(" Exce in /getCrnSaleReportDateWise " + e.getMessage());
			e.printStackTrace();
		}
		return crnList;
	}
	
	
	@RequestMapping(value = { "/getCrnSaleReportMonthWise" }, method = RequestMethod.POST)
	public @ResponseBody List<CrnSalesReportDateWise> getCrnSaleReportMonthWise(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<CrnSalesReportDateWise> crnList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			
			if(frIdList.contains("-1")) {	
				crnList = new ArrayList<CrnSalesReportDateWise>();
				crnList = crnSalesRepo.getCrnSalesMonthReportAllFr(fromDate, toDate);
			}else {
				crnList = new ArrayList<CrnSalesReportDateWise>();
				crnList = crnSalesRepo.getCrnSalesMonthReport(frIdList, fromDate, toDate);
			}
			
		} catch (Exception e) {
			System.out.println(" Exce in /getCrnSaleReportDateWise " + e.getMessage());
			e.printStackTrace();
		}
		return crnList;
	}
	
	
	@RequestMapping(value = { "/getConsolidatedCrnReport" }, method = RequestMethod.POST)
	public @ResponseBody List<CrnSalesReportDateWise> getConsolidatedCrnReport(
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<CrnSalesReportDateWise> crnList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			
			if(frIdList.contains("-1")) {	
				crnList = new ArrayList<CrnSalesReportDateWise>();
				crnList = crnSalesRepo.getCnsoldatdCrnSalesReportAllFr(fromDate, toDate);
			}else {
				crnList = new ArrayList<CrnSalesReportDateWise>();
				crnList = crnSalesRepo.getCnsoldatdCrnSalesReport(frIdList, fromDate, toDate);
			}
			
		} catch (Exception e) {
			System.out.println(" Exce in /getConsolidatedCrnReport " + e.getMessage());
			e.printStackTrace();
		}
		return crnList;
	}
}
