package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.CrnSalesReportDateWise;

public interface CrnSalesReportDateWiseRepo extends JpaRepository<CrnSalesReportDateWise, Integer> {

	@Query(value="SELECT\n" + 
			"    UUID() AS uid, crn.crn_date, 'NA' AS month_name, crn.fr_id, SUM(crn.crn_taxable_amt) AS crn_taxable_amt,\n" + 
			"    SUM(crn.crn_total_tax) AS crn_total_tax,\n" + 
			"    SUM(crn.crn_grand_total) AS crn_grand_total,\n" + 
			"    f.fr_name,\n" + 
			"    f.fr_code\n" + 
			"FROM\n" + 
			"    t_credit_note_header crn,\n" + 
			"    m_franchisee f\n" + 
			"WHERE\n" + 
			"    crn.crn_date BETWEEN :fromDate AND :toDate AND crn.fr_id = f.fr_id AND f.fr_id IN (:frIdList)\n" + 
			"GROUP BY\n" + 
			"    crn.crn_date, f.fr_id\n" + 
			"ORDER BY\n" + 
			"    crn.crn_date\n" + 
			"DESC", nativeQuery=true)
	List<CrnSalesReportDateWise> getCrnSalesDateReport(@Param("frIdList") List<String> frIdList, @Param("fromDate") String fromDate, 
			@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"    UUID() AS uid, crn.crn_date,'NA' AS month_name, crn.fr_id, SUM(crn.crn_taxable_amt) AS crn_taxable_amt,\n" + 
			"    SUM(crn.crn_total_tax) AS crn_total_tax,\n" + 
			"    SUM(crn.crn_grand_total) AS crn_grand_total,\n" + 
			"    f.fr_name,\n" + 
			"    f.fr_code\n" + 
			"FROM\n" + 
			"    t_credit_note_header crn,\n" + 
			"    m_franchisee f\n" + 
			"WHERE\n" + 
			"    crn.crn_date BETWEEN :fromDate AND :toDate AND crn.fr_id = f.fr_id\n" + 
			"GROUP BY\n" + 
			"    crn.crn_date, f.fr_id\n" + 
			"ORDER BY\n" + 
			"    crn.crn_date\n" + 
			"DESC", nativeQuery=true)
	List<CrnSalesReportDateWise> getCrnSalesDateReportAllFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate);	
	
	
	@Query(value="SELECT\n" + 
			"        UUID() AS uid,\n" + 
			"        MONTHNAME(crn.crn_date) AS month_name, crn.crn_date ,\n" + 
			"        crn.fr_id,\n" + 
			"        SUM(crn.crn_taxable_amt) AS crn_taxable_amt,\n" + 
			"        SUM(crn.crn_total_tax) AS crn_total_tax,\n" + 
			"        SUM(crn.crn_grand_total) AS crn_grand_total,\n" + 
			"        f.fr_name,\n" + 
			"        f.fr_code \n" + 
			"    FROM\n" + 
			"        t_credit_note_header crn,\n" + 
			"        m_franchisee f \n" + 
			"    WHERE\n" + 
			"        MONTH(crn.crn_date) BETWEEN MONTH(:fromDate) AND MONTH(:toDate) AND\n" + 
			"        YEAR(crn.crn_date) BETWEEN YEAR(:fromDate) AND YEAR(:toDate) \n" + 
			"        AND crn.fr_id = f.fr_id \n" + 
			"        AND f.fr_id IN (:frIdList) \n" + 
			"    GROUP BY\n" + 
			"        MONTH(crn.crn_date), YEAR(crn.crn_date), f.fr_id\n" + 
			"    ORDER BY\n" + 
			"        crn.crn_date DESC",nativeQuery=true)
	List<CrnSalesReportDateWise> getCrnSalesMonthReport(@Param("frIdList") List<String> frIdList, @Param("fromDate") String fromDate, 
			@Param("toDate") String toDate);
	

	@Query(value="SELECT\n" + 
			"        UUID() AS uid,\n" + 
			"        MONTHNAME(crn.crn_date) AS month_name,\n" + 
			"        crn.crn_date AS crn_date,\n" + 
			"        crn.fr_id,\n" + 
			"        SUM(crn.crn_taxable_amt) AS crn_taxable_amt,\n" + 
			"        SUM(crn.crn_total_tax) AS crn_total_tax,\n" + 
			"        SUM(crn.crn_grand_total) AS crn_grand_total,\n" + 
			"        f.fr_name,\n" + 
			"        f.fr_code \n" + 
			"    FROM\n" + 
			"        t_credit_note_header crn,\n" + 
			"        m_franchisee f \n" + 
			"    WHERE\n" + 
			"        MONTH(crn.crn_date) BETWEEN MONTH(:fromDate) AND MONTH(:toDate) AND\n" + 
			"        YEAR(crn.crn_date) BETWEEN YEAR(:fromDate) AND YEAR(:toDate) \n" + 
			"        AND crn.fr_id = f.fr_id \n" + 
			"    GROUP BY\n" + 
			"        MONTH(crn.crn_date), YEAR(crn.crn_date), f.fr_id\n" + 
			"    ORDER BY\n" + 
			"        crn.crn_date DESC", nativeQuery=true)
	List<CrnSalesReportDateWise> getCrnSalesMonthReportAllFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
