package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvn.GetGrnGvnForCreditNote;

public interface GrnGvnForCreditNoteRepositoty extends JpaRepository<GetGrnGvnForCreditNote, Integer>{
	
	/*@Query(value = " " + 
			" SELECT" + 
			"        t_grn_gvn.grn_gvn_id," + 
			"        t_grn_gvn.grn_gvn_header_id," + 
			"        t_grn_gvn_header.grngvn_srno," + 
			"        t_grn_gvn.grn_gvn_entry_datetime," + 
			"        t_grn_gvn.grn_gvn_date," + 
			"        t_grn_gvn.bill_no," + 
			"        t_grn_gvn.fr_id," + 
			"        t_grn_gvn.item_id," + 
			"        t_grn_gvn.item_rate," + 
			"        t_grn_gvn.item_mrp," + 
			"     t_grn_gvn.apr_qty_acc," + 
			"      t_grn_gvn.apr_grand_total," + 
			"        t_grn_gvn.grn_type," + 
			"        t_grn_gvn.is_grn," + 
			"        t_grn_gvn.is_grn_edit," + 
			"        t_grn_gvn.fr_grn_gvn_remark," + 
			"        t_grn_gvn.grn_gvn_status," + 
			"        t_grn_gvn.del_status," + 
			"        t_grn_gvn.grn_gvn_qty_auto," + 
			"        t_grn_gvn.is_tally_sync," + 
			"        t_grn_gvn.base_rate," + 
			"        t_grn_gvn.sgst_per," + 
			"        t_grn_gvn.cgst_per," + 
			"        t_grn_gvn.igst_per," + 
			"       t_grn_gvn.apr_taxable_amt," + 
			"       t_grn_gvn.apr_total_tax," + 
			"       t_grn_gvn.apr_r_off," + 
			"        t_grn_gvn.is_credit_note," + 
			"        t_grn_gvn.menu_id," + 
			"        t_grn_gvn.cat_id," + 
			"        t_grn_gvn.invoice_no," + 
			"        t_grn_gvn.ref_invoice_date," + 
			"      " + 
			"        CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc," + 
			"        CASE " + 
			"            WHEN t_grn_gvn.cat_id=5 THEN s.sp_name  " + 
			"            ELSE  m_item.item_name " + 
			"        END AS item_name," + 
			"        m_franchisee.fr_name " + 
			"    FROM" + 
			"        m_franchisee," + 
			"        m_item," + 
			"        t_grn_gvn," + 
			"        t_grn_gvn_header," + 
			"        m_sp_cake s " + 
			"    WHERE" + 
			"        t_grn_gvn.is_grn=:isGrn" + 
			"        AND t_grn_gvn.fr_id=m_franchisee.fr_id " + 
			"        AND t_grn_gvn.grn_gvn_header_id=t_grn_gvn_header.grn_gvn_header_id " + 
			"        AND  CASE " + 
			"            WHEN t_grn_gvn.cat_id=5 THEN t_grn_gvn.item_id=s.sp_id " + 
			"            ELSE t_grn_gvn.item_id=m_item.id " + 
			"        END " + 
			"        AND  t_grn_gvn.is_credit_note=0  " + 
			"        AND t_grn_gvn.grn_gvn_status=6  " + 
			"    group by" + 
			"        t_grn_gvn.grn_gvn_id "
			, nativeQuery = true)
	
	List<GetGrnGvnForCreditNote> getGrnGvnDetailForCreditNote(@Param("isGrn") int isGrn);*/
	
	
	@Query(value = " SELECT\n" + 
			"    t_grn_gvn.grn_gvn_id,\n" + 
			"    t_grn_gvn.grn_gvn_header_id,\n" + 
			"    t_grn_gvn_header.grngvn_srno,\n" + 
			"    t_grn_gvn.grn_gvn_entry_datetime,\n" + 
			"    t_grn_gvn.grn_gvn_date,\n" + 
			"    t_grn_gvn.bill_no,\n" + 
			"    t_grn_gvn.fr_id,\n" + 
			"    CASE WHEN t_grn_gvn.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN t_grn_gvn.item_id ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(t_sp_cake.item_id, '#', 1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake,\n" + 
			"        t_bill_detail\n" + 
			"    WHERE\n" + 
			"        t_sp_cake.sp_order_no = t_bill_detail.order_id AND t_bill_detail.bill_detail_no = t_grn_gvn.bill_detail_no\n" + 
			")\n" + 
			"END AS item_id,\n" + 
			"t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,\n" + 
			"t_grn_gvn.apr_qty_acc,\n" + 
			"t_grn_gvn.apr_grand_total,\n" + 
			"t_grn_gvn.grn_type,\n" + 
			"t_grn_gvn.is_grn,\n" + 
			"t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,\n" + 
			"t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.del_status,\n" + 
			"t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,\n" + 
			"t_grn_gvn.base_rate,\n" + 
			"t_grn_gvn.sgst_per,\n" + 
			"t_grn_gvn.cgst_per,\n" + 
			"t_grn_gvn.igst_per,\n" + 
			"t_grn_gvn.apr_taxable_amt,\n" + 
			"t_grn_gvn.apr_total_tax,\n" + 
			"t_grn_gvn.apr_r_off,\n" + 
			"t_grn_gvn.is_credit_note,\n" + 
			"t_grn_gvn.menu_id,\n" + 
			"t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,\n" + 
			"t_grn_gvn.ref_invoice_date,\n" + 
			"CAST(\n" + 
			"    t_grn_gvn.approved_datetime_acc AS CHAR\n" + 
			") AS approved_datetime_acc,\n" + 
			"CASE WHEN t_grn_gvn.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN t_grn_gvn.cat_id = 5 THEN s.sp_name ELSE m_item.item_name\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(t_sp_cake.item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake,\n" + 
			"        t_bill_detail\n" + 
			"    WHERE\n" + 
			"        t_sp_cake.sp_order_no = t_bill_detail.order_id AND t_bill_detail.bill_detail_no = t_grn_gvn.bill_detail_no\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"m_franchisee.fr_name,\n" + 
			"CASE WHEN t_grn_gvn.menu_id IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN(\n" + 
			"    SELECT\n" + 
			"        t_sp_cake.item_id\n" + 
			"    FROM\n" + 
			"        t_sp_cake,\n" + 
			"        t_bill_detail\n" + 
			"    WHERE\n" + 
			"        t_sp_cake.sp_order_no = t_bill_detail.order_id AND t_bill_detail.bill_detail_no = t_grn_gvn.bill_detail_no\n" + 
			") ELSE ''\n" + 
			"END AS album_code,\n" + 
			"\n" + 
			"CASE WHEN t_grn_gvn.menu_id IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN\n" + 
			"t_grn_gvn.item_id\n" + 
			"ELSE\n" + 
			"0\n" + 
			"END AS album_sp_id\n" + 
			"\n" + 
			"FROM\n" + 
			"    m_franchisee,\n" + 
			"    m_item,\n" + 
			"    t_grn_gvn,\n" + 
			"    t_grn_gvn_header,\n" + 
			"    m_sp_cake_category s\n" + 
			"WHERE\n" + 
			"    t_grn_gvn.is_grn = :isGrn AND t_grn_gvn.fr_id = m_franchisee.fr_id AND t_grn_gvn.grn_gvn_header_id = t_grn_gvn_header.grn_gvn_header_id AND(\n" + 
			"        CASE WHEN t_grn_gvn.cat_id = 5 THEN t_grn_gvn.item_id = s.sp_id ELSE t_grn_gvn.item_id = m_item.id\n" + 
			"    END\n" + 
			") AND t_grn_gvn.is_credit_note = 0 AND t_grn_gvn.grn_gvn_status = 6\n" + 
			"GROUP BY\n" + 
			"    t_grn_gvn.grn_gvn_id "
			, nativeQuery = true)
	
	List<GetGrnGvnForCreditNote> getGrnGvnDetailForCreditNote(@Param("isGrn") int isGrn);
	
	
	
	
	
}
