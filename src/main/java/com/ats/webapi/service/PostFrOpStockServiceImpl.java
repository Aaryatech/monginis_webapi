package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.repository.PostFrOpStockDetailRepository;
import com.ats.webapi.repository.PostFrOpStockHeaderRepository;

@Service
public class PostFrOpStockServiceImpl implements PostFrOpStockService{

	@Autowired
	PostFrOpStockHeaderRepository  postFrOpStockHeaderRepository;
	
	@Autowired
	PostFrOpStockDetailRepository  postFrOpStockDetailRepository;
	
	
	@Override
	public List<PostFrItemStockHeader> saveFrOpStockHeader(List<PostFrItemStockHeader> postFrItemStockHeader) {
		
		PostFrItemStockHeader postFrItemStockHeaders=new PostFrItemStockHeader();
		List<PostFrItemStockHeader> postFrItemStockHeaderList=new ArrayList<PostFrItemStockHeader>();
		for(int i=0;i<postFrItemStockHeader.size();i++) {
			
			
			
			postFrItemStockHeaders=postFrOpStockHeaderRepository.save(postFrItemStockHeader.get(i));
			postFrItemStockHeaderList.add(postFrItemStockHeaders);
			int headerId=postFrItemStockHeader.get(i).getOpeningStockHeaderId();
			
			
			List<PostFrItemStockDetail> PostFrItemStockDetailList=postFrItemStockHeader.get(i).getPostFrItemStockDetailList();
			
			for(int j=0;j<PostFrItemStockDetailList.size();j++) {
				
				PostFrItemStockDetail postFrItemStockDetail=PostFrItemStockDetailList.get(j);
				
				postFrItemStockDetail.setOpeningStockHeaderId(headerId);
				
				
				postFrOpStockDetailRepository.save(postFrItemStockDetail);
				
			
			}
			
		}
		return postFrItemStockHeaderList;
	}

}
