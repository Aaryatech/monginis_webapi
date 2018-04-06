package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.SalesVoucher;

@Repository
public interface TallySalesVoucherRepository extends JpaRepository<SalesVoucher, Integer>{

	
	
	@Query(value="select h.bill_no ,\n" + 
			"        	h.invoice_no,\n" + 
			"			d.bill_detail_no,\n" + 
			"			h.bill_date,\n" + 
			"			h.round_off,\n" + 
			"			f.fr_name,\n" + 
			"			f.fr_gst_no,\n" + 
			"			CASE WHEN d.cat_id = 5 \n" + 
			"THEN (select s.sp_name from m_sp_cake s where s.sp_id=d.item_id) ELSE (select i.item_name  from m_item i where i.id=d.item_id) END AS item_name, \n" + 
			"			CASE WHEN d.cat_id = 5 THEN (select spsup.sp_hsncd from  m_spcake_sup spsup where spsup.sp_id=d.item_id ) ELSE  (select itemsup.item_hsncd from  m_item_sup itemsup where itemsup.item_id=d.item_id )  END AS hsn_code,\n" + 
			"			CASE WHEN d.cat_id = 5 THEN (select spsup.sp_uom from m_spcake_sup spsup where spsup.sp_id=d.item_id ) ELSE (select itemsup.item_uom from m_item_sup itemsup where itemsup.item_id=d.item_id ) END AS uom,\n" + 
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

	@Query(value="select\n" + 
			"        h.bill_no ,\n" + 
			"        h.invoice_no,\n" + 
			"        d.bill_detail_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.round_off,\n" + 
			"        f.fr_name,\n" + 
			"        f.fr_gst_no,\n" + 
			"        CASE \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.sp_name \n" + 
			"            from\n" + 
			"                m_sp_cake s \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id) \n" + 
			"            ELSE (select\n" + 
			"                i.item_name  \n" + 
			"            from\n" + 
			"                m_item i \n" + 
			"            where\n" + 
			"                i.id=d.item_id) \n" + 
			"        END AS item_name,\n" + 
			"        CASE \n" + 
			"            WHEN d.cat_id = 5 THEN (select\n" + 
			"                spsup.sp_hsncd \n" + 
			"            from\n" + 
			"                m_spcake_sup spsup \n" + 
			"            where\n" + 
			"                spsup.sp_id=d.item_id ) \n" + 
			"            ELSE  (select\n" + 
			"                itemsup.item_hsncd \n" + 
			"            from\n" + 
			"                m_item_sup itemsup \n" + 
			"            where\n" + 
			"                itemsup.item_id=d.item_id )  \n" + 
			"        END AS hsn_code,\n" + 
			"        CASE \n" + 
			"            WHEN d.cat_id = 5 THEN (select\n" + 
			"                spsup.sp_uom \n" + 
			"            from\n" + 
			"                m_spcake_sup spsup \n" + 
			"            where\n" + 
			"                spsup.sp_id=d.item_id ) \n" + 
			"            ELSE (select\n" + 
			"                itemsup.item_uom \n" + 
			"            from\n" + 
			"                m_item_sup itemsup \n" + 
			"            where\n" + 
			"                itemsup.item_id=d.item_id ) \n" + 
			"        END AS uom,\n" + 
			"        frsup.fr_state,\n" + 
			"        d.bill_qty,\n" + 
			"        d.base_rate,\n" + 
			"        d.taxable_amt,\n" + 
			"        d.sgst_per,\n" + 
			"        d.cgst_per,\n" + 
			"        d.igst_per,\n" + 
			"        d.cess_per,\n" + 
			"        d.cgst_rs,\n" + 
			"        d.sgst_rs,\n" + 
			"        d.igst_rs,\n" + 
			"        d.cess_rs,\n" + 
			"        d.disc_per,\n" + 
			"        h.disc_amt,\n" + 
			"        d.grand_total AS total_amt,\n" + 
			"        h.grand_total AS bill_total,\n" + 
			"        d.remark \n" + 
			"    from\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_franchisee f,\n" + 
			"        m_franchise_sup frsup \n" + 
			"    where\n" + 
			"         \n" + 
			"          h.del_status=0 \n" + 
			"        AND h.fr_id=f.fr_id \n" + 
			"        AND h.fr_id=frsup.fr_id \n" + 
			"        AND h.bill_no=d.bill_no\n" + 
			"        and h.bill_no in (:billNo);\n" + 
			" ",nativeQuery=true)
	List<SalesVoucher> getSalesVouchersByBillNo(@Param("billNo")List<Integer> billNo);

}
