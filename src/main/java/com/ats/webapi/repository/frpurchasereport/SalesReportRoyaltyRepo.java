package com.ats.webapi.repository.frpurchasereport;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.report.frpurchase.SalesReportRoyalty;

public interface SalesReportRoyaltyRepo extends JpaRepository<SalesReportRoyalty, Integer> {
	
	@Query(value=" SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id, COALESCE((SELECT SUM(t_bill_detail.bill_qty) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id AND t_bill_header.fr_id IN(:frIdList) AND t_bill_header.del_status=0),0) AS t_bill_qty,\n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id AND t_bill_header.fr_id IN(:frIdList) AND t_bill_header.del_status=0),0) AS  t_bill_taxable_amt,\n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date  BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=1 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.del_status=0),0) AS  t_grn_qty,\n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=1 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.del_status=0),0) AS  t_grn_taxable_amt,\n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=0 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.del_status=0),0) AS  t_gvn_qty,\n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=0 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.del_status=0),0) AS  t_gvn_taxable_amt\n" + 
			"\n" + 
			"from m_item,m_category where m_item.item_grp1=m_category.cat_id group by m_item.id order by m_category.cat_id",nativeQuery=true)
		
		List<SalesReportRoyalty> getSaleReportRoyalty(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	//report no 10
	@Query(value=" SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id, \n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_bill_detail.bill_qty) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date \n" + 
			"BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id AND \n" + 
			"t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS t_bill_qty,\n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date \n" + 
			"BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id \n" + 
			"AND t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS  t_bill_taxable_amt,\n" + 
			"		\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date  \n" + 
			"BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=1 AND \n" + 
			" t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_grn_qty,\n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date\n" + 
			" BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 \n" + 
			"AND t_grn_gvn.is_grn=1 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_grn_taxable_amt, \n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date \n" + 
			"BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 \n" + 
			"AND t_grn_gvn.is_grn=0 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_gvn_qty,\n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date \n" + 
			"BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 \n" + 
			"AND t_grn_gvn.is_grn=0 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_gvn_taxable_amt\n" + 
			"			 \n" + 
			"FROM m_item,m_category where m_item.item_grp1=m_category.cat_id AND m_category.cat_id IN(:catIdList) group by m_item.id order by m_category.cat_id,m_item.id",nativeQuery=true)
		
		List<SalesReportRoyalty> getSaleReportRoyConsoByCat(@Param("frIdList") List<String> frIdList,@Param("catIdList") List<String> catIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value=" SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id, \n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_bill_detail.bill_qty) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date \n" + 
			"BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id AND \n" + 
			"t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS t_bill_qty,\n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date \n" + 
			"BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id \n" + 
			"AND t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS  t_bill_taxable_amt,\n" + 
			"		\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date  \n" + 
			"BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=1 AND \n" + 
			" t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_grn_qty,\n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date\n" + 
			" BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 \n" + 
			"AND t_grn_gvn.is_grn=1 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_grn_taxable_amt, \n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date \n" + 
			"BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 \n" + 
			"AND t_grn_gvn.is_grn=0 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_gvn_qty,\n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date \n" + 
			"BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 \n" + 
			"AND t_grn_gvn.is_grn=0 AND t_grn_gvn.fr_id IN(:frIdList) AND t_grn_gvn.cat_id IN(:catIdList) AND t_grn_gvn.del_status=0),0) AS  t_gvn_taxable_amt\n" + 
			"			 \n" + 
			"FROM m_item,m_category where m_item.item_grp1=m_category.cat_id AND m_category.cat_id IN(:catIdList) group by m_category.cat_id order by m_category.cat_id,m_item.id",nativeQuery=true)
		
		List<SalesReportRoyalty> getSaleReportRoyConsoByCatForGraph(@Param("frIdList") List<String> frIdList,@Param("catIdList") List<String> catIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
}
