package com.ats.webapi.service;

public interface UpdateGrnGvnService {
	
	public int updateGrnForGate( int approvedLoginGate,String approveimedDateTimeGate,
			String approvedRemarkGate,int grnGvnStatus,int grnGvnId);


}
