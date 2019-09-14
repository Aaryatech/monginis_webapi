package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.bill.GetBillDetailPrint;

public interface BillDetailForPrintRepo extends JpaRepository<GetBillDetailPrint, Integer>{
	

	/*@Query(value="SELECT  t_bill_detail.bill_detail_no,t_bill_detail.bill_no,t_bill_detail.order_id,t_bill_detail.menu_id,t_bill_detail.cat_id,t_bill_detail.item_id,t_bill_detail.order_qty,t_bill_detail.bill_qty,t_bill_detail.mrp,t_bill_detail.rate_type,t_bill_detail.rate,t_bill_detail.base_rate,t_bill_detail.taxable_amt,t_bill_detail.sgst_per,\n" + 
			"  t_bill_detail.sgst_rs, t_bill_detail.cgst_per,t_bill_detail.cgst_rs, t_bill_detail.igst_per, t_bill_detail.igst_rs,\n" + 
			"t_bill_detail.total_tax,  t_bill_detail.grand_total, t_bill_detail.del_status, t_bill_detail.grn_type,  t_bill_detail.expiry_date,  t_bill_detail.is_grngvn_applied,  t_bill_detail.disc_per,  t_bill_detail.cess_per,  t_bill_detail.cess_rs, CASE  WHEN t_bill_detail.cat_id=5 THEN (SELECT CONCAT(m_sp_cake.sp_name, '-' ,m_sp_cake.sp_code)  FROM  m_sp_cake WHERE m_sp_cake.sp_id= t_bill_detail.item_id) ELSE (SELECT  m_item.item_name FROM m_item WHERE t_bill_detail.item_id=m_item.id)END AS item_name, m_category.cat_name, \n" + 
			" t_bill_header.bill_date,CASE WHEN t_bill_detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_hsncd   FROM m_spcake_sup WHERE  m_spcake_sup.sp_id=t_bill_detail.item_id) ELSE (SELECT m_item_sup.item_hsncd \n" + 
			"						FROM m_item_sup WHERE  m_item_sup.item_id=t_bill_detail.item_id) \n" + 
			"						        END AS item_hsncd,\n" + 
			"						\n" + 
			"						CASE \n" + 
			"						            WHEN t_bill_detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_uom  FROM m_spcake_sup  \n" + 
			"						WHERE  m_spcake_sup.sp_id=t_bill_detail.item_id)\n" + 
			"						            ELSE (SELECT m_item_sup.item_uom FROM m_item_sup \n" + 
			"						 WHERE  m_item_sup.item_id=t_bill_detail.item_id) \n" + 
			"						        END AS item_uom,\n" + 
			"			\n" + 
			"			CASE  WHEN t_bill_detail.cat_id=5 THEN (0)\n" + 
			"						            ELSE (SELECT m_item.item_grp2 FROM m_item \n" + 
			"						 WHERE  m_item.id=t_bill_detail.item_id) \n" + 
			"						        END AS sub_cat_id,\n" + 
			"CASE  WHEN t_bill_detail.cat_id=5 THEN (select t_sp_cake.sp_selected_weight from t_sp_cake where t_sp_cake.sp_order_no=t_bill_detail.order_id)\n" + 
			"						            ELSE (0) \n" + 
			"						        END AS remark\n" + 
			"\n" + 
			"						 FROM\n" + 
			"						        t_bill_detail,\n" + 
			"						        m_category,\n" + 
			"						        t_bill_header\n" + 
			"			\n" + 
			"						    WHERE\n" + 
			"						        t_bill_detail.bill_no IN (:billNoList)\n" + 
			"\n" + 
			"						        AND m_category.cat_id=t_bill_detail.cat_id \n" + 
			"						        AND t_bill_detail.bill_no=t_bill_header.bill_no",nativeQuery=true)
	
	List<GetBillDetailPrint> getBillDetailsForPrint(@Param("billNoList") List<String> billNoList);*/
	
	
	
	@Query(value="SELECT\n" + 
			"    t_bill_detail.bill_detail_no,\n" + 
			"    t_bill_detail.bill_no,\n" + 
			"    t_bill_detail.order_id,\n" + 
			"    t_bill_detail.menu_id,\n" + 
			"    t_bill_detail.cat_id,\n" + 
			"    t_bill_detail.item_id,\n" + 
			"    t_bill_detail.order_qty,\n" + 
			"    t_bill_detail.bill_qty,\n" + 
			"    t_bill_detail.mrp,\n" + 
			"    t_bill_detail.rate_type,\n" + 
			"    t_bill_detail.rate,\n" + 
			"    t_bill_detail.base_rate,\n" + 
			"    t_bill_detail.taxable_amt,\n" + 
			"    t_bill_detail.sgst_per,\n" + 
			"    t_bill_detail.sgst_rs,\n" + 
			"    t_bill_detail.cgst_per,\n" + 
			"    t_bill_detail.cgst_rs,\n" + 
			"    t_bill_detail.igst_per,\n" + 
			"    t_bill_detail.igst_rs,\n" + 
			"    t_bill_detail.total_tax,\n" + 
			"    t_bill_detail.grand_total,\n" + 
			"    t_bill_detail.del_status,\n" + 
			"    t_bill_detail.grn_type,\n" + 
			"    t_bill_detail.expiry_date,\n" + 
			"    t_bill_detail.is_grngvn_applied,\n" + 
			"    t_bill_detail.disc_per,\n" + 
			"    t_bill_detail.cess_per,\n" + 
			"    t_bill_detail.cess_rs,\n" + 
			"    CASE WHEN t_bill_detail.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN t_bill_detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        CONCAT(\n" + 
			"            m_sp_cake.sp_name,\n" + 
			"            '-',\n" + 
			"            m_sp_cake.sp_code\n" + 
			"        )\n" + 
			"    FROM\n" + 
			"        m_sp_cake\n" + 
			"    WHERE\n" + 
			"        m_sp_cake.sp_id = t_bill_detail.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item.item_name\n" + 
			"    FROM\n" + 
			"        m_item\n" + 
			"    WHERE\n" + 
			"        t_bill_detail.item_id = m_item.id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(t_sp_cake.item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_order_no = t_bill_detail.order_id AND t_bill_detail.cat_id = 5\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"m_category.cat_name,\n" + 
			"t_bill_header.bill_date,\n" + 
			"CASE WHEN t_bill_detail.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN t_bill_detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_spcake_sup.sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_sup\n" + 
			"    WHERE\n" + 
			"        m_spcake_sup.sp_id = t_bill_detail.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item_sup.item_hsncd\n" + 
			"    FROM\n" + 
			"        m_item_sup\n" + 
			"    WHERE\n" + 
			"        m_item_sup.item_id = t_bill_detail.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = t_bill_detail.item_id AND t_bill_detail.cat_id = 5\n" + 
			")\n" + 
			"END AS item_hsncd,\n" + 
			"CASE WHEN t_bill_detail.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN t_bill_detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_spcake_sup.sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_sup\n" + 
			"    WHERE\n" + 
			"        m_spcake_sup.sp_id = t_bill_detail.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item_sup.item_uom\n" + 
			"    FROM\n" + 
			"        m_item_sup\n" + 
			"    WHERE\n" + 
			"        m_item_sup.item_id = t_bill_detail.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = t_bill_detail.item_id AND t_bill_detail.cat_id = 5\n" + 
			")\n" + 
			"END AS item_uom,\n" + 
			"CASE WHEN t_bill_detail.cat_id = 5 THEN(0) ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item.item_grp2\n" + 
			"    FROM\n" + 
			"        m_item\n" + 
			"    WHERE\n" + 
			"        m_item.id = t_bill_detail.item_id\n" + 
			")\n" + 
			"END AS sub_cat_id,\n" + 
			"CASE WHEN t_bill_detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        t_sp_cake.sp_selected_weight\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        t_sp_cake.sp_order_no = t_bill_detail.order_id\n" + 
			") ELSE(0)\n" + 
			"END AS remark\n" + 
			"FROM\n" + 
			"    t_bill_detail,\n" + 
			"    m_category,\n" + 
			"    t_bill_header\n" + 
			"WHERE\n" + 
			"    t_bill_detail.bill_no IN(:billNoList) AND m_category.cat_id = t_bill_detail.cat_id AND t_bill_detail.bill_no = t_bill_header.bill_no",nativeQuery=true)
	
	List<GetBillDetailPrint> getBillDetailsForPrint(@Param("billNoList") List<String> billNoList);
	
	
}