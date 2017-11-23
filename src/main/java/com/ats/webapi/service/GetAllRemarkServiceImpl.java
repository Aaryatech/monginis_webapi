package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.remarks.GetAllRemarks;
import com.ats.webapi.model.remarks.GetAllRemarksList;
import com.ats.webapi.repository.GetAllRemarksRepo;

@Service
public class GetAllRemarkServiceImpl implements GetAllRemarkService {
	
	@Autowired
	GetAllRemarksRepo getAllRemarksRepo;

	@Override
	public GetAllRemarksList getAllRemarkFor() {
		
		GetAllRemarksList allRemarkList=new GetAllRemarksList();
		
		Info info=new Info();
		
		
		
		List<GetAllRemarks> allRemark=getAllRemarksRepo.findAll();
		
		if(!allRemark.isEmpty()) {
			
			allRemarkList.setGetAllRemarks(allRemark);
			
			info.setError(false);
			info.setMessage("remark received successfully");
			
		}
		
		else {
			
			info.setError(true);
			info.setMessage("ERROR:remark failed");
			
		}
		
		
			allRemarkList.setInfo(info);
		
	return allRemarkList;
	
	
	}
	

}
