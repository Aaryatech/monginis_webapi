package com.ats.webapi.repository.prodapp.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.RoutewiseLastCakeEndTime;

public interface RoutewiseLastCakeEndTimeRepo extends JpaRepository<RoutewiseLastCakeEndTime, Integer> {
	
	@Query(value = " SELECT m_fr_route.route_id,m_fr_route.route_name,m_fr_route.route_seq_no,"
			+ " COALESCE(( SELECT MAX(t_sp_cake_sup.end_time_stamp) FROM t_sp_cake_sup,m_franchisee WHERE "
			+ " t_sp_cake_sup.date=:prodDate AND\n"
			+ " t_sp_cake_sup.fr_id=m_franchisee.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id "
			+ " ),0)AS last_sp_end_time,"
			+ " COALESCE(( SELECT MAX(t_reg_sp_cake_sup.end_time) FROM t_reg_sp_cake_sup,m_franchisee WHERE "
			+ " t_reg_sp_cake_sup.prod_date=:prodDate AND "
			+ " t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id"
			+ " ),0)AS last_reg_sp_end_time "
			+ " FROM m_fr_route WHERE m_fr_route.del_status=0 ", nativeQuery = true)

	List<RoutewiseLastCakeEndTime> getRoutewiseLastCakeEndTime(@Param("prodDate") String prodDate);
	

}
