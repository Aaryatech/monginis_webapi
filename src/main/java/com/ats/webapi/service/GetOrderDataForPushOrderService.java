package com.ats.webapi.service;

import java.sql.Date;

import com.ats.webapi.model.GetOrderDataForPushOrderList;

public interface GetOrderDataForPushOrderService {

	
	GetOrderDataForPushOrderList getOrderDataForPushOrder(Date cDate,int grnType);
	
}
