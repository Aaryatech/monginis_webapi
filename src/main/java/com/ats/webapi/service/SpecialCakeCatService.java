package com.ats.webapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetSpCkSupplement;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.SearchSpCakeResponse;
import com.ats.webapi.model.SpCakeCatSupplement;
import com.ats.webapi.model.SpecialCakeCat;

public interface SpecialCakeCatService {

	public String save(SpecialCakeCat specialcake);
	public List<SpecialCakeCat> showAllSpecialCake();
	public SpecialCakeCat findSpecialCake(int spId);
	public SearchSpCakeResponse searchSpecialCake(String spCode);
	public List<String> searchSpecialCakeSpCodes(List<Integer>items,int frId,int menuId);
	public SpCakeCatSupplement saveSpCakeSup(SpCakeCatSupplement spCakeSupplement);
	public Info deleteSpCakeSup(int id);
	public GetSpCkSupplement getSpCakeSupp(int id);
	public List<GetSpCkSupplement> getSpCakeSupList();
	
}
