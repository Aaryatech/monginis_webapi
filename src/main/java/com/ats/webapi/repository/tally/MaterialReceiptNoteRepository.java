package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.MaterialReceiptNote;

@Repository
public interface MaterialReceiptNoteRepository extends JpaRepository<MaterialReceiptNote, Integer>{

	@Query(value="select\n" + 
			"d.mrn_detail_id,\n" + 
			"d.mrn_id,\n" + 
			"d.mrn_no,\n" + 
			"h.supplier_id,\n" + 
			"s.supp_name,\n" + 
			"h.invoice_number,\n" + 
			"h.inv_book_date,\n" + 
			"h.inv_date,\n" + 
			"h.basic_value,\n" + 
			"d.rm_id,\n" + 
			"d.rm_name,\n" + 
			"d.rm_uom,\n" + 
			"d.recd_qty,\n" + 
			"d.po_rate,\n" + 
			"d.Value,\n" + 
			"h.disc_per,\n" + 
			"h.disc_amt,\n" + 
			"h.disc_amt2,\n" + 
			"h.freight_amt,\n" + 
			"h.insurance_amt,\n" + 
			"d.cgst_per AS item_cgst_per,\n" + 
			"d.cgst_rs AS item_cgst_rs,\n" + 
			"d.sgst_per AS item_sgst_per,\n" + 
			"d.sgst_rs AS item_sgst_rs,\n" + 
			"d.igst_per AS item_igst_per,\n" + 
			"d.igst_rs AS item_igst_rs,\n" + 
			"d.cess_per AS item_cess_per,\n" + 
			"d.cess_rs AS item_cess_rs,\n" + 
			"d.amount,\n" + 
			"h.cgst,\n" + 
			"h.sgst,\n" + 
			"h.igst,\n" + 
			"h.cess,\n" + 
			"h.round_off,\n" + 
			"h.bill_amount,\n" + 
			"h.is_tally_sync ,\n" + 
			"d.gst_per\n" + 
			"from t_material_receipt_note_detail d ,t_material_receipt_note h,m_supplier s where h.mrn_id=d.mrn_id AND h.supplier_id=s.supp_id AND h.status=5 AND h.is_tally_sync=0",nativeQuery=true)
	List<MaterialReceiptNote> getAllInwards();

}
