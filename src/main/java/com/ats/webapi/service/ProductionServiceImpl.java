package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetProductionDetail;
import com.ats.webapi.model.GetProductionHeader;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.PostProductionDetail;
import com.ats.webapi.model.PostProductionHeader;
import com.ats.webapi.repository.GetProdQytRepository;
import com.ats.webapi.repository.PostPoductionHeaderRepository;
import com.ats.webapi.repository.PostProductionDetailRepository;

@Service
public class ProductionServiceImpl implements ProductionService{

	@Autowired
	PostPoductionHeaderRepository postPoductionHeaderRepository;
	
	@Autowired
	PostProductionDetailRepository postProductionDetailRepository;
	
	@Autowired
	GetProdQytRepository getProdQytRepository;
	
	@Override
	public List<PostProductionHeader> saveProductionHeader(PostProductionHeader postProductionHeader) {
		PostProductionHeader postProductionHeaders=new PostProductionHeader();
		List<PostProductionHeader> postProductionHeaderList=new ArrayList<PostProductionHeader>();
		
			
			
		postProductionHeaders=postPoductionHeaderRepository.save(postProductionHeader);
		postProductionHeaderList.add(postProductionHeaders);
			int headerId=postProductionHeader.getProductionHeaderId();
			
			
			List<PostProductionDetail> postProductionDetailList=postProductionHeader.getPostProductionDetail();
			
			for(int j=0;j<postProductionDetailList.size();j++) {
				
				PostProductionDetail postProductionDetail=postProductionDetailList.get(j);
				
				postProductionDetail.setProductionHeaderId(headerId);
				
				
				postProductionDetailRepository.save(postProductionDetail);
				
			
			}
			
		
		return postProductionHeaderList;
	}
	
	
	@Override
	public List<GetProductionDetail> getProdQty(List<String> catId, String productionDate, int timeSlot) {
		
		System.out.println("In Menthod");
		
		List<GetProductionDetail> getProductionDetailList=getProdQytRepository.getProdQyt(catId, productionDate, timeSlot);
		
		
		return getProductionDetailList;
	}


	

}
