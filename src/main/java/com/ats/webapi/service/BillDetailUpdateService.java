package com.ats.webapi.service;

import com.ats.webapi.model.BillDetailUpdate;

public interface BillDetailUpdateService {
	
	BillDetailUpdate updateBillDetail(int billDetailNo,int billQty,float total, float totWithoutTax);
 
}
