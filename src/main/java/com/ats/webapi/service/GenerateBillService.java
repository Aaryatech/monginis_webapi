package com.ats.webapi.service;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GenerateBill;
import com.ats.webapi.model.GenerateBillList;

public interface GenerateBillService {
	
	GenerateBillList generateBillService(List<Integer> frId,List<Integer> menuId, String delDate);
	
	GenerateBillList generateBillServiceForAllFr(List<Integer> menuId, String delDate);
	
	GenerateBillList generateBillForAllFrAllMenu(@Param("delDate")String delDate);

	GenerateBillList generateBillForAllMenu(List<Integer> frId,String delDate);
	

}
