package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.CrnSalesReportDateWise;

public interface CrnSalesReportDateWiseRepo extends JpaRepository<CrnSalesReportDateWise, Integer> {
	
	@Query(value="SELECT\n" + 
			"        UUID() AS uid,\n" + 
			"        crn.crn_date,\n" + 
			"        'NA' AS month_name,\n" + 
			"        crn.fr_id,\n" + 
			"        crn.crn_taxable_amt,\n" + 
			"        crn.crn_total_tax,\n" + 
			"        crn.crn_grand_total,\n" + 
			"        f.fr_name AS fr_name,\n" + 
			"        f.fr_code AS fr_code, crn.crn_no \n" + 
			"    FROM\n" + 
			"        t_credit_note_header crn,\n" + 
			"        m_franchisee f \n" + 
			"    WHERE\n" + 
			"        crn.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND crn.fr_id = f.fr_id \n" + 
			"        AND f.fr_id IN (:frIdList)\n" + 
			"        ORDER BY crn_date DESC", nativeQuery=true)
	List<CrnSalesReportDateWise> getCnsoldatdCrnSalesReport(@Param("frIdList") List<String> frIdList, @Param("fromDate") String fromDate, 
			@Param("toDate") String toDate);
	
	
	@Query(value="SELECT\n" + 
			"        UUID() AS uid,\n" + 
			"        crn.crn_date,\n" + 
			"        'NA' AS month_name,\n" + 
			"        crn.fr_id,\n" + 
			"        crn.crn_taxable_amt,\n" + 
			"        crn.crn_total_tax,\n" + 
			"        crn.crn_grand_total,\n" + 
			"        f.fr_name AS fr_name,\n" + 
			"        f.fr_code AS fr_code, crn.crn_no \n" + 
			"    FROM\n" + 
			"        t_credit_note_header crn,\n" + 
			"        m_franchisee f \n" + 
			"    WHERE\n" + 
			"        crn.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND crn.fr_id = f.fr_id \n" + 
			"        ORDER BY crn_date DESC", nativeQuery=true)
	List<CrnSalesReportDateWise> getCnsoldatdCrnSalesReportAllFr(@Param("fromDate") String fromDate, 
			@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"    UUID() AS uid, crn.crn_date, 'NA' AS month_name, crn.fr_id, SUM(crn.crn_taxable_amt) AS crn_taxable_amt,\n" + 
			"    SUM(crn.crn_total_tax) AS crn_total_tax,\n" + 
			"    SUM(crn.crn_grand_total) AS crn_grand_total,\n" + 
			"    f.fr_name,\n" + 
			"    f.fr_code, 0 AS crn_no\n" + 
			"FROM\n" + 
			"    t_credit_note_header crn,\n" + 
			"    m_franchisee f\n" + 
			"WHERE\n" + 
			"    crn.crn_date BETWEEN :fromDate AND :toDate AND crn.fr_id = f.fr_id AND f.fr_id IN (:frIdList)\n" + 
			"GROUP BY\n" + 
			"    crn.crn_date\n" + 
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
			"    f.fr_code, 0 AS crn_no\n" + 
			"FROM\n" + 
			"    t_credit_note_header crn,\n" + 
			"    m_franchisee f\n" + 
			"WHERE\n" + 
			"    crn.crn_date BETWEEN :fromDate AND :toDate AND crn.fr_id = f.fr_id\n" + 
			"GROUP BY\n" + 
			"    crn.crn_date\n" + 
			"ORDER BY\n" + 
			"    crn.crn_date\n" + 
			"DESC", nativeQuery=true)
	List<CrnSalesReportDateWise> getCrnSalesDateReportAllFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate);	
	
	
	@Query(value="SELECT\n" + 
			"        UUID() AS uid,\n" + 
			"        MONTHNAME(crn.crn_date) AS month_name,\n" + 
			"        SUM(crn.crn_taxable_amt) AS crn_taxable_amt,\n" + 
			"        SUM(crn.crn_total_tax) AS crn_total_tax,\n" + 
			"        SUM(crn.crn_grand_total) AS crn_grand_total,\n" + 
			"        YEAR(crn.crn_date) AS fr_name, 'NA' AS fr_code, 0 AS fr_id, crn.crn_date, 0 AS crn_no\n" + 
			"    FROM\n" + 
			"        t_credit_note_header crn\n" + 
			"    WHERE\n" + 
			"        crn.crn_date BETWEEN :fromDate AND :toDate \n" +
			"        AND crn.fr_id IN (:frIdList) \n" + 
			"    GROUP BY\n" + 
			"   	 YEAR(crn.crn_date),\n" + 
			"        MONTH(crn.crn_date)             \n" + 
			"    ORDER BY\n" + 
			"    	 YEAR(crn.crn_date) Desc,\n" + 
			"        MONTH(crn.crn_date) Desc",nativeQuery=true)
	List<CrnSalesReportDateWise> getCrnSalesMonthReport(@Param("frIdList") List<String> frIdList, @Param("fromDate") String fromDate, 
			@Param("toDate") String toDate);
	

	@Query(value="SELECT\n" + 
			"        UUID() AS uid,\n" + 
			"        MONTHNAME(crn.crn_date) AS month_name,\n" + 
			"        SUM(crn.crn_taxable_amt) AS crn_taxable_amt,\n" + 
			"        SUM(crn.crn_total_tax) AS crn_total_tax,\n" + 
			"        SUM(crn.crn_grand_total) AS crn_grand_total,\n" + 
			"        YEAR(crn.crn_date) AS fr_name,\n" + 
			"        'NA' AS fr_code,\n" + 
			"        0 AS fr_id,\n" + 
			"        crn.crn_date,\n" + 
			"        0 AS crn_no     \n" + 
			"    FROM\n" + 
			"        t_credit_note_header crn     \n" + 
			"    WHERE\n" + 
			"        crn.crn_date BETWEEN :fromDate AND :toDate\n" + 
			"    GROUP BY\n" + 
			"   	 YEAR(crn.crn_date),\n" + 
			"        MONTH(crn.crn_date)             \n" + 
			"    ORDER BY\n" + 
			"    	 YEAR(crn.crn_date) Desc,\n" + 
			"        MONTH(crn.crn_date) Desc", nativeQuery=true)
	List<CrnSalesReportDateWise> getCrnSalesMonthReportAllFr(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	
}
