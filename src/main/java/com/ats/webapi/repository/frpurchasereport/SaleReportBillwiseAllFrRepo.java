package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesReportBillwiseAllFr;
//report 7 sales
public interface SaleReportBillwiseAllFrRepo extends JpaRepository<SalesReportBillwiseAllFr, Integer>{
	
	@Query(value=" SELECT " + 
			"        t_bill_detail.bill_no," + 
			"        t_bill_header.bill_date," + 
			"        t_bill_header.invoice_no," + 
			"        t_bill_header.fr_id," + 
			"        t_bill_header.fr_code," + 
			"        m_franchisee.fr_name," + 
			"        m_franchisee.fr_city," + 
			"        m_franchisee.fr_gst_no," + 
			"        m_franchisee.is_same_state," + 
			"CASE WHEN t_bill_detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_hsncd  FROM m_spcake_sup " + 
			"									WHERE  m_spcake_sup.sp_id=t_bill_detail.item_id) " + 
			"									            ELSE (SELECT m_item_sup.item_hsncd FROM m_item_sup " + 
			"									 WHERE  m_item_sup.item_id=t_bill_detail.item_id)  " + 
			"									        END AS item_hsncd, " + 
		
			
			"CASE  WHEN t_bill_detail.cat_id=5 THEN (SELECT m_sp_cake.sp_name  FROM  m_sp_cake WHERE m_sp_cake.sp_id= t_bill_detail.item_id) ELSE (SELECT  m_item.item_name FROM m_item WHERE t_bill_detail.item_id=m_item.id)END AS item_name," + 
		
			
			"CASE  WHEN t_bill_detail.cat_id=5 THEN (SELECT COALESCE(m_sp_cake.sp_tax1,0)  FROM  m_sp_cake WHERE m_sp_cake.sp_id= t_bill_detail.item_id) ELSE (SELECT  COALESCE(m_item.item_tax1,0) FROM m_item WHERE t_bill_detail.item_id=m_item.id)END AS item_tax1," + 
			"CASE  WHEN t_bill_detail.cat_id=5 THEN (SELECT COALESCE(m_sp_cake.sp_tax2,0)  FROM  m_sp_cake WHERE m_sp_cake.sp_id= t_bill_detail.item_id) ELSE (SELECT  COALESCE(m_item.item_tax2,0) FROM m_item WHERE t_bill_detail.item_id=m_item.id)END AS item_tax2," + 
			
			"CASE  WHEN t_bill_detail.cat_id=5 THEN (SELECT COALESCE(m_sp_cake.sp_tax3,0)  FROM  m_sp_cake WHERE m_sp_cake.sp_id= t_bill_detail.item_id) ELSE (SELECT  COALESCE(m_item.item_tax3,0) FROM m_item WHERE t_bill_detail.item_id=m_item.id)END AS item_tax3," + 
		
			"        sum(t_bill_detail.sgst_rs) AS sgst_rs_sum," + 
			"        sum(t_bill_detail.cgst_rs) AS cgst_rs_sum," + 
			"        sum(t_bill_detail.igst_rs) AS igst_rs_sum, " +
			"sum(t_bill_detail.taxable_amt) AS taxable_amt_sum "+
			"    FROM " + 
			"        t_bill_header," + 
			"        t_bill_detail," + 
			"        m_franchisee" + 
			/*"        m_item," + 
			"        m_item_sup " + */
			"    WHERE " + 
			"        t_bill_header.bill_no=t_bill_detail.bill_no " + 
			"        AND t_bill_header.fr_id=m_franchisee.fr_id and t_bill_header.del_status=0 and  t_bill_header.del_status=0 " + 
		/*	"        AND m_item.id=m_item_sup.item_id " + 
			"        AND t_bill_detail.item_id=m_item.id " + */
			"        AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate " + 
			"    GROUP BY " + 
			"        t_bill_detail.bill_no" ,nativeQuery=true) 
			/*"        m_item_sup.item_hsncd"*/
		
		List<SalesReportBillwiseAllFr> getSaleReportBillwiseAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
