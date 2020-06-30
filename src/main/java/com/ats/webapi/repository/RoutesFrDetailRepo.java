package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.RoutesFrDetail;

public interface RoutesFrDetailRepo extends JpaRepository<RoutesFrDetail, Integer> {

	@Query(value="SELECT\n" + 
			"	route.route_id,\n" + 
			"    route.route_name,\n" + 
			"    route.route_seq_no,\n" + 
			"    GROUP_CONCAT(fr.fr_id) AS fr_ids,\n" + 
			"    GROUP_CONCAT(fr.fr_name) AS fr_names,\n" + 
			"    GROUP_CONCAT(fr.fr_code)AS fr_codes\n" + 
			"    \n" + 
			"FROM\n" + 
			"    m_fr_route route,\n" + 
			"    m_franchisee fr\n" + 
			"WHERE\n" + 
			"   	route.del_status=0 AND\n" + 
			"    route.route_id=fr.fr_route_id AND \n" + 
			"    \n" + 
			"    fr.del_status=0\n" + 
			"GROUP BY fr.fr_route_id \n" + 
			"ORDER BY route.route_seq_no DESC",nativeQuery=true)
	List<RoutesFrDetail> getRouteFrDetails();

}
