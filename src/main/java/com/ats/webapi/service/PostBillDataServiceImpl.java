package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.PostBillDetail;
import com.ats.webapi.model.PostBillHeader;
import com.ats.webapi.repository.PostBillDetailRepository;
import com.ats.webapi.repository.PostBillHeaderRepository;

@Service
public class PostBillDataServiceImpl implements PostBillDataService  {
	
	@Autowired
	PostBillHeaderRepository  postBillHeaderRepository;
	
	@Autowired
	PostBillDetailRepository  postBillDetailRepository;

	/*@Override
	public List<PostBillDetail> saveBillDetails(List<PostBillDetail> postBillDetail) {
	
		List<PostBillDetail> billDetail=new ArrayList<PostBillDetail>();
		for(PostBillDetail pBDetails:postBillDetail) {
			
			billDetail=postBillDataService.saveBillDetails(postBillDetail);
			
		}
		
		return billDetail;
	}*/

	@Override
	public List<PostBillHeader> saveBillHeader(List<PostBillHeader> postBillHeader,List<PostBillDetail> postBillDetail) {
		
		List<PostBillHeader> postBillHeaders=new ArrayList<PostBillHeader>();
		for(int i=0;i<postBillHeader.size();i++) {
			
			postBillHeaders=postBillHeaderRepository.save(postBillHeader);
			
			int billNo=postBillHeader.get(i).getBillNo();
			
			postBillDetail.get(i).setBillNo(billNo);
			postBillDetailRepository.save(postBillDetail);
			
		}
		
		return postBillHeaders;
	}

	

	
}
