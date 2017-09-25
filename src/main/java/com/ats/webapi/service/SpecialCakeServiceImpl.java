package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.SearchSpCakeResponse;
import com.ats.webapi.model.SpecialCake;
import com.ats.webapi.model.SpecialCakeList;
import com.ats.webapi.repository.OrderSpCakeRepository;
import com.ats.webapi.repository.SpecialCakeRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class SpecialCakeServiceImpl implements SpecialCakeService{
	
	String jsonSpecialCake="{}";
	SpecialCake specialcake=null;
	
	@Autowired
	SpecialCakeRepository specialcakeRepository;
	@Autowired
	OrderSpCakeRepository orderSpCakeRepository;
	
	@Override
	public String save(SpecialCake specialcake) {
		
		SpecialCakeList specialCakeList=new SpecialCakeList();
		String jsonSpecialCake="";
		
		
		try {
			System.out.println("inside special cake insert");
			if(specialcake!=null) {
				
				    System.out.println("before save");
					specialcake=specialcakeRepository.save(specialcake);
					System.out.println("after save");
					
					Info info=new Info();
					info.setError(false);
					info.setMessage("Special cake inserted successfully ");
					jsonSpecialCake=JsonUtil.javaToJson(info);
			}
			else {
				Info info=new Info();
				info.setError(true);
				info.setMessage("Special cake insert failure");
				jsonSpecialCake=JsonUtil.javaToJson(info);
			}
		
		}
		catch(Exception e ) {
			System.out.println("error in special cake insertion "+e.getMessage());
			
		}
		
		return jsonSpecialCake;
	}
	
	@Override
	public List<SpecialCake> showAllSpecialCake() {
		List<SpecialCake> specialCakeList=specialcakeRepository.findByDelStatus(0);
		return specialCakeList;		
	}

	@Override
	public SpecialCake findSpecialCake(int spId) {
		SpecialCake specialCake=specialcakeRepository.findOne(spId);
		return specialCake;
	}

	@Override
	public SearchSpCakeResponse searchSpecialCake(String spCode) {
		
		OrderSpecialCake specialCake=null;
		SearchSpCakeResponse searchSpCakeResponse=new SearchSpCakeResponse();
		ErrorMessage errorMessage=new ErrorMessage();
		
	    specialCake=orderSpCakeRepository.findBySpCode(spCode);
		if(specialCake==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Special Cake Not Found");
			searchSpCakeResponse.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Special Cake Found Successfully");
			searchSpCakeResponse.setErrorMessage(errorMessage);
			searchSpCakeResponse.setSpecialCake(specialCake);
		}
		
		return searchSpCakeResponse;
	}
	

}
