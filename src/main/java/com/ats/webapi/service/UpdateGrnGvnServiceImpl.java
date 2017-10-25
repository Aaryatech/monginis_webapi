package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.repository.UpdateGrnGvnRepository;

@Service
public class UpdateGrnGvnServiceImpl implements  UpdateGrnGvnService {
	
	@Autowired
	UpdateGrnGvnRepository updateGrnGvnRepository;

	@Override
	public int updateGrnForGate(int approvedLoginGate, String approveimedDateTimeGate, String approvedRemarkGate,
			int grnGvnStatus, int grnGvnId) {
		
		int i=updateGrnGvnRepository.updateGateGrn(approvedLoginGate, approveimedDateTimeGate, approvedRemarkGate, grnGvnStatus, grnGvnId);
		
		
		
		return i;
	}
	
	
	
	

}
