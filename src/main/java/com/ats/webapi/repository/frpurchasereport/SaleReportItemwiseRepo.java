package com.ats.webapi.repository.frpurchasereport;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.report.frpurchase.SalesReportItemwise;
//sales report no 8
public interface SaleReportItemwiseRepo extends JpaRepository<SalesReportItemwise, Integer> {

	@Query(value=" select a.id,round(coalesce(b.taxable_amt_sum,0),2) as taxable_amt_sum,round(coalesce(b.sgst_rs_sum,0),2) as sgst_rs_sum,round(coalesce(b.cgst_rs_sum,0),2) as cgst_rs_sum,round(coalesce(b.igst_rs_sum,0),2) as igst_rs_sum,round(coalesce(b.bill_qty_sum,0),2) as bill_qty_sum,a.item_tax1,a.item_tax2,a.item_tax3,a.item_name,coalesce(c.item_hsncd,'-') as  item_hsncd \n" + 
			"from\n" + 
			"(SELECT m_item.id, m_item.item_tax1, m_item.item_tax2, m_item. item_tax3, m_item.item_name FROM m_item ) a \n" + 
			"left join\n" + 
			"(SELECT t_bill_detail.item_id,sum(t_bill_detail.taxable_amt) AS taxable_amt_sum , sum(t_bill_detail.sgst_rs) AS sgst_rs_sum, sum(t_bill_detail.cgst_rs) AS cgst_rs_sum, sum(t_bill_detail.igst_rs) AS igst_rs_sum, SUM(t_bill_detail.bill_qty) AS bill_qty_sum FROM t_bill_header, t_bill_detail WHERE t_bill_header.bill_no=t_bill_detail.bill_no  AND t_bill_header.del_status=0 and t_bill_detail.del_status=0  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate GROUP BY t_bill_detail.item_id) b\n" + 
			"on a.id=b.item_id left join \n" + 
			"(SELECT m_item_sup.item_id,  m_item_sup.item_hsncd FROM m_item_sup WHERE m_item_sup.del_status=0) c on a.id=c.item_id where b.bill_qty_sum>0 ",nativeQuery=true)
		
		List<SalesReportItemwise> getSaleReportItemwise(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
}
