package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetDumpOrder;

public interface GetDumpOrderService {

	public List<GetDumpOrder> findFrOrder(List<String>  frId,String menuId,String date);
	
}
