package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.logistics.ServDetail;
import com.ats.webapi.model.logistics.ServHeader; 
import com.ats.webapi.repository.logistics.ServDetailRepository;
import com.ats.webapi.repository.logistics.ServHeaderRepository; 

@Service
public class ServHeaderServiceImpl implements ServHeaderService{
	
	@Autowired 
	ServHeaderRepository servHeaderRepository;
	
	@Autowired 
	ServDetailRepository servDetailRepository;

	@Override
	public ServHeader postServHeader(ServHeader servHeader) {
		ServHeader insertservHeader = new ServHeader();
		List<ServDetail> insertServDetail = new ArrayList<ServDetail>();
		 try
		 {
			 insertservHeader = servHeaderRepository.save(servHeader);
			 if(insertservHeader!=null)
			 {
				 for(int i=0;i<servHeader.getServDetail().size();i++)
					 servHeader.getServDetail().get(i).setServId(insertservHeader.getServId());
				 
				 insertServDetail = servDetailRepository.save(servHeader.getServDetail());
				 insertservHeader.setServDetail(insertServDetail);
					 
			 }
			 
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return insertservHeader;
	}

	@Override
	public List<ServHeader> getAllServHeader() {
		List<ServHeader> getAllServHeader = new ArrayList<ServHeader>();
		try {
			  
			getAllServHeader = servHeaderRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllServHeader.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllServHeader;
	}

	@Override
	public ServHeader getServHeaderAndDetailById(int servId) {
		ServHeader getServHeaderAndDetailById = new ServHeader();
		try {
			  
			getServHeaderAndDetailById = servHeaderRepository.findByServId(servId);
			
			List<ServDetail> servDetailList = new ArrayList<ServDetail>();
			
			servDetailList = servDetailRepository.findByServDetailId(servId);
			
			getServHeaderAndDetailById.setServDetail(servDetailList); 
			System.out.println(getServHeaderAndDetailById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getServHeaderAndDetailById;
	}

}
