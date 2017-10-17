package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetGrnGvnDetails;

public interface GetGrnGvnDetailsRepository extends JpaRepository<GetGrnGvnDetails, Integer> {
	
	
	@Query(value = "SELECT t_grn_gvn.* ,m_item.item_name,m_franchisee.fr_name FROM m_franchisee,"
			+ "m_item,t_grn_gvn WHERE t_grn_gvn.fr_id=m_franchisee.fr_id AND "
			+ "t_grn_gvn.item_id=m_item.id AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND  :toDate "
			+ "" + "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getAllGrnGvnDetails(@Param("fromDate") String fromDate ,@Param("toDate") String toDate);

	
}
