package com.ats.webapi.service;

import java.sql.Date;

import com.ats.webapi.model.GetGrnGvnDetailsList;

public interface GetGrnGvnDetailService {
	
	GetGrnGvnDetailsList getGrnGvnDetails(String fromDate, String toDate);
	
	
}
