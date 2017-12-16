package com.ats.webapi.service.bmsstock;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.BmsStockDetailed;
import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.repository.BmsStockDetailedRepository;
import com.ats.webapi.repository.BmsStockHeaderRepository;


@Service
public class BmsStockServiceImp implements BmsStockService {
	
	@Autowired
	BmsStockHeaderRepository bmsStockHeaderRepository;
	
	@Autowired
	BmsStockDetailedRepository bmsStockDetailedRepository;
	
	@Override
	public BmsStockHeader insertBmsStock(BmsStockHeader bmsStockHeader) {
		
		BmsStockHeader bmsStockHeaderloc = new BmsStockHeader();
		
		try
		{
			if(bmsStockHeader.getBmsStockId()==0) //while inserting----------
			{
				Date date = new Date();
				bmsStockHeader.setBmsStockDate(date);
			}
				
			bmsStockHeaderloc=bmsStockHeaderRepository.save(bmsStockHeader);
			int BmsHeaderId=bmsStockHeaderloc.getBmsStockId();
					
			for(int i=0;i<bmsStockHeader.getBmsStockDetailed().size();i++)
			{
				BmsStockDetailed bmsStockDetailed=bmsStockHeader.getBmsStockDetailed().get(i);
				bmsStockDetailed.setBmsStockId(BmsHeaderId);
				bmsStockDetailed=bmsStockDetailedRepository.save(bmsStockDetailed);
			}
			
			
		}catch(Exception e)
		{
			System.out.println("error while save stock "+e.getMessage());
		}
		return bmsStockHeaderloc;
		
	}

}
