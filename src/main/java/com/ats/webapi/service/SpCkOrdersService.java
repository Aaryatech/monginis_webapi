package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;

public interface SpCkOrdersService {
	public List<SpCakeOrdersBean> findSpCakeOrder(List<Integer> frCode,String prodDate);
	
	public List<SpCakeOrdersBean> findSpCakeOrderAllFr(String prodDate);
	

}
