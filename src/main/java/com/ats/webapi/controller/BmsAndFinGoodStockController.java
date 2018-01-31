package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.model.FrItemStockConfigure;
import com.ats.webapi.model.FrItemStockConfigureList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.FinishedGoodStock;
import com.ats.webapi.model.stock.FinishedGoodStockDetail;
import com.ats.webapi.model.stock.GetBmsCurrentStock;
import com.ats.webapi.model.stock.GetBmsCurrentStockList;
import com.ats.webapi.model.stock.GetCurProdAndBillQty;
import com.ats.webapi.model.stock.GetCurProdAndBillQtyList;
import com.ats.webapi.repository.bmsstock.FinishedGoodStockDetailRepo;
import com.ats.webapi.repository.bmsstock.FinishedGoodStockRepo;
import com.ats.webapi.repository.bmsstock.GetCurProdAndBillQtyRepo;
import com.ats.webapi.repository.bmsstock.GetCurrentBmsStockRepo;
import com.ats.webapi.service.FrItemStockConfigureService;

@RestController
public class BmsAndFinGoodStockController {

	@Autowired
	GetCurrentBmsStockRepo currentBmsStockRepo;

	@Autowired
	FrItemStockConfigureService frItemStockConfigureService;

	@Autowired
	FinishedGoodStockRepo finishedGoodStockRepo;

	@Autowired
	FinishedGoodStockDetailRepo finishedGoodStockDetailRepo;

	@Autowired
	GetCurProdAndBillQtyRepo getCurProdAndBillQtyRepo;
	
	
	/*
	 //Get BMS Stock Bet Date
	 
	 SELECT d.bms_stock_deatil_id,d.bms_stock_id,d.bms_stock_date, d.rm_name,d.rm_id,d.rm_uom,d.rm_type, SUM(f.bms_opening_stock) AS OPQTY,SUM(t.closing_qty) AS CLOQTY,
SUM(t.store_rec_qty) as storeRecQty,
SUM(t.store_rejected_qty) as storeRejectedQty,
SUM(t.mixing_rec_qty) as mixingRecQty,
SUM(t.mixing_receive_rejected_qty) as mixingReceiveRejectedQty,
SUM(t.mixing_issue_qty) as mixingIssueQty,
SUM(t.mixing_return_qty) as mixingReturnQty,
SUM(t.mixing_rejected) as mixingRejected,
SUM(t.prod_issue_qty) as prodIssueQty,
SUM(t.prod_rejected_qty) as prodRejectedQty,
SUM(t.prod_return_qty) as prodReturnQty
 FROM 
t_bms_stock_details d,t_bms_stock_details f,t_bms_stock_details t ,t_bms_stock h1,t_bms_stock h2,t_bms_stock h3
WHERE h1.bms_stock_id=d.bms_stock_id AND h2.bms_stock_id=f.bms_stock_id AND h3.bms_stock_id=t.bms_stock_id
AND h1.bms_stock_date BETWEEN '2018-01-01' AND '2018-01-26' AND h2.bms_stock_date='2018-01-01' AND h3.bms_stock_date='2018-01-26' AND 
h1.bms_status=1
	 
	 */

	@RequestMapping(value = { "/getCuurentBmsStock" }, method = RequestMethod.POST)
	public @ResponseBody GetBmsCurrentStockList getCurrentBmsStockList(@RequestParam("prodDeptId") int prodDeptId,
			@RequestParam("mixDeptId") int mixDeptId, @RequestParam("storeDeptId") int storeDeptId,
			@RequestParam("rmType") int rmType) {
		
		System.out.println("Inside Get bms current stock get web Service");
		System.out.println(" RM type Received " + rmType);

		Info info = new Info();


		java.sql.Date cDate = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
		
		
		System.out.println("Input received for BMS Current Stock ");
		System.out.println("Current Date"+cDate + "prod Dept Id"+prodDeptId+"mixDept Id"+mixDeptId+ "storeDept Id "+storeDeptId);
		

		GetBmsCurrentStockList bmsStockList = new GetBmsCurrentStockList();

		try {

			List<GetBmsCurrentStock> bmsCurrentStock = currentBmsStockRepo.getBmsCurStock(cDate, prodDeptId, mixDeptId,
					storeDeptId, rmType);

			if (!bmsCurrentStock.isEmpty()) {

				info.setError(false);
				info.setMessage("success getting bms current stock list ");

				bmsStockList.setBmsCurrentStock(bmsCurrentStock);
			} else {

				info.setError(true);
				info.setMessage("Error getting bms current  stock list ");

			}

			bmsStockList.setInfo(info);
			System.out.println("Stock List BMS Current Stock  " + bmsStockList.toString());

			/*for(int p=0;p<bmsCurrentStock.size();p++) {
				System.out.println("BMS Stock Element No "+p);
				System.out.println("Element "+bmsCurrentStock.get(p));
			}*/

		} catch (Exception e) {

			System.out.println("Exc in Getting Current BMS stock List " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return bmsStockList;
	}

	@RequestMapping(value = { "/getDeptSettingValue" }, method = RequestMethod.POST)
	public @ResponseBody FrItemStockConfigureList getSeetingValueOfDept(
			@RequestParam("settingKeyList") List<String> settingKeyList) {

		System.out.println("input para " + settingKeyList.toString());
		FrItemStockConfigureList settingList = frItemStockConfigureService.findBySettingKeyList(settingKeyList);

		return settingList;
	}

	@RequestMapping(value = { "/insertFinishedGoodOpStock" }, method = RequestMethod.POST)
	public @ResponseBody Info insertBmsStock(@RequestBody FinishedGoodStock finishedGoodStockHeader) {

		Info info = new Info();

		try {

			FinishedGoodStock finGood = finishedGoodStockRepo.save(finishedGoodStockHeader);

			List<FinishedGoodStockDetail> finishedGoodStockDetail = finishedGoodStockHeader
					.getFinishedGoodStockDetail();

			int stockId = finGood.getFinStockId();

			for (int i = 0; i < finishedGoodStockDetail.size(); i++) {

				FinishedGoodStockDetail stockDetail = finishedGoodStockDetail.get(i);
				stockDetail.setFinStockId(stockId);

				FinishedGoodStockDetail stockDetailResponse = finishedGoodStockDetailRepo.save(stockDetail);

			}
			if (finGood != null) {
				info.setError(false);
				info.setMessage("Success: Inserted Fin Good Op Stock");

			}

		} catch (Exception e) {

			System.out.println("Exce in Finished good OP Stock  Insert " + e.getMessage());
			e.printStackTrace();

			info.setError(true);
			info.setMessage("Error: Inserting Fin Good Op Stock");

		}

		return info;

	}

	@RequestMapping(value = { "/getCurrentProdAndBillQty" }, method = RequestMethod.POST)
	public @ResponseBody GetCurProdAndBillQtyList getCurrentProdAndBillQty(@RequestParam("prodDate") String prodDate,
			@RequestParam("catId") int catId, @RequestParam("delStatus") int delStatus, @RequestParam("timestamp") String timestamp,
			@RequestParam("curTimeStamp") String curTimeStamp) {

		Info info = new Info();
		
		System.out.println("Date Received "+prodDate);
		
		GetCurProdAndBillQtyList curProdAndBillList = new GetCurProdAndBillQtyList();

		try {

			List<GetCurProdAndBillQty> getCurProdAndBillQty = getCurProdAndBillQtyRepo.getCurProdAndBillQty(prodDate,
					catId, delStatus,timestamp,curTimeStamp);
			if (!getCurProdAndBillQty.isEmpty()) {

				info.setError(false);
				info.setMessage("success stock list ");

				curProdAndBillList.setGetCurProdAndBillQty(getCurProdAndBillQty);
			} else {

				info.setError(true);
				info.setMessage("Error in Getting cur Prod And Bill Qty list- size = " + getCurProdAndBillQty.size());

			}

			curProdAndBillList.setInfo(info);

		} catch (Exception e) {

			System.out.println("Exc in Getting cur Prod And Bill Qty list " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Stock List BMS curProdAndBillList " + curProdAndBillList.toString());
		return curProdAndBillList;
	}

	
	//All Category
	@RequestMapping(value = { "/getCurrentProdAndBillQtyAllCat" }, method = RequestMethod.POST)
	public @ResponseBody GetCurProdAndBillQtyList getCurrentProdAndBillQtyAllCat(@RequestParam("prodDate") String prodDate,
			 @RequestParam("delStatus") int delStatus,@RequestParam("timestamp") String timestamp,
			 @RequestParam("curTimeStamp") String curTimeStamp) {

		Info info = new Info();
		
		System.out.println("Date Received "+prodDate);
		
		GetCurProdAndBillQtyList curProdAndBillList = new GetCurProdAndBillQtyList();

		try {

			List<GetCurProdAndBillQty> getCurProdAndBillQty = getCurProdAndBillQtyRepo.getCurProdAndBillQtyAllCat(prodDate,
					 delStatus,timestamp,curTimeStamp);
			if (!getCurProdAndBillQty.isEmpty()) {

				info.setError(false);
				info.setMessage("success stock list ");

				curProdAndBillList.setGetCurProdAndBillQty(getCurProdAndBillQty);
			} else {

				info.setError(true);
				info.setMessage("Error in Getting cur Prod And Bill Qty lis All Cat - size = " + getCurProdAndBillQty.size());

			}

			curProdAndBillList.setInfo(info);

		} catch (Exception e) {

			System.out.println("Exc in Getting cur Prod And Bill Qty list  All Cate" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Stock List BMS curProdAndBillList" + curProdAndBillList.toString());
		return curProdAndBillList;
	}
	@RequestMapping(value = { "/getFinGoodStockHeader" }, method = RequestMethod.POST)
	public @ResponseBody FinishedGoodStock getFinGoodStockHeader(@RequestParam("stockStatus") int stockStatus) {

		FinishedGoodStock finishHeader =new FinishedGoodStock();

		try {

			finishHeader = finishedGoodStockRepo.findByFinGoodStockStatus(stockStatus);

		} catch (Exception e) {

			System.out.println("Exce in getting Finished Good Stock Header " + e.getMessage());
			e.printStackTrace();

		}
		if(finishHeader!=null)
	System.out.println("output finished Good Header = "+finishHeader.toString());
		return finishHeader;

	}
	
	
	@RequestMapping(value = { "/getFinGoodStockHeaderByDate" }, method = RequestMethod.POST)
	public @ResponseBody FinishedGoodStock getFinGoodStockHeaderbyDate(@RequestParam("stockDate") String StockDate) {

		FinishedGoodStock finishHeader = null;

		try {
				Date stkDate=Common.convertToSqlDate(StockDate);
			finishHeader = finishedGoodStockRepo.findByFinGoodStockDate(stkDate);
		} catch (Exception e) {

			System.out.println("Exce in getting Finished Good Stock Header " + e.getMessage());
			e.printStackTrace();

		}
		
		System.out.println("output finished Good Header = "+finishHeader.toString());
		return finishHeader;

	}
	
	
	
	@RequestMapping(value = { "/getFinGoodStockDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockDetail(@RequestParam("stockDate") String stockDate,@RequestParam("catId")int catId) {

		List<FinishedGoodStockDetail> finishedGoodStockDetail=new ArrayList<FinishedGoodStockDetail>();
		try {
						System.out.println("date received for Stock Detail "+stockDate);
						
						System.out.println("cat Id  received for Stock Detail "+catId);
						
			
			Date stkDate= Common.convertToSqlDate(stockDate);
			
			System.out.println("date After convert for Stock Detail "+stkDate);

			finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDateAndCatId(stkDate,catId);
		} catch (Exception e) {
			
			System.out.println("Exce in getting Finished Good Stock Detail By Date " + e.getMessage());
			e.printStackTrace();

		}
		
	System.out.println("output finished Good Detail  = "+finishedGoodStockDetail.toString());
		return finishedGoodStockDetail;

	}
	
	//getFinGoodStockDetail all Category
	@RequestMapping(value = { "/getFinGoodStockDetailAllCat" }, method = RequestMethod.POST)
	public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockDetailAllCat(@RequestParam("stockDate") String stockDate) {

		List<FinishedGoodStockDetail> finishedGoodStockDetail=new ArrayList<>();
		try {
						System.out.println("date received for Stock Detail "+stockDate);
			
			Date stkDate= Common.convertToSqlDate(stockDate);
			
			System.out.println("date After convert for Stock Detail "+stkDate);

			finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDate(stkDate);
		} catch (Exception e) {
			
			System.out.println("Exce in getting Finished Good Stock Detail By Date " + e.getMessage());
			e.printStackTrace();

		}
		
	System.out.println("output finished Good Detail  = "+finishedGoodStockDetail.toString());
		return finishedGoodStockDetail;

	}

	
	//get Finished Good Stock Bet Date

	@RequestMapping(value = { "/getFinGoodStockBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockBetDate(@RequestParam("stockFromDate") String stockFromDate,
			@RequestParam("stockToDate") String stockToDate,@RequestParam("stockStatus")int stockStatus) {

		List<FinishedGoodStockDetail> finishedGoodStockDetail=null;
		try {
			
			System.out.println("date received for Stock Detail bet date = "+stockFromDate);
			
			Date stkFrDate= Common.convertToSqlDate(stockFromDate);
			
			stockToDate=Common.convertToDMY(stockToDate);
			Date stkToDate= Common.convertToSqlDate(stockToDate);
			
			System.out.println("date After convert for Stock Detail bet date  "+stkFrDate);
			

			finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDateBetween(stkFrDate, stkToDate, stockStatus);
		} catch (Exception e) {
			
			System.out.println("Exce in getting Finished Good Stock Detail Between two Date " + e.getMessage());
			e.printStackTrace();

		}
		
	System.out.println("output finished Good Detail bet two dates  = "+finishedGoodStockDetail.toString());
		return finishedGoodStockDetail;

	}

}
