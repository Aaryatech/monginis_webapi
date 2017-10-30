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
	public GetGrnGvnDetailsList getGrnDetails(String fromDate, String toDate) {
		
		GetGrnGvnDetailsList grnGvnDetailsList=new GetGrnGvnDetailsList();
		
		List<GetGrnGvnDetails> grnGvnDetails=getGrnGvnDetailsRepository.getAllGrnDetails(fromDate, toDate);
		
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

	@Override
	public GetGrnGvnDetailsList getGvnDetails(String fromDate, String toDate) {
		
		
		
GetGrnGvnDetailsList grnGvnDetailsList=new GetGrnGvnDetailsList();
		
		List<GetGrnGvnDetails> grnGvnDetails=getGrnGvnDetailsRepository.getAllGvnDetails(fromDate, toDate);
		
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

	@Override
	public GetGrnGvnDetailsList getFrGrnDetails(String fromDate, String toDate, List<String> frId) {
GetGrnGvnDetailsList grnGvnDetailsList=new GetGrnGvnDetailsList();
		
		List<GetGrnGvnDetails> grnGvnDetails=getGrnGvnDetailsRepository.getFrGrnDetails(fromDate, toDate, frId);
		
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

	@Override
	public GetGrnGvnDetailsList getFrGvnDetails(String fromDate, String toDate, List<String> frId) {
		
		
		
		GetGrnGvnDetailsList grnGvnDetailsList=new GetGrnGvnDetailsList();
				
				List<GetGrnGvnDetails> grnGvnDetails=getGrnGvnDetailsRepository.getFrGvnDetails(fromDate, toDate, frId);
				
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
