package com.ats.webapi.service.storestock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.GetStoreCurrentStock;
import com.ats.webapi.model.stock.StoreStockDetail;
import com.ats.webapi.model.stock.StoreStockHeader;
import com.ats.webapi.repository.storestock.GetStoreCurrentStockRepository;
import com.ats.webapi.repository.storestock.StoreStockDetailRepository;
import com.ats.webapi.repository.storestock.StoreStockHeaderRepository;

@Service
public class StoreStockServiceImpl implements StoreStockService{

	@Autowired
	StoreStockHeaderRepository storeStockHeaderRepository;
	
	@Autowired
	StoreStockDetailRepository storeStockDetailRepository;
	
	@Autowired
	GetStoreCurrentStockRepository getStoreCurrentStockRepository;

	@Override
	public StoreStockHeader insertStoreOpStock(StoreStockHeader storeStockHeader) {
	 
		StoreStockHeader storeHeader=storeStockHeaderRepository.save(storeStockHeader);
		int headerId=storeHeader.getStoreStockId();
		
		List<StoreStockDetail> storeStockDetailList=storeStockHeader.getStoreStockDetailList();
		
		for(int i=0;i<storeStockDetailList.size();i++)
		{
			StoreStockDetail storeStockDetail=storeStockDetailList.get(i);
			storeStockDetail.setStoreStockId(headerId);
			StoreStockDetail storeStockDetailRes=storeStockDetailRepository.save(storeStockDetail);
		}
		
		Info info=new Info();
		if(storeHeader!=null)
		{
			
			info.setError(false);
			info.setMessage("insert Successfullt");
		}
		return storeHeader;
	}

	@Override
	public List<StoreStockDetail> getMonthWiseStoreStock(String fromDate, String toDate) {
		 
		List<StoreStockDetail> storeStockDetailList= storeStockDetailRepository.getMonthWiseSoreStock(fromDate,toDate);
		
		return storeStockDetailList;
	}

	@Override
	public List<GetStoreCurrentStock> getCurrentStock(int deptId) {


		List<GetStoreCurrentStock> getStoreCurrentStockList=getStoreCurrentStockRepository.getCurrentStock(deptId);
		
		return getStoreCurrentStockList;
	}

	@Override
	public StoreStockHeader getCurrentStockHeader(int status) {
		 
		StoreStockHeader storeStockHeader=storeStockHeaderRepository.findByStoreStockStatus(status);
		
		int storeStockHeaderId=storeStockHeader.getStoreStockId();
		
		List<StoreStockDetail> storeStockDetailList=storeStockDetailRepository.findByStoreStockId(storeStockHeaderId);
		
		storeStockHeader.setStoreStockDetailList(storeStockDetailList);
		
		return storeStockHeader;
	}
	
	
}
