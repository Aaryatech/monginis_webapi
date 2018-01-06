package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.CreditNote;

@Repository
public interface TallyCreditNoteRepository extends JpaRepository<CreditNote, Integer>{

	@Query(value="select h.crn_id,h.crn_date, d.crnd_id,h.crn_no,f.fr_name,f.fr_gst_no,sup.fr_state,CASE WHEN d.cat_id = 5 THEN s.sp_name ELSE i.item_name END AS item_name,CASE WHEN d.cat_id = 5 THEN spsup.sp_hsncd ELSE itemsup.item_hsncd END AS hsn_code,CASE WHEN d.cat_id = 5 THEN spsup.sp_uom ELSE itemsup.item_uom END AS uom,d.grn_gvn_qty,d.base_rate,d.taxable_amt,d.cgst_per,d.sgst_per,d.igst_per,d.cess_per,d.cgst_rs,d.sgst_rs,d.igst_rs,d.cess_rs,h.round_off,h.crn_final_amt,d.ref_invoice_no,d.ref_invoice_date,d.grn_gvn_id,d.grn_gvn_date from t_credit_note_header h,t_credit_note_details d,m_item i,m_franchisee f,m_sp_cake s,m_spcake_sup spsup,m_franchise_sup sup,m_item_sup itemsup WHERE d.del_status=0 AND h.is_tally_sync=0 AND h.crn_id=d.crn_id AND h.fr_id=f.fr_id AND CASE WHEN d.cat_id = 5 THEN d.item_id=s.sp_id AND d.item_id=spsup.sp_id ELSE  d.item_id=i.id AND  d.item_id=itemsup.item_id END  GROUP BY d.crnd_id",nativeQuery=true)
	List<CreditNote> findByIsTallySync();


}
