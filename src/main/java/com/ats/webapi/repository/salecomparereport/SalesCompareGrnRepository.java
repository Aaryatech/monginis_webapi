package com.ats.webapi.repository.salecomparereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.report.salecompare.SalesComparisonReport;
import com.ats.webapi.model.report.salecompare.SalesGrn;

@Repository
public interface SalesCompareGrnRepository extends JpaRepository<SalesGrn, Integer> {

	@Query(value = " SELECT UUID() as id,  MONTH(t_grn_gvn_header.grngvn_date) as month,monthname(t_grn_gvn_header.grngvn_date) as month_name,"
			+ " m_fr_route.route_name ,m_franchisee.fr_id, m_franchisee.fr_name,m_franchisee.fr_route_id,sum(t_grn_gvn_header.apr_grand_total) "
			+ "as bill_total FROM t_grn_gvn_header,m_franchisee,m_fr_route WHERE (SELECT month(t_grn_gvn_header.grngvn_date)=:monthNumber "
			+ "and year(t_grn_gvn_header.grngvn_date)=:year and t_grn_gvn_header.fr_id=m_franchisee.fr_id and m_fr_route.route_id=m_franchisee.fr_route_id ) AND"
			+ " t_grn_gvn_header.grngvn_status=6  " + "GROUP BY month,m_franchisee.fr_id " + "", nativeQuery = true)
	List<SalesGrn> getSalesReportComparisonGrnGvnTotal(@Param("monthNumber") int monthNumber, @Param("year") int year);

	@Query(value = " SELECT UUID() as id, a.month,a.month_name,a.route_name,a.fr_id,a.fr_name,a.fr_route_id,a.bill_total+coalesce((b.bill_total),0) as bill_total  from (SELECT\n" + 
			"        MONTH(t_grn_gvn_header.grngvn_date) as month,\n" + 
			"        monthname(t_grn_gvn_header.grngvn_date) as month_name,\n" + 
			"        m_fr_route.route_name ,\n" + 
			"        m_franchisee.fr_id,\n" + 
			"        m_franchisee.fr_name,\n" + 
			"        m_franchisee.fr_route_id,\n" + 
			"        sum((t_bill_detail.grand_total/t_bill_detail.bill_qty)*t_grn_gvn.grn_gvn_qty) as bill_total \n" + 
			"    FROM\n" + 
			"        t_grn_gvn_header,t_grn_gvn,t_bill_detail,\n" + 
			"        m_franchisee,\n" + 
			"        m_fr_route \n" + 
			"    WHERE\n" + 
			"      t_grn_gvn_header.grn_gvn_header_id= t_grn_gvn.grn_gvn_header_id and t_grn_gvn.bill_detail_no=t_bill_detail.bill_detail_no and\n" + 
			"                month(t_grn_gvn_header.grngvn_date)=:monthNumber\n" + 
			"                and year(t_grn_gvn_header.grngvn_date)=:year\n" + 
			"                and t_grn_gvn_header.fr_id=m_franchisee.fr_id \n" + 
			"                and m_fr_route.route_id=m_franchisee.fr_route_id \n" + 
			"       \n" + 
			"        And t_grn_gvn_header.is_grn=1\n" + 
			"        AND t_grn_gvn_header.grngvn_status=6   \n" + 
			"    GROUP BY\n" + 
			"        month,\n" + 
			"        m_franchisee.fr_id ) a LEFT JOIN ( SELECT\n" + 
			"        MONTH(t_grn_gvn_header.grngvn_date) as month,\n" + 
			"        t_grn_gvn_header.fr_id,\n" + 
			"        sum(t_grn_gvn_header.apr_grand_total) as bill_total \n" + 
			"    FROM\n" + 
			"        t_grn_gvn_header    WHERE\n" + 
			"      \n" + 
			"                month(t_grn_gvn_header.grngvn_date)=:monthNumber\n" + 
			"                and year(t_grn_gvn_header.grngvn_date)=:year\n" + 
			"\n" + 
			"        AND t_grn_gvn_header.is_grn in (0,2) \n" + 
			"        AND t_grn_gvn_header.grngvn_status=6   \n" + 
			"    GROUP BY\n" + 
			"        month,\n" + 
			"        t_grn_gvn_header.fr_id ) b on b.fr_id=a.fr_id and b.month=a.month", nativeQuery = true)
	List<SalesGrn> getSalesReportComparisonGrnGvnTotalForFr(@Param("monthNumber") int monthNumber,
			@Param("year") int year);

}
