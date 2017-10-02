package com.ats.webapi.service;


import java.util.Date;
import java.util.List;

import com.ats.webapi.model.GenerateBillList;

public interface GenerateBillService {
	
	GenerateBillList generateBillService(List<Integer> frId,List<Integer> menuId, String delDate);
	

}
