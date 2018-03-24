package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.RegularSpecialStockCal;
import com.ats.webapi.repository.PostBillHeaderRepository;
import com.ats.webapi.repository.PostFrOpStockDetailRepository;
import com.ats.webapi.repository.PostFrOpStockHeaderRepository;
import com.ats.webapi.repository.StockCalculationRepository;

@Service
public class GetItemStockServiceImpl implements GetItemStockService{
	
	
	@Autowired
	PostBillHeaderRepository billHeaderRepository;
	
	@Autowired
	PostFrOpStockDetailRepository stockDetailRepository;
	
	@Autowired
	StockCalculationRepository calculationRepository;
	
	
	@Override
	public RegularSpecialStockCal getRegTotalPurchase(int frId, String fromDate, String toDate, int itemId) {
		
		RegularSpecialStockCal purchase=calculationRepository.getTotalPurchase(frId,fromDate,toDate,itemId);
		System.out.println("Total Purchase "+purchase);
		
		return purchase;
	}

	@Override
	public int getRegTotalGrnGvn(int frId, String fromDate, String toDate, int itemId) {
		
		int grnGvn=calculationRepository.getRegTotalGrnGvn(frId,fromDate,toDate,itemId);
		System.out.println("Total Grn "+grnGvn);
		
		return grnGvn;
	}

	@Override
	public RegularSpecialStockCal getRegTotalSell(int frId, String fromDate, String toDate, int itemId) {
		
		RegularSpecialStockCal totalSell=calculationRepository.getRegTotalSell(frId,fromDate,toDate,itemId);
		System.out.println("Total Sell "+totalSell);
		
		return totalSell; 
	}

	@Override
	public PostFrItemStockDetail getOpeningStock(int frId, int currentMonth, int year, int itemId , int catId) {
	
		PostFrItemStockDetail stockDetail=new PostFrItemStockDetail();
		try {
			stockDetail = stockDetailRepository.getOpeningStock(frId, currentMonth,  year,itemId , catId);
		}catch (Exception e) {
			
			System.out.println("Get Opening Stock ServiceImpl Exception "+e.getMessage());
		e.printStackTrace();
			
		}
		 return stockDetail;
	}

//	@Override
//	public RegularSpecialStockCal getTotalSellBetweenTimeSlot(int frId, String fromDate, String fromTime, String toDate,
//			String toTime, int itemId) {
//		
//		
//		
//		RegularSpecialStockCal totalSell=calculationRepository.getTotalSellBetweenSlot(frId,fromDate,fromTime,toDate,toTime,itemId);
//		System.out.println("Total Sell "+totalSell);
//		
//		
//		return totalSell;
//	}

	
	
	// auto grn /gvn
	
	@Override
	public int getTotalGrnGvnUptoDateTime(int frId, String fromDateTime, String toDateTime, int itemId) {

		int grnGvn =calculationRepository.getTotalGrnGvnUptoDateTime(frId, fromDateTime, toDateTime, itemId);
		
		return grnGvn;
	}

	@Override
	public RegularSpecialStockCal getTotalPurchaseUptoDateTime(int frId, String fromDateTime, String toDateTime,
			int itemId) {
		
		
		RegularSpecialStockCal totalPurchase=calculationRepository.getTotalPurchaseUptoDateTime(frId, fromDateTime, toDateTime, itemId);
		
		return totalPurchase;
	}

	@Override
	public RegularSpecialStockCal getTotalSellUpToDateTime(int frId, String fromDateTime, String toDateTime,
			int itemId) {
		

		RegularSpecialStockCal totalSell=calculationRepository.getTotalSellUpToDateTime(frId, fromDateTime, toDateTime, itemId);
		
		return totalSell;
	}

	@Override
	public RegularSpecialStockCal getTotalPurchaseOfDate(int frId, String fromDate, int itemId) {
		
		
		RegularSpecialStockCal totalPurchaseOfDate=calculationRepository.getTotalPurchaseOfDate(frId, fromDate, itemId);
				
		
		return totalPurchaseOfDate;
	}

	@Override
	public RegularSpecialStockCal getRegTotalSellBetweenDateTime(int frId, String fromDateTime, String toDateTime, int itemId) {
		
		RegularSpecialStockCal totalSellBetweenDate=calculationRepository.getRegTotalSellBetweenDateTime(frId, fromDateTime, toDateTime, itemId);
		
		
		return totalSellBetweenDate;
	}

	@Override
	public PostFrItemStockDetail getCurrentOpeningStock(int frId, int itemId, int catId) {
		
		PostFrItemStockDetail stockDetail=new PostFrItemStockDetail();
		try {
			stockDetail = stockDetailRepository.getCurrentOpeningStock(frId,itemId , catId);
		}catch (Exception e) {
			
			System.out.println("Get Current Opening Stock ServiceImpl Exception "+e.getMessage());
		e.printStackTrace();
			
		}
		 return stockDetail;
	}

	
	


	
	
	
	
	
}
