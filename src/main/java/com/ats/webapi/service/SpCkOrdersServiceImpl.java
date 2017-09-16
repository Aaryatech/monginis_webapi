package com.ats.webapi.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;
import com.ats.webapi.repository.SpCakeOrdersRepoAdmin;
import com.ats.webapi.repository.SpCakeOrdersRepository;

@Service
public class SpCkOrdersServiceImpl implements SpCkOrdersService {
	
	
	String jsonSpCakeOrder="{}";
	//SpCakeOrders spCakeOrders;
	@Autowired
	SpCakeOrdersRepoAdmin spCakeOrdersRepository;
	

	@Override
	public List<SpCakeOrdersBean> findSpCakeOrder(List<Integer> frId, String prodDate) {
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeOrder(frId, prodDate);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
	}


	@Override
	public List<SpCakeOrdersBean> findSpCakeOrderAllFr(String prodDate) {
		
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeOrderAllFr(prodDate);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
		
		
	}
	
	
		
		
	}


