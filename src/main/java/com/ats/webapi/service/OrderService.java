package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemOrderList;
import com.ats.webapi.model.Orders;



public interface OrderService {

	List<Orders> placeOrder(List<Orders> list);
	ItemOrderList searchOrderHistory(int menuId, Date deliveryDate,int frId);
	
	int updateBillStatus(@Param("orderId") int orderId,@Param("status") int status);// from OrderRepository
	
	List<Orders> placePustDumpOrder(List<Orders> list);

}
