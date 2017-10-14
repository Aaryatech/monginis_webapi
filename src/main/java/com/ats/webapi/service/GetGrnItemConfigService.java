package com.ats.webapi.service;

import java.util.Date;

import com.ats.webapi.model.GetGrnItemConfigList;

public interface GetGrnItemConfigService {
	
	
	GetGrnItemConfigList getAllGrnItemConfiguration(Date cDate);

}
