package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetGrnGvnDetails;
import com.ats.webapi.model.GetGrnGvnDetailsList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetGrnGvnDetailsRepository;

@Service
public class GetGrnGvnDetailServiceImpl implements GetGrnGvnDetailService {
	
	@Autowired
	GetGrnGvnDetailsRepository getGrnGvnDetailsRepository;

	@Override
	public GetGrnGvnDetailsList getGrnGvnDetails(String fromDate, String toDate) {
		
		GetGrnGvnDetailsList grnGvnDetailsList=new GetGrnGvnDetailsList();
		
		List<GetGrnGvnDetails> grnGvnDetails=getGrnGvnDetailsRepository.getAllGrnGvnDetails(fromDate, toDate);
		
		Info info=new Info();
		
		
		if(grnGvnDetails!=null) {
			
			grnGvnDetailsList.setGrnGvnDetails(grnGvnDetails);
			
			info.setError(false);
			info.setMessage("received :success grn Gvn details ");
		
		}
		
		else {
			
			info.setError(true);
			info.setMessage(" Error :failed to get grn Gvn Details "  );
			
		}
		
		
		grnGvnDetailsList.setInfo(info);
		
	return grnGvnDetailsList;
	}

}
