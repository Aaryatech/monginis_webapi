package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetGrnGvnDetails;

public interface GetGrnGvnDetailsRepository extends JpaRepository<GetGrnGvnDetails, Integer> {
	
	
	@Query(value = "SELECT t_grn_gvn.grn_gvn_id,t_grn_gvn.grn_gvn_header_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc,\n" + 
			"m_item.item_name,m_franchisee.fr_name FROM m_franchisee,"
			+ "m_item,t_grn_gvn WHERE t_grn_gvn.fr_id=m_franchisee.fr_id AND "
			+ "t_grn_gvn.item_id=m_item.id AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND  :toDate AND"
			+ " t_grn_gvn.is_grn=1 ORDER BY t_grn_gvn.grn_gvn_status"
			+ "" + "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getAllGrnDetails(@Param("fromDate") String fromDate ,@Param("toDate") String toDate);

	@Query(value = "SELECT"
			+ " t_grn_gvn.grn_gvn_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc\n" + 
			",m_item.item_name,m_franchisee.fr_name FROM m_franchisee,"
			+ "m_item,t_grn_gvn WHERE t_grn_gvn.fr_id=m_franchisee.fr_id AND "
			+ "t_grn_gvn.item_id=m_item.id AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND  :toDate AND"
			+ " t_grn_gvn.is_grn=0  ORDER BY t_grn_gvn.grn_gvn_status"
			+ "" + "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getAllGvnDetails(@Param("fromDate") String fromDate ,@Param("toDate") String toDate);
	
	/*@Query(value =  "SELECT CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_spcake_sup.sp_hsncd FROM m_spcake_sup WHERE m_spcake_sup.sp_id=t_grn_gvn.item_id) \n" + 
			"			ELSE (SELECT m_item_sup.item_hsncd FROM m_item_sup WHERE t_grn_gvn.item_id=m_item_sup.item_id) END AS item_hsncd,\n" + 
			"			CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_sp_cake.sp_name FROM m_sp_cake WHERE m_sp_cake.sp_id=t_grn_gvn.item_id) \n" + 
			"				ELSE (SELECT m_item.item_name FROM m_item WHERE t_grn_gvn.item_id=m_item.id) END AS item_name,\n" + 
			"			\n" + 
			"			t_grn_gvn.apr_qty_gate,t_grn_gvn.apr_qty_store,t_grn_gvn.apr_qty_acc,t_grn_gvn.apr_taxable_amt,t_grn_gvn.apr_total_tax,\n" + 
			"			 t_grn_gvn.apr_sgst_rs,t_grn_gvn.apr_cgst_rs,t_grn_gvn.apr_igst_rs,t_grn_gvn.apr_grand_total,t_grn_gvn.apr_r_off,t_grn_gvn.is_same_state,\n" + 
			"			 t_grn_gvn.grn_gvn_id,t_grn_gvn.grn_gvn_header_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"			t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"			t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"			t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"			t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"			t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"			t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"			t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"			CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc, \n" + 
			"			m_franchisee.fr_name FROM m_franchisee,\n" + 
			"			t_grn_gvn WHERE  t_grn_gvn.is_grn=0 AND\n" + 
			"			 t_grn_gvn.fr_id=m_franchisee.fr_id AND t_grn_gvn.grn_gvn_header_id=:grnGvnHeaderId", nativeQuery = true)
	
	List<GetGrnGvnDetails> getFrGvnDetails(@Param("grnGvnHeaderId") int grnGvnHeaderId);*/
	
	
	
	@Query(value =  "SELECT CASE WHEN\n" + 
			"    t_grn_gvn.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN t_grn_gvn.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_spcake_sup.sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_sup\n" + 
			"    WHERE\n" + 
			"        m_spcake_sup.sp_id = t_grn_gvn.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item_sup.item_hsncd\n" + 
			"    FROM\n" + 
			"        m_item_sup\n" + 
			"    WHERE\n" + 
			"        t_grn_gvn.item_id = m_item_sup.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        m_spcake_category_sup.sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        m_spcake_category_sup.sp_id = t_grn_gvn.item_id AND t_grn_gvn.cat_id = 5\n" + 
			")\n" + 
			"END AS item_hsncd,\n" + 
			"CASE WHEN t_grn_gvn.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN t_grn_gvn.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_sp_cake.sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake\n" + 
			"    WHERE\n" + 
			"        m_sp_cake.sp_id = t_grn_gvn.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item.item_name\n" + 
			"    FROM\n" + 
			"        m_item\n" + 
			"    WHERE\n" + 
			"        t_grn_gvn.item_id = m_item.id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(t_sp_cake.item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake,\n" + 
			"        t_bill_detail\n" + 
			"    WHERE\n" + 
			"        t_sp_cake.sp_order_no = t_bill_detail.order_id AND t_bill_detail.bill_detail_no = t_grn_gvn.bill_detail_no AND t_grn_gvn.cat_id = 5\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"t_grn_gvn.apr_qty_gate,\n" + 
			"t_grn_gvn.apr_qty_store,\n" + 
			"t_grn_gvn.apr_qty_acc,\n" + 
			"t_grn_gvn.apr_taxable_amt,\n" + 
			"t_grn_gvn.apr_total_tax,\n" + 
			"t_grn_gvn.apr_sgst_rs,\n" + 
			"t_grn_gvn.apr_cgst_rs,\n" + 
			"t_grn_gvn.apr_igst_rs,\n" + 
			"t_grn_gvn.apr_grand_total,\n" + 
			"t_grn_gvn.apr_r_off,\n" + 
			"t_grn_gvn.is_same_state,\n" + 
			"t_grn_gvn.grn_gvn_id,\n" + 
			"t_grn_gvn.grn_gvn_header_id,\n" + 
			"t_grn_gvn.grn_gvn_entry_datetime,\n" + 
			"t_grn_gvn.grn_gvn_date,\n" + 
			"t_grn_gvn.bill_no,\n" + 
			"t_grn_gvn.fr_id,\n" + 
			"t_grn_gvn.item_id,\n" + 
			"t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,\n" + 
			"t_grn_gvn.grn_gvn_qty,\n" + 
			"t_grn_gvn.grn_gvn_amt,\n" + 
			"t_grn_gvn.grn_type,\n" + 
			"t_grn_gvn.is_grn,\n" + 
			"t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,\n" + 
			"t_grn_gvn.gvn_photo_upload1,\n" + 
			"t_grn_gvn.gvn_photo_upload2,\n" + 
			"t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,\n" + 
			"t_grn_gvn.approved_remark_gate,\n" + 
			"t_grn_gvn.approved_login_store,\n" + 
			"t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,\n" + 
			"t_grn_gvn.approved_remark_acc,\n" + 
			"t_grn_gvn.del_status,\n" + 
			"t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,\n" + 
			"t_grn_gvn.base_rate,\n" + 
			"t_grn_gvn.sgst_per,\n" + 
			"t_grn_gvn.cgst_per,\n" + 
			"t_grn_gvn.igst_per,\n" + 
			"t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,\n" + 
			"t_grn_gvn.round_up_amt,\n" + 
			"t_grn_gvn.final_amt,\n" + 
			"t_grn_gvn.is_credit_note,\n" + 
			"t_grn_gvn.menu_id,\n" + 
			"t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,\n" + 
			"t_grn_gvn.ref_invoice_date,\n" + 
			"CAST(\n" + 
			"    t_grn_gvn.approved_datetime_gate AS CHAR\n" + 
			") AS approved_datetime_gate,\n" + 
			"CAST(\n" + 
			"    t_grn_gvn.approved_datetime_store AS CHAR\n" + 
			") AS approved_datetime_store,\n" + 
			"CAST(\n" + 
			"    t_grn_gvn.approved_datetime_acc AS CHAR\n" + 
			") AS approved_datetime_acc,\n" + 
			"m_franchisee.fr_name\n" + 
			"FROM\n" + 
			"    m_franchisee,\n" + 
			"    t_grn_gvn\n" + 
			"WHERE\n" + 
			"    t_grn_gvn.is_grn = 0 AND t_grn_gvn.fr_id = m_franchisee.fr_id AND t_grn_gvn.grn_gvn_header_id = :grnGvnHeaderId", nativeQuery = true)
	
	List<GetGrnGvnDetails> getFrGvnDetails(@Param("grnGvnHeaderId") int grnGvnHeaderId);
	
	
	
	
	
	
	
	
	
	
//changed on 16 feb for grnGvnHeaderId
	@Query(value = "SELECT  CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_spcake_sup.sp_hsncd FROM m_spcake_sup  WHERE m_spcake_sup.sp_id=t_grn_gvn.item_id) " + 
			"ELSE (SELECT m_item_sup.item_hsncd FROM m_item_sup WHERE t_grn_gvn.item_id=m_item_sup.item_id) END AS item_hsncd, "
		
			+ "CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_sp_cake.sp_name FROM m_sp_cake WHERE m_sp_cake.sp_id=t_grn_gvn.item_id) " + 
			"		ELSE (SELECT m_item.item_name FROM m_item WHERE t_grn_gvn.item_id=m_item.id) END AS item_name,"
		
			+ "t_grn_gvn.apr_qty_gate,t_grn_gvn.apr_qty_store,t_grn_gvn.apr_qty_acc,t_grn_gvn.apr_taxable_amt,t_grn_gvn.apr_total_tax,"
			+ "t_grn_gvn.apr_sgst_rs,t_grn_gvn.apr_cgst_rs,t_grn_gvn.apr_igst_rs,t_grn_gvn.apr_grand_total,t_grn_gvn.apr_r_off,t_grn_gvn.is_same_state,"
			+ "t_grn_gvn.grn_gvn_id,t_grn_gvn.grn_gvn_header_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc,\n" + 
			"m_item.item_name,m_franchisee.fr_name FROM m_franchisee," 
			+"m_item,t_grn_gvn WHERE  t_grn_gvn.is_grn=1 AND"
			+ " t_grn_gvn.item_id=m_item.id AND t_grn_gvn.fr_id=m_franchisee.fr_id "
			+ " AND t_grn_gvn.grn_gvn_header_id=:grnGvnHeaderId "
			+ "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getFrGrnDetails(@Param("grnGvnHeaderId") int grnGvnHeaderId);
	
	//New Sachin Admin pdf Grn Gvn 19-03-2020
	@Query(value = "SELECT  CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_spcake_sup.sp_hsncd FROM m_spcake_sup  WHERE m_spcake_sup.sp_id=t_grn_gvn.item_id) " + 
			"ELSE (SELECT m_item_sup.item_hsncd FROM m_item_sup WHERE t_grn_gvn.item_id=m_item_sup.item_id) END AS item_hsncd, "
		
			+ "CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_sp_cake.sp_name FROM m_sp_cake WHERE m_sp_cake.sp_id=t_grn_gvn.item_id) " + 
			"		ELSE (SELECT m_item.item_name FROM m_item WHERE t_grn_gvn.item_id=m_item.id) END AS item_name,"
		
			+ "t_grn_gvn.apr_qty_gate,t_grn_gvn.apr_qty_store,t_grn_gvn.apr_qty_acc,t_grn_gvn.apr_taxable_amt,t_grn_gvn.apr_total_tax,"
			+ "t_grn_gvn.apr_sgst_rs,t_grn_gvn.apr_cgst_rs,t_grn_gvn.apr_igst_rs,t_grn_gvn.apr_grand_total,t_grn_gvn.apr_r_off,t_grn_gvn.is_same_state,"
			+ "t_grn_gvn.grn_gvn_id,t_grn_gvn.grn_gvn_header_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc,\n" + 
			"m_item.item_name,m_franchisee.fr_name FROM m_franchisee," 
			+"m_item,t_grn_gvn WHERE  "
			+ " t_grn_gvn.item_id=m_item.id AND t_grn_gvn.fr_id=m_franchisee.fr_id "
			+ " AND t_grn_gvn.grn_gvn_header_id IN (:grnGvnHeaderIdList) order by m_franchisee.fr_name asc "
			+ "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getFrGrnDetailsMultipleHeaderIds(@Param("grnGvnHeaderIdList") List<String> grnGvnHeaderIdList);
	
	
}
