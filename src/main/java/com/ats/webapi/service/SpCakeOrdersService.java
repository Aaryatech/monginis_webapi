package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SpCakeOrderRes;
import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersList;
import com.ats.webapi.model.SpCkOrderHisList;

public interface SpCakeOrdersService {

	SpCakeOrderRes placeSpCakeOrder(SpCakeOrders spCakeOrders);
	//public List<SpCakeOrders> findSpCakeOrder(List<Integer> frCode,Date prodDate);
	public List<SpCakeOrders> findSpCakeOrder(List<Integer> frCode,Date prodDate);
	SpCkOrderHisList searchOrderHistory(int menuId, String spDeliveryDt,String frCode);
	
	
	
}
