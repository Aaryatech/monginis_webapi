package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetBillsForFr;
import com.ats.webapi.model.GetBillsForFrList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetBillsForFrRepository;

@Service
public class GetBillsForFrServiceImpl implements GetBillsForFrService  {
	
	@Autowired
	GetBillsForFrRepository getBillsForFrRepository;

	@Override
	public GetBillsForFrList getBillForFr(int frId) {
		
		GetBillsForFrList billsForFrList=new GetBillsForFrList();
		
		List<GetBillsForFr> getBillForFr=getBillsForFrRepository.getBillForSelectedFr(frId);
		
		Info info=new Info();
		
		if(getBillForFr!=null) {
		
			billsForFrList.setGetBillsForFr(getBillForFr);
			
			info.setError(false);
			info.setMessage("bills for Fr received successfully");
		
		}
		
		else {
			
			info.setError(true);
			info.setMessage("Error !: bills for Fr not received ");
			
		}
		
		billsForFrList.setInfo(info);
		
		return billsForFrList;
	}


}
