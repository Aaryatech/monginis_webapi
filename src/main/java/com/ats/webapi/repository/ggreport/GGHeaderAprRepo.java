package com.ats.webapi.repository.ggreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.grngvnreport.GGHeaderApr;

@Service
public interface GGHeaderAprRepo extends JpaRepository<GGHeaderApr, Integer> {
	
	
	@Query(value=" SELECT " + 
			"        t_grn_gvn_header.grn_gvn_header_id, " + 
			"        t_grn_gvn_header.grngvn_srno, " + 
			"        t_grn_gvn_header.grngvn_date, " + 
			"        t_grn_gvn_header.is_grn, " + 
			"        t_grn_gvn_header.fr_id, " + 
			"        t_grn_gvn_header.apr_grand_total, " + 
			"        t_grn_gvn_header.total_amt , " + 
			"        t_grn_gvn_header.grngvn_status, " + 
			" CAST(t_grn_gvn_header.approved_datetime AS CHAR) as approved_datetime, " + 
			"         m_franchisee.fr_name " + 
			"          from " + 
			"        t_grn_gvn_header, " + 
			"         m_franchisee   " + 
			"    WHERE " + 
			"        m_franchisee.fr_id=t_grn_gvn_header.fr_id   " + 
			"        AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and  :toDate " + 
			"        AND t_grn_gvn_header.is_grn IN ( :isGrn" + 
			"           " + 
			"        )  and t_grn_gvn_header.fr_id IN (:frIdList) " + 
			" ",nativeQuery=true)
	
		List<GGHeaderApr> getGGHeaderAprReportSelecFr(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate,@Param("frIdList") List<String> frIdList,@Param("isGrn") List<String> isGrn);
	
	
	@Query(value=" SELECT " + 
			"        t_grn_gvn_header.grn_gvn_header_id, " + 
			"        t_grn_gvn_header.grngvn_srno, " + 
			"        t_grn_gvn_header.grngvn_date, " + 
			"        t_grn_gvn_header.is_grn, " + 
			"        t_grn_gvn_header.fr_id, " + 
			"        t_grn_gvn_header.apr_grand_total, " + 
			"        t_grn_gvn_header.total_amt , " + 
			"        t_grn_gvn_header.grngvn_status, " + 
			" CAST(t_grn_gvn_header.approved_datetime AS CHAR) as approved_datetime, " + 
			"         m_franchisee.fr_name " + 
			"          from " + 
			"        t_grn_gvn_header, " + 
			"         m_franchisee   " + 
			"    WHERE " + 
			"        m_franchisee.fr_id=t_grn_gvn_header.fr_id   " + 
			"        AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and  :toDate " + 
			"        AND t_grn_gvn_header.is_grn IN ( :isGrn" + 
			"           " + 
			"        ) ORDER By m_franchisee.fr_name ASC   " + 
			" ",nativeQuery=true)
	
		List<GGHeaderApr> getGGHeaderAprReportAllFr(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate, @Param("isGrn") List<String> isGrn);
	
	@Query(value="SELECT " + 
			"        GROUP_CONCAT(t_grn_gvn_header.grn_gvn_header_id)          \n" + 
			"    from " + 
			"        t_grn_gvn_header               \n" + 
			"    WHERE " + 
			"         t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate   and  " + 
			"          t_grn_gvn_header.is_grn IN (:isGrn)  " + 
			"    ORDER By " + 
			"        t_grn_gvn_header.fr_id ASC  " + 
			" ",nativeQuery=true)
	
		List<String> getCommasepHeaderIds(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate, @Param("isGrn") List<String> isGrn);
	
	
	
}
