package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillHeader;
import com.ats.webapi.repository.SellBillDetailRepository;
import com.ats.webapi.repository.SellBillHeaderRepository;

@Service
public class SellBillDataServiceImpl implements SellBillDataService{

	@Autowired
	SellBillHeaderRepository sellBillHeaderRepository;
	
	@Autowired
	SellBillDetailRepository sellBillDetailRepository;
	
	public List<SellBillHeader> saveSellBillHeader(List<SellBillHeader> sellBillHeaderList) {
		
		

		List<SellBillHeader> sellBillHeaders=new ArrayList<SellBillHeader>();
		
  for(int i=0;i<sellBillHeaderList.size();i++) {
			
			      sellBillHeaders=sellBillHeaderRepository.save(sellBillHeaderList);
		
		          int sellBillNo=sellBillHeaderList.get(i).getSellBillNo();
		
		
		           List<SellBillDetail> sellBillDetailList=sellBillHeaderList.get(i).getSellBillDetailsList();
		
		       for(int j=0;j<sellBillDetailList.size();j++) {
			
		             	   SellBillDetail sellBillDetail=sellBillDetailList.get(j);
			
			               sellBillDetail.setSellBillNo(sellBillNo);
			
			
			              SellBillDetail sellBillDetails=sellBillDetailRepository.save(sellBillDetail);
			
		            }
		
	
		}
		return sellBillHeaders;
	}
	

}
