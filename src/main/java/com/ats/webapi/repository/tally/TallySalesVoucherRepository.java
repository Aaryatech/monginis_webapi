package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.SalesVoucher;

@Repository
public interface TallySalesVoucherRepository extends JpaRepository<SalesVoucher, Integer>{

	
	
	

	/*@Query(value="  select\n" + 
			"        h.bill_no ,\n" + 
			"        h.invoice_no,\n" + 
			"        d.bill_detail_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.round_off, \n" + 
			"        f.fr_code, \n" + 
			"        f.fr_name, \n" + 
			"        f.fr_gst_no,\n" + 
			"        CASE                           \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.sp_name                           \n" + 
			"            from\n" + 
			"                m_sp_cake s                           \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id)                           \n" + 
			"            ELSE (select\n" + 
			"                i.item_name                            \n" + 
			"            from\n" + 
			"                m_item i                           \n" + 
			"            where\n" + 
			"                i.id=d.item_id)                   \n" + 
			"        END AS item_name,\n" + 
			"        CASE                                        \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.sp_code                                        \n" + 
			"            from\n" + 
			"                m_sp_cake s                                        \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id)                                        \n" + 
			"            ELSE (select\n" + 
			"                i.item_id                                         \n" + 
			"            from\n" + 
			"                m_item i                                        \n" + 
			"            where\n" + 
			"                i.id=d.item_id)                            \n" + 
			"        END AS item_code,\n" + 
			"        CASE                           \n" + 
			"            WHEN d.cat_id = 5 THEN (select\n" + 
			"                spsup.sp_hsncd                           \n" + 
			"            from\n" + 
			"                m_spcake_sup spsup                           \n" + 
			"            where\n" + 
			"                spsup.sp_id=d.item_id )                           \n" + 
			"            ELSE  (select\n" + 
			"                itemsup.item_hsncd                           \n" + 
			"            from\n" + 
			"                m_item_sup itemsup                           \n" + 
			"            where\n" + 
			"                itemsup.item_id=d.item_id )                    \n" + 
			"        END AS hsn_code,\n" + 
			"        CASE                           \n" + 
			"            WHEN d.cat_id = 5 THEN (select\n" + 
			"                spsup.sp_uom                           \n" + 
			"            from\n" + 
			"                m_spcake_sup spsup                           \n" + 
			"            where\n" + 
			"                spsup.sp_id=d.item_id )                           \n" + 
			"            ELSE (select\n" + 
			"                itemsup.item_uom                           \n" + 
			"            from\n" + 
			"                m_item_sup itemsup                           \n" + 
			"            where\n" + 
			"                itemsup.item_id=d.item_id )                   \n" + 
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
			"        h.taxable_amt as total_taxable_amt,\n" + 
			"        h.sgst_sum,\n" + 
			"        h.cgst_sum,\n" + 
			"        h.igst_sum,\n" + 
			"        h.total_tax,\n" + 
			"        f.fr_id,\n" + 
			"        d.item_id,\n" + 
			"        d.cat_id, d.remark,CASE                                        \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.erp_link_code                                        \n" + 
			"            from\n" + 
			"                m_sp_cake s                                        \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id)                                        \n" + 
			"            ELSE (0)                            \n" + 
			"        END AS erp_link           \n" + 
			"    from\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_franchisee f,\n" + 
			"        m_franchise_sup frsup where\n" + 
			"        h.del_status=0                   \n" + 
			"        AND h.fr_id=f.fr_id                   \n" + 
			"        AND h.fr_id=frsup.fr_id                   \n" + 
			"        AND h.bill_no=d.bill_no and h.bill_no in (:billNo );  \n" + 
			"",nativeQuery=true)
	List<SalesVoucher> getSalesVouchersByBillNo(@Param("billNo")List<Integer> billNo);*/
	
	
	//Anmol--------16-9-2019
	@Query(value="  SELECT\n" + 
			"    h.bill_no,\n" + 
			"    h.invoice_no,\n" + 
			"    d.bill_detail_no,\n" + 
			"    h.bill_date,\n" + 
			"    h.round_off,\n" + 
			"    f.fr_code,\n" + 
			"    f.fr_name,\n" + 
			"    f.fr_gst_no,\n" + 
			"    CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        i.item_name\n" + 
			"    FROM\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        i.id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_order_no = d.order_id\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.sp_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        i.item_id\n" + 
			"    FROM\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        i.id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(\n" + 
			"            SUBSTRING_INDEX(item_id, '#', 2),\n" + 
			"            '#',\n" + 
			"            -1\n" + 
			"        )\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_order_no = d.order_id\n" + 
			")\n" + 
			"END AS item_code,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        spsup.sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_sup spsup\n" + 
			"    WHERE\n" + 
			"        spsup.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        itemsup.item_hsncd\n" + 
			"    FROM\n" + 
			"        m_item_sup itemsup\n" + 
			"    WHERE\n" + 
			"        itemsup.item_id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS hsn_code,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        spsup.sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_sup spsup\n" + 
			"    WHERE\n" + 
			"        spsup.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        itemsup.item_uom\n" + 
			"    FROM\n" + 
			"        m_item_sup itemsup\n" + 
			"    WHERE\n" + 
			"        itemsup.item_id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS uom,\n" + 
			"frsup.fr_state,\n" + 
			"d.bill_qty,\n" + 
			"d.base_rate,\n" + 
			"d.taxable_amt,\n" + 
			"d.sgst_per,\n" + 
			"d.cgst_per,\n" + 
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
			"h.taxable_amt AS total_taxable_amt,\n" + 
			"h.sgst_sum,\n" + 
			"h.cgst_sum,\n" + 
			"h.igst_sum,\n" + 
			"h.total_tax,\n" + 
			"f.fr_id,\n" + 
			"d.item_id,\n" + 
			"d.cat_id,\n" + 
			"d.remark,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.erp_link_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(0)\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        erp_link_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake_category\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS erp_link,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN 0 ELSE 1\n" + 
			"END AS is_album\n" + 
			"FROM\n" + 
			"    t_bill_header h,\n" + 
			"    t_bill_detail d,\n" + 
			"    m_franchisee f,\n" + 
			"    m_franchise_sup frsup\n" + 
			"WHERE\n" + 
			"    h.del_status = 0 AND h.fr_id = f.fr_id AND h.fr_id = frsup.fr_id AND h.bill_no = d.bill_no AND h.bill_no IN(:billNo)   order by h.bill_no,d.bill_detail_no" + 
			"",nativeQuery=true)
	List<SalesVoucher> getSalesVouchersByBillNo(@Param("billNo")List<Integer> billNo);
	

	@Query(value="SELECT\n" + 
			"    h.bill_no,\n" + 
			"    h.invoice_no,\n" + 
			"    d.bill_detail_no,\n" + 
			"    h.bill_date,\n" + 
			"    h.round_off,\n" + 
			"    f.fr_code,\n" + 
			"    f.fr_name,\n" + 
			"    f.fr_gst_no,\n" + 
			"    CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        i.item_name\n" + 
			"    FROM\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        i.id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_order_no = d.order_id\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.sp_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        i.item_id\n" + 
			"    FROM\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        i.id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(\n" + 
			"            SUBSTRING_INDEX(item_id, '#', 2),\n" + 
			"            '#',\n" + 
			"            -1\n" + 
			"        )\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_order_no = d.order_id\n" + 
			")\n" + 
			"END AS item_code,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        spsup.sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_sup spsup\n" + 
			"    WHERE\n" + 
			"        spsup.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        itemsup.item_hsncd\n" + 
			"    FROM\n" + 
			"        m_item_sup itemsup\n" + 
			"    WHERE\n" + 
			"        itemsup.item_id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS hsn_code,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        spsup.sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_sup spsup\n" + 
			"    WHERE\n" + 
			"        spsup.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        itemsup.item_uom\n" + 
			"    FROM\n" + 
			"        m_item_sup itemsup\n" + 
			"    WHERE\n" + 
			"        itemsup.item_id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS uom,\n" + 
			"frsup.fr_state,\n" + 
			"d.bill_qty,\n" + 
			"d.base_rate,\n" + 
			"d.taxable_amt,\n" + 
			"d.sgst_per,\n" + 
			"d.cgst_per,\n" + 
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
			"h.taxable_amt AS total_taxable_amt,\n" + 
			"h.sgst_sum,\n" + 
			"h.cgst_sum,\n" + 
			"h.igst_sum,\n" + 
			"h.total_tax,\n" + 
			"f.fr_id,\n" + 
			"d.item_id,\n" + 
			"d.cat_id,\n" + 
			"d.remark,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.erp_link_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(0)\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        erp_link_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake_category\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS erp_link,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN 0 ELSE 1\n" + 
			"END AS is_album\n" + 
			"FROM\n" + 
			"    t_bill_header h,\n" + 
			"    t_bill_detail d,\n" + 
			"    m_franchisee f,\n" + 
			"    m_franchise_sup frsup\n" + 
			"WHERE\n" + 
			"    h.del_status = 0 AND h.fr_id = f.fr_id AND h.fr_id = frsup.fr_id AND h.bill_no = d.bill_no  order by h.bill_no,d.bill_detail_no" 
			,nativeQuery=true)
	List<SalesVoucher> findByIsTallySync();

	@Query(value="  SELECT\n" + 
			"    h.bill_no,\n" + 
			"    h.invoice_no,\n" + 
			"    d.bill_detail_no,\n" + 
			"    h.bill_date,\n" + 
			"    h.round_off,\n" + 
			"    f.fr_code,\n" + 
			"    f.fr_name,\n" + 
			"    f.fr_gst_no,\n" + 
			"    CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        i.item_name\n" + 
			"    FROM\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        i.id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_order_no = d.order_id\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.sp_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        i.item_id\n" + 
			"    FROM\n" + 
			"        m_item i\n" + 
			"    WHERE\n" + 
			"        i.id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(\n" + 
			"            SUBSTRING_INDEX(item_id, '#', 2),\n" + 
			"            '#',\n" + 
			"            -1\n" + 
			"        )\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_order_no = d.order_id\n" + 
			")\n" + 
			"END AS item_code,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        spsup.sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_sup spsup\n" + 
			"    WHERE\n" + 
			"        spsup.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        itemsup.item_hsncd\n" + 
			"    FROM\n" + 
			"        m_item_sup itemsup\n" + 
			"    WHERE\n" + 
			"        itemsup.item_id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS hsn_code,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        spsup.sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_sup spsup\n" + 
			"    WHERE\n" + 
			"        spsup.sp_id = d.item_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        itemsup.item_uom\n" + 
			"    FROM\n" + 
			"        m_item_sup itemsup\n" + 
			"    WHERE\n" + 
			"        itemsup.item_id = d.item_id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS uom,\n" + 
			"frsup.fr_state,\n" + 
			"d.bill_qty,\n" + 
			"d.base_rate,\n" + 
			"d.taxable_amt,\n" + 
			"d.sgst_per,\n" + 
			"d.cgst_per,\n" + 
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
			"h.taxable_amt AS total_taxable_amt,\n" + 
			"h.sgst_sum,\n" + 
			"h.cgst_sum,\n" + 
			"h.igst_sum,\n" + 
			"h.total_tax,\n" + 
			"f.fr_id,\n" + 
			"d.item_id,\n" + 
			"d.cat_id,\n" + 
			"d.remark,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        s.erp_link_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake s\n" + 
			"    WHERE\n" + 
			"        s.sp_id = d.item_id\n" + 
			") ELSE(0)\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        erp_link_code\n" + 
			"    FROM\n" + 
			"        m_sp_cake_category\n" + 
			"    WHERE\n" + 
			"        sp_id = d.item_id\n" + 
			")\n" + 
			"END AS erp_link,\n" + 
			"CASE WHEN d.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN 0 ELSE 1\n" + 
			"END AS is_album\n" + 
			"FROM\n" + 
			"    t_bill_header h,\n" + 
			"    t_bill_detail d,\n" + 
			"    m_franchisee f,\n" + 
			"    m_franchise_sup frsup\n" + 
			"WHERE\n" + 
			"    h.del_status = 0 AND h.fr_id = f.fr_id AND h.fr_id = frsup.fr_id AND h.bill_no = d.bill_no AND h.bill_date BETWEEN :fromDate AND :toDate  order by h.bill_no,d.bill_detail_no" + 
			"",nativeQuery=true)
	List<SalesVoucher> getSalesVouchersAll(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}
