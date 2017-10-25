package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.UpdateGrnGvn;

public interface UpdateGrnGvnRepository extends JpaRepository<UpdateGrnGvn, Integer> {
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateGrnGvn  SET approvedLoginGate =:approvedLoginGate,"
			+ "approveimedDateTimeGate=:approveimedDateTimeGate,approvedRemarkGate=:approvedRemarkGate ,"
			+ "grnGvnStatus=:grnGvnStatus WHERE grnGvnId=:grnGvnId ")
		int updateGateGrn(@Param("approvedLoginGate") int approvedLoginGate,@Param("approveimedDateTimeGate") 
		String approveimedDateTimeGate,@Param("approvedRemarkGate") String approvedRemarkGate,@Param("grnGvnStatus") 
		int grnGvnStatus,@Param("grnGvnId") int grnGvnId);
	
	

}
