package com.ats.webapi.repository.prodapp.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.FrWiseSpCakeOrd;

public interface FrWiseSpCakeOrdRepo extends JpaRepository<FrWiseSpCakeOrd, Integer> {
	
	
	@Query(value = "SELECT t_sp_cake_sup.t_sp_cake_sup_no,m_franchisee.fr_name,m_franchisee.fr_code,\n" + 
			"m_sp_cake.sp_code,m_sp_cake.sp_name,t_sp_cake_sup.input_kg_fr,t_sp_cake_sup.input_kg_prod,\n" + 
			"(t_sp_cake_sup.input_kg_prod-t_sp_cake_sup.input_kg_fr) as weight_diff FROM t_sp_cake_sup,m_franchisee,m_sp_cake\n" + 
			"WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n" + 
			"AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id " + 
			"  ", nativeQuery = true)
	List<FrWiseSpCakeOrd> getFrWiseSpCakeOrd(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	

}
