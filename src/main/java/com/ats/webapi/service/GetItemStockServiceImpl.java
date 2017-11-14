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

	
	
	
	
}
