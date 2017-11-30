package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import com.ats.webapi.model.GetGrnGvnDetailsList;

public interface GetGrnGvnDetailService {
	
	GetGrnGvnDetailsList getGrnDetails(String fromDate, String toDate);
	
	GetGrnGvnDetailsList getGvnDetails(String fromDate, String toDate);
	
	GetGrnGvnDetailsList getFrGrnDetails(String fromDate, String toDate, List<String> frId);
	
	GetGrnGvnDetailsList getFrGvnDetails(String fromDate, String toDate, List<String> frId);
	
}
