package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.tray.GetTrayMgtHeader;
import com.ats.webapi.model.tray.GetTrayMgtHeaderForApp;

public interface GetTrayMgtHeaderForAppRepo extends JpaRepository<GetTrayMgtHeaderForApp, Integer>{
	
	@Query(value="SELECT\n" + 
			"    h.tran_id,\n" + 
			"    h.tran_date,\n" + 
			"    h.veh_id,\n" + 
			"    h.drv_id,\n" + 
			"    d.driver_name,\n" + 
			"    h.route_id,\n" + 
			"    r.route_name,\n" + 
			"    h.veh_no,\n" + 
			"    h.veh_outtime,\n" + 
			"    h.veh_intime,\n" + 
			"    h.veh_outkm,\n" + 
			"    h.veh_inkm,\n" + 
			"    h.veh_running_km,\n" + 
			"    h.diesel,\n" + 
			"    h.veh_status,\n" + 
			"    h.del_status,\n" + 
			"    0 as extra_tray_out,\n" + 
			"    0 as extra_tray_in,\n" + 
			"    h.veh_is_regular,\n" + 
			"    h.is_same_day, COALESCE(d.mobile1, '') AS mobile1,\r\n" + 
			"    COALESCE(d.mobile2, '') AS mobile2,\r\n" + 
			"    COALESCE(d.mobile3, '') AS mobile3 " + 
			"FROM\n" + 
			"    t_tray_mgt_header h,\n" + 
			"    m_logis_driver d,\n" + 
			"    m_fr_route r\n" + 
			"WHERE\n" + 
			"    h.del_status = 0 AND h.drv_id = d.driver_id AND h.route_id=r.route_id AND h.route_id = :routeId AND h.veh_status = 1",nativeQuery=true)
	List<GetTrayMgtHeaderForApp> getTrayMgtHeaderNewByRouteId(@Param("routeId")int routeId);


}
