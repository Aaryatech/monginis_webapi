package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.spprod.GetSpAdvTaxReport;

public interface GetSpAdvTaxReporRepo extends JpaRepository<GetSpAdvTaxReport, Integer> {
	

	/*@Query(value="SELECT tsp.sp_order_no,tsp.sp_book_for_mob_no as invoice_no,tsp.tax_1 AS tax1,tsp.tax_2 AS tax2,tsp.tax_1_amt AS tax1Amt,tsp.tax_2_amt AS tax2Amt,"
			+ " tsp.sp_grand_total as total,tsp.sp_delivery_date as del_date," + 
			" tsp.sp_advance,tsp.rm_amount,tsp.sp_grand_total, ((tsp.sp_grand_total*100)/(100+tsp.tax_1+tsp.tax_2)) as base_mrp,msp.sp_name,spsup.sp_hsncd " + 
			" FROM t_sp_cake tsp,m_sp_cake msp,m_spcake_sup spsup " + 
			" WHERE tsp.sp_delivery_date BETWEEN :fromDate AND :toDate AND tsp.fr_id=:frId" + 
			"	AND tsp.sp_id=msp.sp_id AND spsup.sp_id=tsp.sp_id AND " + 
			" tsp.del_status=0 "
			,nativeQuery=true)
	List<GetSpAdvTaxReport> getSpAdTaxReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);*/
	
	
	//Anmol -------16-09-2019
	@Query(value="SELECT\n" + 
			"    tsp.sp_order_no,\n" + 
			"    tsp.sp_book_for_mob_no AS invoice_no,\n" + 
			"    tsp.tax_1 AS tax1,\n" + 
			"    tsp.tax_2 AS tax2,\n" + 
			"    tsp.tax_1_amt AS tax1Amt,\n" + 
			"    tsp.tax_2_amt AS tax2Amt,\n" + 
			"    tsp.sp_grand_total AS total,\n" + 
			"    tsp.sp_delivery_date AS del_date,\n" + 
			"    tsp.sp_advance,\n" + 
			"    tsp.rm_amount,\n" + 
			"    tsp.sp_grand_total,\n" + 
			"    (\n" + 
			"        (tsp.sp_grand_total * 100) /(100 + tsp.tax_1 + tsp.tax_2)\n" + 
			"    ) AS base_mrp,\n" + 
			"    CASE WHEN tsp.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN(\n" + 
			"    SELECT\n" + 
			"        sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_id = tsp.sp_id\n" + 
			") ELSE SUBSTRING_INDEX(tsp.item_id, '#', -1)\n" + 
			"END AS sp_name,\n" + 
			"CASE WHEN tsp.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN(\n" + 
			"    SELECT\n" + 
			"        sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = tsp.sp_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = tsp.sp_id\n" + 
			")\n" + 
			"END AS sp_hsncd\n" + 
			"FROM\n" + 
			"    t_sp_cake tsp\n" + 
			"WHERE\n" + 
			"    tsp.sp_delivery_date BETWEEN :fromDate AND :toDate AND tsp.fr_id = :frId AND tsp.del_status = 0\n" + 
			"ORDER BY\n" + 
			"    tsp.sp_order_no "
			,nativeQuery=true)
	List<GetSpAdvTaxReport> getSpAdTaxReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);
	

}
