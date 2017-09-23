package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.OrderSpecialCake;
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
			if(specialcake!=null /*&& !specialcake.getErpLinkcode().trim().equals("")&&
					specialcake.getSpBookb4()!=null && !specialcake.getSpBookb4().trim().equals("")&&
					specialcake.getSpCode()!=null && !specialcake.getSpCode().trim().equals("")&&
					specialcake.getSpeIdlist()!=null && !specialcake.getSpeIdlist().trim().equals("")&&
					specialcake.getSpImage()!=null && !specialcake.getSpImage().trim().equals("")&&
					specialcake.getSprId()!=null && !specialcake.getSprId().trim().equals("")&&
					specialcake.getSpBookb4()!=null && !specialcake.getSpBookb4().trim().equals("")&&
					specialcake.getSpMaxwt()!=null && !specialcake.getSpMaxwt().trim().equals("")&&
					specialcake.getSpMinwt()!=null && !specialcake.getSpMinwt().trim().equals("")&&
					specialcake.getSpName()!=null && !specialcake.getSpName().trim().equals("")*/) {
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
	public OrderSpecialCake searchSpecialCake(String spCode) {
		
		
		
		OrderSpecialCake specialCake=orderSpCakeRepository.findBySpCode(spCode);		
		return specialCake;
		
	}
	

}
