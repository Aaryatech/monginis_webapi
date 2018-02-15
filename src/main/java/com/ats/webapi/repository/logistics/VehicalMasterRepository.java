package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.VehicalMaster;

public interface VehicalMasterRepository  extends JpaRepository<VehicalMaster, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE VehicalMaster SET del_status=1 WHERE veh_id=:vehicalId")
	int deleteVehicalMaster(@Param("vehicalId")int vehicalId);

	List<VehicalMaster> findByDelStatus(int delStatus);

	VehicalMaster findByVehId(int vehicalId); 

}
