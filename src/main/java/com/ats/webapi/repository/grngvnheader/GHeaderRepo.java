package com.ats.webapi.repository.grngvnheader;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvn.GHeader;

public interface GHeaderRepo extends JpaRepository<GHeader, Integer>{
	
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ "t_grn_gvn_header.grngvn_date, " + 
			" t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, " + 
			" m_franchisee.fr_name FROM t_grn_gvn_header,m_franchisee WHERE  " + 
			" t_grn_gvn_header.fr_id=m_franchisee.fr_id AND t_grn_gvn_header.grn_gvn_header_id "
			+ "IN (:grnGvnHeaderIdList) ORDER BY m_franchisee.fr_name ASC ",nativeQuery=true)
	List<GHeader> getGGHeaderByHeaderIdList(@Param("grnGvnHeaderIdList") List<String> grnGvnHeaderIdList);

}
