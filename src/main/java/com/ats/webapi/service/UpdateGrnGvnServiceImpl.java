package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.repository.UpdateGrnGvnRepository;

@Service
public class UpdateGrnGvnServiceImpl implements  UpdateGrnGvnService {
	
	@Autowired
	UpdateGrnGvnRepository updateGrnGvnRepository;

	@Override
	public int updateGrnForGate(int approvedLoginGate, String approveimedDateTimeGate, String approvedRemarkGate,
			int grnGvnStatus, List<Integer> grnGvnId) {
		
		int i=updateGrnGvnRepository.updateGateGrn(approvedLoginGate, approveimedDateTimeGate, approvedRemarkGate, grnGvnStatus, grnGvnId);
		
		
		
		return i;
	}

	@Override
	public int updateGrnForAcc(int approvedLoginAcc, String approvedDateTimeAcc, String approvedRemarkAcc,
			int grnGvnStatus, List<Integer> grnGvnId) {

		int i=updateGrnGvnRepository.updateAccGrn(approvedLoginAcc, approvedDateTimeAcc, approvedRemarkAcc, grnGvnStatus, grnGvnId);
		
		
		return i;
	}

	@Override
	public int updateGrnGvnForStore(int approvedLoginStore, String approvedDateTimeStore, String approvedRemarkStore,
			int grnGvnStatus, List<Integer> grnGvnId) {
		
		int i=updateGrnGvnRepository.updateStoreGvn(approvedLoginStore, approvedDateTimeStore, approvedRemarkStore, grnGvnStatus, grnGvnId);
				
				return i;
		
	}
	
	
	
	

}
