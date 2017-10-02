package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.RegularSpCake;
import com.ats.webapi.repository.RegularSpCkOrderRepository;

@Service
public class RegularSpCkOrderServiceImpl implements RegularSpCkOrderService{

	
	@Autowired
	RegularSpCkOrderRepository regularSpCkOrderRepository;
	
	
	@Override
	public ErrorMessage placeRegularSpCakeOrder(RegularSpCake regularSpCake) {
	  
		ErrorMessage errorMessage=new ErrorMessage();
		
		RegularSpCake regularSpCakeOrder=regularSpCkOrderRepository.save(regularSpCake);
		
		if(regularSpCakeOrder!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Regular Sp Cake Order Placed Successfully");
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Regular Sp Cake Order Failed to Insert");
			
		}
		
		return errorMessage;
	}

}
