package com.ats.webapi.service;

public interface UpdateGrnGvnService {
	
	public int updateGrnForGate( int approvedLoginGate,String approveimedDateTimeGate,
			String approvedRemarkGate,int grnGvnStatus,int grnGvnId);


	public int updateGrnForAcc( int approvedLoginAcc,String grnApprovedDateTimeAcc,
			String approvedRemarkAcc,int grnGvnStatus,int grnGvnId);

	
	public int updateGrnGvnForStore( int approvedLoginStore,String approvedDateTimeStore,
			String approvedRemarkStore,int grnGvnStatus,int grnGvnId);

	
	
}
