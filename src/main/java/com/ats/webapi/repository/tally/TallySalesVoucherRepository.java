package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.SalesVoucher;

@Repository
public interface TallySalesVoucherRepository extends JpaRepository<SalesVoucher, Integer>{

	
	
	@Query(value="select h.bill_no AS invoice_no,\n" + 
			"			d.bill_detail_no,\n" + 
			"			h.bill_date,\n" + 
			"			h.round_off,\n" + 
			"			f.fr_name,\n" + 
			"			f.fr_gst_no,\n" + 
			"			CASE WHEN d.cat_id = 5 \n" + 
			"THEN (select s.sp_name from m_sp_cake s where s.sp_id=d.item_id) ELSE (select i.item_name  from m_item i where i.id=d.item_id) END AS item_name, \n" + 
			"			CASE WHEN d.cat_id = 5 THEN (select spsup.sp_hsncd from  m_spcake_sup spsup where spsup.sp_id=d.item_id) ELSE  (select itemsup.item_hsncd from  m_item_sup itemsup where itemsup.item_id=d.item_id)  END AS hsn_code,\n" + 
			"			CASE WHEN d.cat_id = 5 THEN (select spsup.sp_uom from m_spcake_sup spsup where spsup.sp_id=d.item_id) ELSE (select itemsup.item_uom from m_item_sup itemsup where itemsup.item_id=d.item_id) END AS uom,\n" + 
			"			frsup.fr_state,\n" + 
			"			d.bill_qty,\n" + 
			"			d.base_rate,\n" + 
			"			d.taxable_amt,\n" + 
			"			d.sgst_per,\n" + 
			"			d.cgst_per,       \n" + 
			"			d.igst_per,\n" + 
			"			d.cess_per,\n" + 
			"			d.cgst_rs,              \n" + 
			"			d.sgst_rs,\n" + 
			"			d.igst_rs,\n" + 
			"			d.cess_rs,\n" + 
			"			d.disc_per,\n" + 
			"			h.disc_amt,\n" + 
			"			d.grand_total AS total_amt,\n" + 
			"			h.grand_total AS bill_total,\n" + 
			"			d.remark from t_bill_header h,    \n" + 
			"			t_bill_detail d,m_franchisee f,m_franchise_sup frsup where h.is_tally_sync=0 AND h.del_status=0 AND h.fr_id=f.fr_id AND h.fr_id=frsup.fr_id AND h.bill_no=d.bill_no;",nativeQuery=true)
	List<SalesVoucher> findByIsTallySync();

}
