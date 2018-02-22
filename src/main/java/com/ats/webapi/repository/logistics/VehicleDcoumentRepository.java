package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.VehicleDcoument;

public interface VehicleDcoumentRepository extends JpaRepository<VehicleDcoument, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE VehicleDcoument SET del_status=1 WHERE veh_doc_id=:vehDocId")
	int deleteVehicleDcoument(@Param("vehDocId")int vehDocId);

	List<VehicleDcoument> findByDelStatus(int delStatus);

	VehicleDcoument findByVehDocId(int vehDocId);

}
