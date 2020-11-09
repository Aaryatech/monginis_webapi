package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.RouteFrBillDateAnalysis;

public interface RouteFrBillDateAnalysisRepo extends JpaRepository<RouteFrBillDateAnalysis, Integer> {
	
	@Query(value = " SELECT UUID() as unique_id,m_franchisee.fr_city, m_franchisee.fr_id,m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_route_id, " + 
			" t_bill_header.bill_date,sum(t_bill_header.grand_total) as grand_total " + 
			" FROM m_franchisee,t_bill_header,m_franchise_sup " + 
			" WHERE t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.del_status=0 AND t_bill_header.bill_date BETWEEN :fromDate AND "
			+ ":toDate  and m_franchise_sup.fr_id=m_franchisee.fr_id GROUP BY t_bill_header.bill_date,t_bill_header.fr_id ORDER BY "
			+ "  m_franchise_sup.no_in_route DESC " + 
			" ", nativeQuery = true)
	List<RouteFrBillDateAnalysis> getRouteFrBillDateAnalysisReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate);

}
