package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatFrRepBill;

public interface SubCatFrRepBillRepo extends JpaRepository<SubCatFrRepBill, Integer> {

	@Query(value = " SELECT  UUID() as id," + 
			"			        td.bill_detail_no,  \n" + 
			"			        SUM(td.grand_total) AS sold_amt,  \n" + 
			"			        SUM(td.bill_qty) AS sold_qty,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name,  \n" + 
			"			        f.fr_id 			\n" + 
			"			    FROM  \n" + 
			"			        t_bill_header tb,  \n" + 
			"			        t_bill_detail td,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_item        \n" + 
			"			    WHERE  \n" + 
			"			        tb.del_status=0            \n" + 
			"			        AND tb.fr_id IN(:frIdList)  \n" + 
			"			        AND tb.bill_no=td.bill_no  \n" + 
			"			        AND tb.bill_date BETWEEN :fromDate AND :toDate   \n" + 
			"			        AND f.fr_id=tb.fr_id            \n" + 
			"			        AND m_item.id=td.item_id            \n" + 
			"			        AND m_item.item_grp2=sc.sub_cat_id  and  sc.sub_cat_id IN(:subCatIdList)   \n" + 
			"			          AND td.cat_id!=5 \n" + 
			"			    GROUP BY  \n" + 
			"			        tb.fr_id,m_item.item_grp2     \n" + 
			"			          \n" + 
			"			          \n" + 
			"			        UNION All  \n" + 
			"			          \n" + 
			"			        SELECT UUID() as id," + 
			"			        td.bill_detail_no,  \n" + 
			"			        SUM(td.grand_total) AS sold_amt,  \n" + 
			"			        SUM(td.bill_qty) AS sold_qty ,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name ,  \n" + 
			"			        f.fr_id  \n" + 
			"			\n" + 
			"			    FROM  \n" + 
			"			        t_bill_header tb,  \n" + 
			"			        t_bill_detail td,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_sp_cake        \n" + 
			"			    WHERE  \n" + 
			"			        tb.del_status=0  \n" + 
			"			        AND tb.fr_id IN(:frIdList)  \n" + 
			"			        AND tb.bill_no=td.bill_no  \n" + 
			"			        AND tb.bill_date BETWEEN :fromDate AND :toDate  \n" + 
			"			        AND f.fr_id=tb.fr_id  \n" + 
			"			        AND m_sp_cake.sp_id=td.item_id  \n" + 
			"			          AND td.cat_id=5  AND sc.cat_id=5 and  sc.sub_cat_id IN(:subCatIdList)\n" + 
			"			    GROUP BY  \n" + 
			"			        tb.fr_id,sc.sub_cat_id", nativeQuery = true)
	List<SubCatFrRepBill> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}
