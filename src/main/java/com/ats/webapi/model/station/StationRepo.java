package com.ats.webapi.model.station;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StationRepo extends JpaRepository<Station, Integer> {

	List<Station> findByDelStatus(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Station SET del_status=:delStatus WHERE station_id=:stationId")
	int delteStation(@Param("stationId") int stationId, @Param("delStatus") int delStatus);
	
	@Query(value="select station_id,station_no,m_station.item_id,m_station.del_status,m_station.is_used,SUM(t_order.order_qty) As ex_int1,ex_int2,ex_var1,ex_var2  from t_order 	join m_station 	on find_in_set(t_order.item_id, m_station.item_id) 	where t_order.delivery_date=:BillDate AND m_station.del_status=0 GROUP BY m_station.station_id",nativeQuery=true)
	List<Station> stationOrdercount(@Param("BillDate") String BillDate);

	Station findByStationIdAndDelStatus(int stationId, int i);

}
