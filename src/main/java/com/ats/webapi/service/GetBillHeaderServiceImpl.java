package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetBillHeader;
import com.ats.webapi.model.GetBillHeaderList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetBillHeaderRepository;

@Service
public class GetBillHeaderServiceImpl implements GetBillHeaderService {
	
	@Autowired
	GetBillHeaderRepository getBillHeaderRepository;

	@Override
	public GetBillHeaderList getBillHeader(List<String> frId, String fromDate, String toDate) {
		
		GetBillHeaderList getBillHeaderList=new GetBillHeaderList();
		
		List<GetBillHeader> billHeaders=getBillHeaderRepository.getBillHeader(frId, fromDate, toDate);
		
		Info info=new Info();
		
		if(billHeaders!=null) {
			
			getBillHeaderList.setGetBillHeaders(billHeaders);
			
			info.setError(false);
			info.setMessage("Bill header List received successfully");
			
		}
		
		else {
			
			info.setError(true);
			info.setMessage("Error: failed to receive Bill Header List ");
		}
		
		getBillHeaderList.setInfo(info);
		
		
		return getBillHeaderList;
	}

	@Override
	public GetBillHeaderList getBillHeaderForAllFr(String fromDate, String toDate) {
		
GetBillHeaderList getBillHeaderList=new GetBillHeaderList();
		
		List<GetBillHeader> billHeaders=getBillHeaderRepository.getBillHeaderForAllFr(fromDate, toDate);
		Info info=new Info();
		
		if(billHeaders!=null) {
			
			getBillHeaderList.setGetBillHeaders(billHeaders);
			
			info.setError(false);
			info.setMessage("Bill header List for all Fr received successfully");
			
		}
		
		else {
			
			info.setError(true);
			info.setMessage("Error: failed to receive Bill Header List ");
		}
		
		getBillHeaderList.setInfo(info);
		
		
		return getBillHeaderList;
		
	}

}
