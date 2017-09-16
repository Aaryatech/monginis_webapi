package com.ats.webapi.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SpCakeOrderRes;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersList;
import com.ats.webapi.model.SpCkOrderHis;
import com.ats.webapi.model.SpCkOrderHisList;
import com.ats.webapi.repository.SpCakeOrderHisRepository;
import com.ats.webapi.repository.SpCakeOrdersRepository;

@Service
public class SpCakeOrdersServiceImpl implements SpCakeOrdersService {

	String jsonSpCakeOrder="{}";
	@Autowired
	SpCakeOrdersRepository spCakeOrdersRepository;
	@Autowired
	SpCakeOrderHisRepository spCakeOrderHisRepository;
	SpCakeOrderRes spCakeOrderRes=new SpCakeOrderRes();
	ErrorMessage errorMessage=new ErrorMessage();
	@Override
	public SpCakeOrderRes placeSpCakeOrder(SpCakeOrders spCakeOrders) {
		try {
		SpCakeOrders spCakeOrder=spCakeOrdersRepository.save(spCakeOrders);
		if(spCakeOrder!=null) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("Order Saved Successfully");
			spCakeOrderRes.setErrorMessage(errorMessage);
			spCakeOrderRes.setSpCakeOrder(spCakeOrder);
		}
	} catch (Exception e) {
		errorMessage.setError(true);
		errorMessage.setMessage("Exc while saving Item");
		spCakeOrderRes.setErrorMessage(errorMessage);
		
	}
		return spCakeOrderRes;
	}
	@Override
	public List<SpCakeOrders> findSpCakeOrder(List<Integer> frId, Date prodDate) {
		List<SpCakeOrders> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.findByFrCodeInAndSpProduDate(frId, prodDate);
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
	}
/*
	@Override
	public List<SpCakeOrders> findSpCakeOrder(List<Integer> frCode, Date prodDate) {
		List<SpCakeOrders> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.findByFrCodeInAndSpProdudate(frCode, prodDate);
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
	}*/
	@Override
	public SpCkOrderHisList searchOrderHistory(int menuId, String spDeliveryDt,String frCode) {
		List<SpCkOrderHis> spCakeOrders=null;
		SpCkOrderHisList spCakeOrderHisList;
		ErrorMessage errorMessage;
		try {
			spCakeOrders=spCakeOrderHisRepository.findByMenuIdInAndSpDeliveryDt(menuId, spDeliveryDt,frCode);
		
			if(spCakeOrders==null)
			{
				errorMessage=new ErrorMessage();
				spCakeOrderHisList=new SpCkOrderHisList();
				
				errorMessage.setError(true);
				errorMessage.setMessage("Orders Not Found");
				
				spCakeOrderHisList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage=new ErrorMessage();
				spCakeOrderHisList=new SpCkOrderHisList();
				
				errorMessage.setError(false);
				errorMessage.setMessage("Orders found Successfully");
				
				spCakeOrderHisList.setSpOrderList(spCakeOrders);
				spCakeOrderHisList.setErrorMessage(errorMessage);
			}
		}catch (Exception e) {
			errorMessage=new ErrorMessage();
			spCakeOrderHisList=new SpCkOrderHisList();

			errorMessage.setError(true);
			errorMessage.setMessage("Orders Not Found(EXC)");
			spCakeOrderHisList.setErrorMessage(errorMessage);
		}
		return spCakeOrderHisList;
	}
		
		
	}


