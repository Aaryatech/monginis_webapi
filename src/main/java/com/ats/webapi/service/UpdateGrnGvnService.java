package com.ats.webapi.service;

import java.util.List;

public interface UpdateGrnGvnService {
	
	public int updateGrnForGate( int approvedLoginGate,String approveimedDateTimeGate,
			String approvedRemarkGate,int grnGvnStatus,List<Integer> grnGvnId);


	public int updateGrnForAcc( int approvedLoginAcc,String approvedDateTimeAcc,
			String approvedRemarkAcc,int grnGvnStatus,List<Integer> grnGvnId);

	
	public int updateGrnGvnForStore( int approvedLoginStore,String approvedDateTimeStore,
			String approvedRemarkStore,int grnGvnStatus,List<Integer> grnGvnId);

	
	
}
