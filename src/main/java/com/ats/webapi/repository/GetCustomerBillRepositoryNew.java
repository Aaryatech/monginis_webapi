package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.GetCustomerBill;
import com.ats.webapi.model.report.GetCustomerBillNew;
import com.ats.webapi.model.report.GetRepItemwiseSell;

public interface GetCustomerBillRepositoryNew extends JpaRepository<GetCustomerBillNew, Integer>{

	@Query(value="    select\r\n" + 
			"        h.sell_bill_no,\r\n" + 
			"        CONCAT(h.user_name,\r\n" + 
			"        '##',\r\n" + 
			"        h.user_gst_no) as  user_name,\r\n" + 
			"        f.fr_mob,\r\n" + 
			"        f.fr_gst_no ,\r\n" + 
			"        h.discount_per,\r\n" + 
			"        h.discount_amt,\r\n" + 
			"        f.fr_address,\r\n" + 
			"        d.sell_bill_detail_no,\r\n" + 
			"        h.bill_date,\r\n" + 
			"        h.fr_id,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        h.invoice_no,\r\n" + 
			"        d.item_id,\r\n" + 
			"        t.item_name,\r\n" + 
			"        d.mrp,\r\n" + 
			"        d.qty,\r\n" + 
			"        h.grand_total,\r\n" + 
			"        h.taxable_amt,\r\n" + 
			"        d.igst_per,\r\n" + 
			"        d.igst_rs,\r\n" + 
			"        d.cgst_per,\r\n" + 
			"        d.cgst_rs,\r\n" + 
			"        d.sgst_per,\r\n" + 
			"        d.sgst_rs,\r\n" + 
			"        s.item_hsncd\r\n" + 
			"    from\r\n" + 
			"        t_sell_bill_detail d,\r\n" + 
			"        t_sell_bill_header h,\r\n" + 
			"        m_franchisee f,\r\n" + 
			"        m_item t,\r\n" + 
			"        m_item_sup s\r\n" + 
			"    where\r\n" + 
			"        h.sell_bill_no=:billNo \r\n" + 
			"        AND h.sell_bill_no=d.sell_bill_no \r\n" + 
			"        AND        d.item_id=t.id \r\n" + 
			"        AND f.fr_id=h.fr_id\r\n" + 
			"        AND t.id=s.item_id",nativeQuery=true)
	List<GetCustomerBillNew> getCustBillItmHsn(@Param("billNo") int billNo);
}

