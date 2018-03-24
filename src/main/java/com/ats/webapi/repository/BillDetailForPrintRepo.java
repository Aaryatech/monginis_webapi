package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.bill.GetBillDetailPrint;

public interface BillDetailForPrintRepo extends JpaRepository<GetBillDetailPrint, Integer>{
	

	@Query(value="SELECT\n" + 
			"        t_bill_detail.* ,\n" + 
			"      CASE \n" + 
			"            WHEN t_bill_detail.cat_id=5 THEN (SELECT m_sp_cake.sp_name  FROM  m_sp_cake \n" + 
			"WHERE m_sp_cake.sp_id= t_bill_detail.item_id) \n" + 
			"            ELSE (SELECT  m_item.item_name FROM m_item WHERE t_bill_detail.item_id=m_item.id)\n" + 
			"        END AS item_name,\n" + 
			"        m_category.cat_name,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"CASE \n" + 
			"            WHEN t_bill_detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_hsncd   \n" + 
			"           FROM m_spcake_sup WHERE  m_spcake_sup.sp_id=t_bill_detail.item_id) ELSE (SELECT m_item_sup.item_hsncd \n" + 
			"FROM m_item_sup WHERE  m_item_sup.item_id=t_bill_detail.item_id)\n" + 
			"        END AS item_hsncd,\n" + 
			"\n" + 
			"CASE \n" + 
			"            WHEN t_bill_detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_uom  FROM m_spcake_sup \n" + 
			"WHERE  m_spcake_sup.sp_id=t_bill_detail.item_id)\n" + 
			"            ELSE (SELECT m_item_sup.item_uom FROM m_item_sup \n" + 
			" WHERE  m_item_sup.item_id=t_bill_detail.item_id)\n" + 
			"        END AS item_uom\n" + 
			"\n" + 
			"       \n" + 
			"    FROM\n" + 
			"        t_bill_detail,\n" + 
			"        m_category,\n" + 
			"        t_bill_header\n" + 
			"\n" + 
			"    WHERE\n" + 
			"        t_bill_detail.bill_no IN (:billNoList)  \n" + 
			"       \n" + 
			"        AND m_category.cat_id=t_bill_detail.cat_id \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no",nativeQuery=true)
	
	List<GetBillDetailPrint> getBillDetailsForPrint(@Param("billNoList") List<String> billNoList);
	
}