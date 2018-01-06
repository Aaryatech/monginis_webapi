package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.SalesVoucher;

@Repository
public interface TallySalesVoucherRepository extends JpaRepository<SalesVoucher, Integer>{

	
	
	@Query(value="select h.bill_no AS invoice_no,\n" + 
			"d.bill_detail_no,\n" + 
			"h.bill_date,\n" + 
			"h.round_off,\n" + 
			"f.fr_name,\n" + 
			"f.fr_gst_no,\n" + 
			"CASE WHEN d.cat_id = 5 THEN s.sp_name ELSE i.item_name END AS item_name, \n" + 
			"CASE WHEN d.cat_id = 5 THEN spsup.sp_hsncd ELSE itemsup.item_hsncd END AS hsn_code,\n" + 
			"CASE WHEN d.cat_id = 5 THEN spsup.sp_uom ELSE itemsup.item_uom END AS uom,\n" + 
			"frsup.fr_state,\n" + 
			"d.bill_qty,\n" + 
			"d.base_rate,\n" + 
			"d.taxable_amt,\n" + 
			"d.sgst_per\n" + 
			",d.cgst_per,\n" + 
			"d.igst_per,\n" + 
			"d.cess_per,\n" + 
			"d.cgst_rs,\n" + 
			"d.sgst_rs,\n" + 
			"d.igst_rs,\n" + 
			"d.cess_rs,\n" + 
			"d.disc_per,\n" + 
			"h.disc_amt,\n" + 
			"d.grand_total AS total_amt,\n" + 
			"h.grand_total AS bill_total,\n" + 
			"d.remark from t_bill_header h,\n" +     
			"t_bill_detail d,m_item i,m_item_sup itemsup,m_sp_cake s,m_spcake_sup spsup,m_franchisee f ,m_franchise_sup frsup where h.is_tally_sync=0 AND d.del_status=0 AND h.fr_id=f.fr_id AND h.fr_id=frsup.fr_id AND h.bill_no=d.bill_no AND CASE WHEN d.cat_id = 5 THEN d.item_id=s.sp_id AND d.item_id=spsup.sp_id ELSE d.item_id=i.id AND d.item_id=itemsup.item_id END group by d.bill_detail_no;",nativeQuery=true)
	List<SalesVoucher> findByIsTallySync();

}
