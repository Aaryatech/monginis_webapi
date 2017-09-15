package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.GetOrder;
import com.ats.webapi.model.Order;

public interface GetOrderService {
	//public List<Order> findOrder(List<Integer> frId,String itemId,Date date1);
	
	//public List<Order> findOrderForOtherFr(List<Integer> frId,String itemId,Date date1);
	
	
	
	public List<GetOrder> findOrder2(List<Integer>  frId,List<Integer> menuId,String date1);
	
	
	public List<GetOrder> findOrderAllFr(List<Integer> menuId,String date1);
	//public List<GetOrder> findOrder(String itemId);
	
}
