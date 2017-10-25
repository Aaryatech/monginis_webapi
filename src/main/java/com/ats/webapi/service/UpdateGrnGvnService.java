package com.ats.webapi.service;

public interface UpdateGrnGvnService {
	
	public int updateGrnForGate( int approvedLoginGate,String approveimedDateTimeGate,
			String approvedRemarkGate,String grnGvnStatus,int grnGvnId);


}
