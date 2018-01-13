package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesReportBillwiseAllFr;
//report 7 sales
public interface SaleReportBillwiseAllFrRepo extends JpaRepository<SalesReportBillwiseAllFr, Integer>{
	
	@Query(value=" SELECT t_bill_detail.bill_no,t_bill_header.bill_date,t_bill_header.invoice_no,t_bill_header.fr_id," + 
			"t_bill_header.fr_code, m_franchisee.fr_name,m_franchisee.fr_city,m_franchisee.fr_gst_no,m_franchisee.is_same_state,m_item_sup.item_hsncd " + 
			",m_item.item_tax1,m_item.item_tax2,m_item. item_tax3,m_item.item_name,sum(t_bill_detail.taxable_amt) AS taxable_amt_sum," + 
			"sum(t_bill_detail.sgst_rs) AS sgst_rs_sum,sum(t_bill_detail.cgst_rs) AS cgst_rs_sum,sum(t_bill_detail.igst_rs) AS igst_rs_sum " + 
			"FROM t_bill_header,t_bill_detail,m_franchisee,m_item,m_item_sup " + 
			"WHERE t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_header.fr_id=m_franchisee.fr_id " + 
			"AND m_item.id=m_item_sup.item_id AND t_bill_detail.item_id=m_item.id AND t_bill_header.bill_date " + 
			"BETWEEN :fromDate AND :toDate GROUP BY t_bill_detail.bill_no, m_item_sup.item_hsncd",nativeQuery=true)
		
		List<SalesReportBillwiseAllFr> getSaleReportBillwiseAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
