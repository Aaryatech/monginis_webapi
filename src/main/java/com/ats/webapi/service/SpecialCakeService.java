package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.SpecialCake;

public interface SpecialCakeService {
	public String save(SpecialCake specialcake);
	public List<SpecialCake> showAllSpecialCake();
	public SpecialCake findSpecialCake(int spId);
	public OrderSpecialCake searchSpecialCake(String spCode);

}
