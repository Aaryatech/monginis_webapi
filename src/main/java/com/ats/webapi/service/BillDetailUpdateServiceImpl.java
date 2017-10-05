package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.BillDetailUpdate;
import com.ats.webapi.repository.BillDetailUpdateRepository;

@Service
public class BillDetailUpdateServiceImpl implements BillDetailUpdateService{
	
	@Autowired
	BillDetailUpdateRepository billDetailUpdateRepository;

	@Override
	public BillDetailUpdate updateBillDetail( int billDetailNo, int billQty, float total, float totWithoutTax) {
	
		BillDetailUpdate bDetailUpdate=billDetailUpdateRepository.updateBillDetail(billDetailNo, billQty, total, totWithoutTax);
				
		
	return bDetailUpdate;
	
	}


}
