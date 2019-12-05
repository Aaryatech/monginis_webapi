package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatBillRep;

public interface SubCatBillRepRepo extends JpaRepository<SubCatBillRep, Integer> {

	@Query(value = "\n" + 
			" SELECT SUM(td.grand_total) AS sold_amt, SUM(td.bill_qty) AS sold_qty, sc.sub_cat_id, sc.sub_cat_name, c.cat_id FROM t_bill_header tb, t_bill_detail td ,m_cat_sub sc ,m_category c,m_item i WHERE tb.del_status=0 AND tb.bill_no=td.bill_no AND tb.bill_date BETWEEN   :fromDate  AND :toDate   AND td.cat_id=c.cat_id AND i.id=td.item_id AND i.item_grp2=sc.sub_cat_id and td.cat_id!=5 GROUP BY i.item_grp2\n" + 
			" UNION ALL\n" + 
			" SELECT SUM(td.grand_total) AS sold_amt,\n" + 
			"        SUM(td.bill_qty) AS sold_qty,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name,\n" + 
			"        c.cat_id \n" + 
			"        FROM t_bill_header tb, t_bill_detail  td  ,m_cat_sub sc ,m_category c,m_sp_cake s  \n" + 
			"        WHERE tb.del_status=0  AND tb.bill_no=td.bill_no AND tb.bill_date BETWEEN  :fromDate  AND :toDate  AND td.cat_id=c.cat_id AND s.sp_id=td.item_id AND 5=sc.cat_id and c.cat_id=5 GROUP BY sc.cat_id ", nativeQuery = true)
	List<SubCatBillRep> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " \n" + 
			" SELECT SUM(td.grand_total) AS sold_amt, SUM(td.bill_qty) AS sold_qty, sc.sub_cat_id, sc.sub_cat_name, c.cat_id FROM t_bill_header tb, t_bill_detail td ,m_cat_sub sc ,m_category c,m_item i WHERE tb.del_status=0 AND tb.bill_no=td.bill_no And tb.fr_id=:frId AND tb.bill_date BETWEEN   :fromDate  AND :toDate   AND td.cat_id=c.cat_id AND i.id=td.item_id AND i.item_grp2=sc.sub_cat_id and td.cat_id!=5 GROUP BY i.item_grp2\n" + 
			" UNION ALL\n" + 
			" SELECT SUM(td.grand_total) AS sold_amt,\n" + 
			"        SUM(td.bill_qty) AS sold_qty,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name,\n" + 
			"        c.cat_id \n" + 
			"        FROM t_bill_header tb, t_bill_detail  td  ,m_cat_sub sc ,m_category c,m_sp_cake s  \n" + 
			"        WHERE tb.del_status=0  AND tb.bill_no=td.bill_no And tb.fr_id=:frId AND tb.bill_date BETWEEN  :fromDate  AND :toDate  AND td.cat_id=c.cat_id AND s.sp_id=td.item_id AND 5=sc.cat_id and c.cat_id=5 GROUP BY sc.cat_id ", nativeQuery = true)
	List<SubCatBillRep> getDataByFrId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
