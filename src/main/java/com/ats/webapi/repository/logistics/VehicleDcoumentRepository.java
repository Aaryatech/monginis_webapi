package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.AlertAmcRecord;
import com.ats.webapi.model.logistics.VehicleDcoument;

public interface VehicleDcoumentRepository extends JpaRepository<VehicleDcoument, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE VehicleDcoument SET del_status=1 WHERE veh_doc_id=:vehDocId")
	int deleteVehicleDcoument(@Param("vehDocId") int vehDocId);

	@Query(value="SELECT\r\n" + 
			"    m_logis_veh_doc.*\r\n" + 
			"FROM\r\n" + 
			"    m_logis_veh_doc,\r\n" + 
			"    m_logis_vehical\r\n" + 
			"WHERE\r\n" + 
			"    m_logis_veh_doc.veh_id = m_logis_vehical.veh_id AND m_logis_veh_doc.del_status=:delStatus AND m_logis_vehical.del_status = :delStatus", nativeQuery=true)
	List<VehicleDcoument> findByVehDocDelStatus(@Param("delStatus") int delStatus);
	
	List<VehicleDcoument> findByDelStatus(int delStatus);

	VehicleDcoument findByVehDocId(int vehDocId);

	
	@Query(value="select veh_doc_id, veh_id, doc_id, entry_date, doc_date, doc_expire_date, doc_exp_notification_date, doc_path, "
			+ "current_km, del_status, DATEDIFF(doc_expire_date, :today) AS remaining_day from m_logis_veh_doc"
			+ " where ( doc_expire_date >= :today and doc_exp_notification_date <= :today ) "
			+ "or doc_exp_notification_date < :today",nativeQuery=true) 
	List<VehicleDcoument> getAlertDocumentRecord(@Param("today")String today);
	
	
	
	@Query(value="SELECT\r\n" + 
			"    d.veh_doc_id,\r\n" + 
			"    d.veh_id,\r\n" + 
			"    d.doc_id,\r\n" + 
			"    d.entry_date,\r\n" + 
			"    d.doc_date,\r\n" + 
			"    d.doc_expire_date,\r\n" + 
			"    d.doc_exp_notification_date,\r\n" + 
			"    d.doc_path,\r\n" + 
			"    d.current_km,\r\n" + 
			"    d.del_status,\r\n" + 
			"    DATEDIFF(d.doc_expire_date, :today) AS remaining_day\r\n" + 
			"FROM\r\n" + 
			"    m_logis_veh_doc d,\r\n" + 
			"    m_logis_vehical v\r\n" + 
			"WHERE\r\n" + 
			"    d.veh_id = v.veh_id AND v.del_status = 0 AND(\r\n" + 
			"        d.doc_expire_date >= :today AND d.doc_exp_notification_date <= :today\r\n" + 
			"    ) OR d.doc_exp_notification_date < :today AND v.del_status = 0 AND FIND_IN_SET(v.veh_id, d.veh_id)", nativeQuery=true)
	List<VehicleDcoument> getAvailAlertDocumentRecord(@Param("today")String today);

}
