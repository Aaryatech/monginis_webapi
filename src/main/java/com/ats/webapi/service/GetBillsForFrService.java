package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetBillsForFr;
import com.ats.webapi.model.GetBillsForFrList;

public interface GetBillsForFrService {
	
	GetBillsForFrList getBillForFr(int frId);
	
}
