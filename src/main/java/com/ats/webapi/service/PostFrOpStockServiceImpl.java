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
	public List<PostFrItemStockHeader> saveFrOpStockHeader(PostFrItemStockHeader postFrItemStockHeader) {
		
		PostFrItemStockHeader postFrItemStockHeaders=new PostFrItemStockHeader();
		List<PostFrItemStockHeader> postFrItemStockHeaderList=new ArrayList<PostFrItemStockHeader>();
		
			
			
			postFrItemStockHeaders=postFrOpStockHeaderRepository.save(postFrItemStockHeader);
			postFrItemStockHeaderList.add(postFrItemStockHeaders);
			int headerId=postFrItemStockHeader.getOpeningStockHeaderId();
			
			
			List<PostFrItemStockDetail> PostFrItemStockDetailList=postFrItemStockHeader.getPostFrItemStockDetailList();
			
			for(int j=0;j<PostFrItemStockDetailList.size();j++) {
				
				PostFrItemStockDetail postFrItemStockDetail=PostFrItemStockDetailList.get(j);
				
				postFrItemStockDetail.setOpeningStockHeaderId(headerId);
				
				
				postFrOpStockDetailRepository.save(postFrItemStockDetail);
				
			
			}
			
		
		return postFrItemStockHeaderList;
	}


	@Override
	public int updateEndMonth(PostFrItemStockHeader postFrItemStockHeader) {
		PostFrItemStockHeader postFrItemStockHeaders=new PostFrItemStockHeader();
	
		
			int headerId=postFrItemStockHeader.getOpeningStockHeaderId();
			
			
			List<PostFrItemStockDetail> PostFrItemStockDetailList=postFrItemStockHeader.getPostFrItemStockDetailList();
			
			for(int j=0;j<PostFrItemStockDetailList.size();j++) {
				
				PostFrItemStockDetail postFrItemStockDetail=PostFrItemStockDetailList.get(j);
				
				postFrOpStockDetailRepository.save(postFrItemStockDetail);
				
				
			}
			int x=postFrOpStockHeaderRepository.endMonth(headerId);
			postFrItemStockHeaders= postFrOpStockHeaderRepository.getHeader(headerId);
			PostFrItemStockHeader header=new PostFrItemStockHeader();
			if(postFrItemStockHeaders.getMonth()==12)
			{
				header.setYear(postFrItemStockHeaders.getYear()+1);
				header.setMonth(1);
				
			}
			else {
				header.setMonth(postFrItemStockHeaders.getMonth()+1);
			}
			header.setIsMonthClosed(0);
			postFrItemStockHeaders=postFrOpStockHeaderRepository.save(header);
			
			
			
				for(int j=0;j<PostFrItemStockDetailList.size();j++) {
				
				PostFrItemStockDetail postFrItemStockDetail=PostFrItemStockDetailList.get(j);
				int opStock=(postFrItemStockDetail.getOpeningStock()+postFrItemStockDetail.getTotalPurchase())-(postFrItemStockDetail.getTotalGrnGvn()+postFrItemStockDetail.getTotalGrnGvn());
				postFrItemStockDetail.setOpeningStock(opStock);
				postFrItemStockDetail.setOpeningStockHeaderId(postFrItemStockHeaders.getOpeningStockHeaderId());
				postFrOpStockDetailRepository.save(postFrItemStockDetail);
				
			
			}
		return x;
	}


	@Override
	public PostFrItemStockHeader getFrOpStockHeader(int frId, int month, int year) {
		
		PostFrItemStockHeader postFrItemStockHeader=postFrOpStockHeaderRepository.getFrHeader(frId, month, year);
		int headerId=postFrItemStockHeader.getOpeningStockHeaderId();
		
		List<PostFrItemStockDetail> postFrItemStockDetail=postFrOpStockDetailRepository.getFrDetail(headerId);
		postFrItemStockHeader.setPostFrItemStockDetailList(postFrItemStockDetail);
		
		return postFrItemStockHeader;
	}
	}


	


	
	


