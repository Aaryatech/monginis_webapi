package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import com.ats.webapi.model.ItemOrderList;
import com.ats.webapi.model.Orders;



public interface OrderService {

	List<Orders> placeOrder(List<Orders> list);
	ItemOrderList searchOrderHistory(int menuId, Date deliveryDate,int frId);

}
