package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.repository.GetOrderItemRepository;

@Service
public class GetOrderItemQtyServiceImpl implements GetOrderItemQtyService{
	@Autowired
	GetOrderItemRepository getOrderItemRepository;
	
	@Override
	public GetOrderItemQty getOrderQty(int itemId, String orderDate) {
		GetOrderItemQty getOrderItemQty=getOrderItemRepository.getOrderItemQty(itemId, orderDate);
		
		System.out.println("inside service impl "+getOrderItemQty);
		
		return getOrderItemQty;
	}

}
