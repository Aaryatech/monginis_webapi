package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.SearchSpCakeResponse;
import com.ats.webapi.model.SpecialCake;


public interface SpecialCakeService {
	public String save(SpecialCake specialcake);
	public List<SpecialCake> showAllSpecialCake();
	public SpecialCake findSpecialCake(int spId);
	public SearchSpCakeResponse searchSpecialCake(String spCode);
	public List<String> searchSpecialCakeSpCodes(List<Integer>items,int frId,int menuId);
}
