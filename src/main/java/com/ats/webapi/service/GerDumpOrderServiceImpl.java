package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetDumpOrder;
import com.ats.webapi.repository.GetDumpOrderRepository;
@Service
public class GerDumpOrderServiceImpl implements GetDumpOrderService {

	@Autowired
	GetDumpOrderRepository orderDumpRepository;
	@Override
	public List<GetDumpOrder> findFrOrder(List<String> frId, String menuId, String date) {
		List<GetDumpOrder> getDumpOrderList=null;
		try {
			getDumpOrderList=orderDumpRepository.findAllNativeFrOrder( frId,menuId, date);
		
		System.out.println("order para 1= "+frId.toString());
		System.out.println("order para 2= "+menuId);
		System.out.println("order para 3 = "+date.toString());
		
		
		}catch (Exception e) {
			System.out.println("inside order service impl ex "+e.getMessage());
		}
		return getDumpOrderList;
	}

}
