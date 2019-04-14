package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.FrNameIdByRouteId;

public interface FrNameIdByRouteIdRepository extends JpaRepository<FrNameIdByRouteId, Integer> {
	
	@Query(value="SELECT fr_name,m_franchisee.fr_id,  fr_route_id FROM m_franchisee,m_franchise_sup WHERE "
			+ "fr_route_id =:routeId and m_franchisee.fr_id=m_franchise_sup.fr_id order by no_in_route"
			+ "",nativeQuery=true)
	List<FrNameIdByRouteId> getFrNameIdByRouteId(@Param("routeId")int routeId);

}
