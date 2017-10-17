package com.ats.webapi.service;

import java.sql.Date;

import com.ats.webapi.model.GetGrnGvnDetailsList;

public interface GetGrnGvnDetailService {
	
	GetGrnGvnDetailsList getGrnDetails(String fromDate, String toDate);
	
	GetGrnGvnDetailsList getGvnDetails(String fromDate, String toDate);
	
	
}
