package com.ats.webapi.repository.salecomparereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.salecompare.SalesComparisonReport;

public interface SalesComparisonReportRepo extends JpaRepository<SalesComparisonReport, Integer> {

	@Query(value=" SELECT MONTH(t_bill_header.bill_date) as month,MONTHNAME(t_bill_header.bill_date) as month_name, m_fr_route.route_name ,m_franchisee.fr_id, m_franchisee.fr_name"
			+ ",m_franchisee.fr_route_id,SUM(t_bill_header.grand_total) AS bill_total FROM `t_bill_header`,m_franchisee,"
			+ "m_fr_route WHERE (SELECT month(bill_date) =:monthNumber and m_franchisee.fr_id =t_bill_header.fr_id and "
			+ "m_fr_route.route_id=m_franchisee.fr_route_id) GROUP BY month,m_franchisee.fr_id ",nativeQuery=true)
	List<SalesComparisonReport> getSalesReportComparisonBillTotal(@Param("monthNumber")int monthNumber);
	
	@Query(value=" SELECT MONTH(t_grn_gvn_header.grngvn_date) as month,monthname(t_grn_gvn_header.grngvn_date) as month_name,"
			+ " m_fr_route.route_name ,m_franchisee.fr_id, m_franchisee.fr_name,m_franchisee.fr_route_id,sum(t_grn_gvn_header.apr_grand_total) "
			+ "as bill_total FROM t_grn_gvn_header,m_franchisee,m_fr_route WHERE (SELECT month(t_grn_gvn_header.grngvn_date)=:monthNumber "
			+ "and t_grn_gvn_header.fr_id=m_franchisee.fr_id and m_fr_route.route_id=m_franchisee.fr_route_id ) "
			+ "GROUP BY month,m_franchisee.fr_id " + 
			"",nativeQuery=true)
	List<SalesComparisonReport> getSalesReportComparisonGrnGvnTotal(@Param("monthNumber")int monthNumber);

}
