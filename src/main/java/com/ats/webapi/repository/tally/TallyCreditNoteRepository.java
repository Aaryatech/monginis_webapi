package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.CreditNote;

@Repository
public interface TallyCreditNoteRepository extends JpaRepository<CreditNote, Integer>{

	@Query(value="select h.crn_id,\n" + 
			"h.crn_date,\n" + 
			" d.crnd_id,\n" + 
			"h.crn_no,\n" + 
			"f.fr_name,\n" + 
			"f.fr_gst_no,\n" + 
			"sup.fr_state,\n" + 
			"CASE WHEN d.cat_id = 5 \n" + 
			"THEN (select s.sp_name from m_sp_cake s where s.sp_id=d.item_id) ELSE (select i.item_name  from m_item i where i.id=d.item_id) END AS item_name,\n" + 
			"CASE WHEN d.cat_id = 5 THEN (select spsup.sp_hsncd from  m_spcake_sup spsup where spsup.sp_id=d.item_id) ELSE  (select itemsup.item_hsncd from  m_item_sup itemsup where itemsup.item_id=d.item_id)  END AS hsn_code,\n" + 
			"CASE WHEN d.cat_id = 5 THEN (select spsup.sp_uom from m_spcake_sup spsup where spsup.sp_id=d.item_id) ELSE (select itemsup.item_uom from m_item_sup itemsup where itemsup.item_id=d.item_id) END AS uom,\n" + 
			"d.grn_gvn_qty,\n" + 
			"d.base_rate,\n" + 
			"d.taxable_amt,\n" + 
			"d.cgst_per,\n" + 
			"d.sgst_per,\n" + 
			"d.igst_per,\n" + 
			"d.cess_per,\n" + 
			"d.cgst_rs,\n" + 
			"d.sgst_rs,\n" + 
			"d.igst_rs,\n" + 
			"d.cess_rs,\n" + 
			"h.round_off,\n" + 
			"h.crn_final_amt,\n" + 
			"d.ref_invoice_no,\n" + 
			"d.ref_invoice_date,\n" + 
			"d.grn_gvn_id,\n" + 
			"d.grn_gvn_date from t_credit_note_header h,t_credit_note_details d,m_franchisee f,m_franchise_sup sup WHERE  h.is_tally_sync=0 AND h.crn_id=d.crn_id AND h.fr_id=f.fr_id AND h.fr_id=sup.fr_id",nativeQuery=true)
	List<CreditNote> findByIsTallySync();


}
