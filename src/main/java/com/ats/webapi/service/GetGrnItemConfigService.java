package com.ats.webapi.service;

import java.util.Date;

import com.ats.webapi.model.GetGrnItemConfigList;

public interface GetGrnItemConfigService {
	
	
	GetGrnItemConfigList getAllGrnItemConfiguration(String cDate,int frId);
	
	GetGrnItemConfigList getGvnItemConfig(int billNo);

}
