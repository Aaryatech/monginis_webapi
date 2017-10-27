package com.ats.webapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.repository.PostBillHeaderRepository;

@Service
public class GetItemStockServiceImpl implements GetItemStockService{
	
	
	@Autowired
	PostBillHeaderRepository billHeaderRepository;
	
	
	@Override
	public int getTotalPurchase(int frId, String fromDate, String toDate, int itemId) {
		
		int purchase=billHeaderRepository.getTotalPurchase(frId,fromDate,toDate,itemId);
		System.out.println("Total Purchase "+purchase);
		
		return purchase;
	}

	@Override
	public int getTotalGrnGvn(int frId, String fromDate, String toDate, int itemId) {
		
		int grnGvn=billHeaderRepository.getTotalGrnGvn(frId,fromDate,toDate,itemId);
		System.out.println("Total Grn "+grnGvn);
		
		return grnGvn;
	}

	@Override
	public int getTotalSell(int frId, String fromDate, String toDate, int itemId) {
		
		int totalSell=billHeaderRepository.getTotalSell(frId,fromDate,toDate,itemId);
		System.out.println("Total Sell "+totalSell);
		
		return 0;
	}

	
	
	
	
}
