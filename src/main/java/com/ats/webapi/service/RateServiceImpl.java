package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Event;
import com.ats.webapi.model.Rates;

import com.ats.webapi.model.User;
import com.ats.webapi.repository.RateRepository;
import com.ats.webapi.util.JsonUtil;

@Service("RateService")
public class RateServiceImpl implements RateService
{
	@Autowired
	private RateRepository rateRepository;
	
	String jsonRate = "{}";
	User user = null;
	ErrorMessage errorMessage = new ErrorMessage();
	@Override
	public String save(Rates rate)
	{
		
		try {
			rate = rateRepository.save(rate);
			
				errorMessage.setError(false);
				errorMessage.setMessage("Record Inserted Successfully");

				jsonRate = JsonUtil.javaToJson(errorMessage);
			
		} catch (Exception e) {
			errorMessage.setError(true);
			errorMessage.setMessage("Exception occured while inserting NewUser");
			jsonRate = JsonUtil.javaToJson(errorMessage);
			
		}
		return jsonRate;
		
	}
	public RateList findAllRates() {
		 List<Rates> items=new ArrayList<Rates>();
		 RateList rateList=new RateList();
		ErrorMessage errorMessage=new ErrorMessage();
		items=rateRepository.findByDelStatus(0);
		if(items!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All items displayed successfully");
			rateList.setErrorMessage(errorMessage);
			rateList.setRates(items);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Items Not Found");
			rateList.setErrorMessage(errorMessage);
		}
		
		return rateList;
	}
	@Override
	public Rates findRate(int sprId) {
		Rates rate=rateRepository.findOne(sprId);

		return rate;
	}
	
}
