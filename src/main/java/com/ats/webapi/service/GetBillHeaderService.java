package com.ats.webapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetBillHeaderList;


public interface GetBillHeaderService {
	
	GetBillHeaderList getBillHeader(List<String>frId, String fromDate, String toDate);
	

}
