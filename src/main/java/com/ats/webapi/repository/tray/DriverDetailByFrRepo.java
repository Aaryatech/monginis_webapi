package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.tray.DriverDetailByFr;


public interface DriverDetailByFrRepo  extends JpaRepository<DriverDetailByFr, Integer> {
	
	@Query(value="SELECT h.tran_id, h.tran_date, h.veh_id, h.veh_no, h.drv_id, dv.driver_name, dv.mobile1, dv.mobile2 FROM t_tray_mgt_header h, t_tray_mgt_detail d, m_logis_driver dv WHERE h.del_status = 0 AND d.del_status = 0 AND h.tran_id = d.tran_id AND d.fr_id = :frId AND h.drv_id=dv.driver_id AND h.tran_date=:currDate  ",nativeQuery=true)
	List<DriverDetailByFr> getDriverInfo(@Param("frId") int frId,@Param("currDate") String currDate);

}