package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.model.GetRegSpCakeOrderQty;
import com.ats.webapi.repository.GetOrderItemRepository;
import com.ats.webapi.repository.GetRegSpCakeOrderQtyRepository;

@Service
public class GetOrderItemQtyServiceImpl implements GetOrderItemQtyService{
	@Autowired
	GetOrderItemRepository getOrderItemRepository;
	@Autowired
	GetRegSpCakeOrderQtyRepository getRegSpCakeOrderQtyRepository;
	
	/*@Override
	public GetOrderItemQty getOrderQty(int itemId, String orderDate, int menuId) {
		GetOrderItemQty getOrderItemQty=getOrderItemRepository.getOrderItemQty(itemId, orderDate, menuId);
		
		System.out.println("inside service impl "+getOrderItemQty);
		
		return getOrderItemQty;
	}*/

	/*@Override
	public GetRegSpCakeOrderQty getRegSpCakeOrderQty(int itemId, String orderDate, int menuId) {
		GetRegSpCakeOrderQty getRegSpCakeOrderItemQty=getRegSpCakeOrderQtyRepository.getRegSpCakeOrderItemQty(itemId, orderDate, menuId);
		
		System.out.println("inside service impl "+getRegSpCakeOrderItemQty);
		
		return getRegSpCakeOrderItemQty;
	}
*/
	@Override
	public List<GetRegSpCakeOrderQty> getRegSpCakeOrderQty(String orderDate, List<String> menuId) {
List<GetRegSpCakeOrderQty> getRegSpCakeOrderItemQtyList=getRegSpCakeOrderQtyRepository.getRegSpCakeOrderAllItemQty(orderDate, menuId);
		
		System.out.println("inside service impl "+getRegSpCakeOrderItemQtyList);
		
		return getRegSpCakeOrderItemQtyList;
	}

	@Override
	public List<GetOrderItemQty> getOrderQty(String orderDate, List<String> menuId) {
List<GetOrderItemQty> getOrderItemQtyList=getOrderItemRepository.getOrderAllItemQty(orderDate, menuId);
		
		System.out.println("inside service impl "+getOrderItemQtyList);
		
		return getOrderItemQtyList;
	}
	

}
