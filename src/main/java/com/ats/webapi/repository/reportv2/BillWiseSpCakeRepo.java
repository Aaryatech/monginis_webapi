package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.webapi.model.report.GetBillWiseSpCakeRep;

public interface BillWiseSpCakeRepo extends JpaRepository<GetBillWiseSpCakeRep, Integer> {

	@Query(value="SELECT \n" + 
			"        UUID() AS id, h.invoice_no, DATE_FORMAT(h.bill_date, '%d-%m-%Y') AS bill_date, \n" + 
			"        d.bill_no, \n" + 
			"        SUM(d.bill_qty) AS qty, \n" + 
			"        SUM(d.grand_total) AS grand_total, \n" + 
			"        d.item_id, \n" + 
			"        h.fr_id, \n" + 
			"        CASE WHEN s.is_allocated = 0 THEN s.item_id ELSE SUBSTRING_INDEX(s.item_id, '#', -1) \n" + 
			"             END AS item_name \n" + 
			"FROM \n" + 
			"        t_bill_header h, \n" + 
			"        t_bill_detail d, \n" + 
			"        t_sp_cake s \n" + 
			"WHERE \n" + 
			"        d.cat_id = 5 AND h.del_status = 0 AND h.bill_no = d.bill_no AND s.sp_order_no = d.order_id AND  \n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"GROUP BY \n" + 
			"        d.item_id, \n" + 
			"        d.bill_no\n" + 
			"ORDER BY \n" + 
			"        h.invoice_no", nativeQuery=true)
	public List<GetBillWiseSpCakeRep> getSpCakeDetailBillWise(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	@Query(value="SELECT \n" + 
			"        UUID() AS id, h.invoice_no, DATE_FORMAT(h.bill_date, '%d-%m-%Y') AS bill_date, \n" + 
			"        d.bill_no, \n" + 
			"        SUM(d.bill_qty) AS qty, \n" + 
			"        SUM(d.grand_total) AS grand_total, \n" + 
			"        d.item_id, \n" + 
			"        h.fr_id, \n" + 
			"        CASE WHEN s.is_allocated = 0 THEN s.item_id ELSE SUBSTRING_INDEX(s.item_id, '#', -1) \n" + 
			"             END AS item_name \n" + 
			"FROM \n" + 
			"        t_bill_header h, \n" + 
			"        t_bill_detail d, \n" + 
			"        t_sp_cake s \n" + 
			"WHERE \n" + 
			"        d.cat_id = 5 AND h.del_status = 0 AND h.bill_no = d.bill_no AND s.sp_order_no = d.order_id AND  \n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate AND h.fr_id IN (:frIdList)\n" + 
			"GROUP BY \n" + 
			"        d.item_id, \n" + 
			"        d.bill_no\n" + 
			"ORDER BY \n" + 
			"        h.invoice_no", nativeQuery=true)
	public List<GetBillWiseSpCakeRep> getSpCakeDetailFranchiseeWise(@Param("frIdList")List<String> frIdList, 
			@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	/*********************************************************************************************************/
	
	@Query(value="SELECT \n" + 
			"        UUID() AS id, h.invoice_no, DATE_FORMAT(h.bill_date, '%d-%m-%Y') AS bill_date, \n" + 
			"        d.bill_no, \n" + 
			"        SUM(d.bill_qty) AS qty, \n" + 
			"        SUM(d.grand_total) AS grand_total, \n" + 
			"        d.item_id, \n" + 
			"        h.fr_id, \n" + 
			"        CASE WHEN s.is_allocated = 0 THEN s.item_id ELSE SUBSTRING_INDEX(s.item_id, '#', -1) \n" + 
			"             END AS item_name \n" + 
			"FROM \n" + 
			"        t_bill_header h, \n" + 
			"        t_bill_detail d, \n" + 
			"        t_sp_cake s \n" + 
			"WHERE \n" + 
			"        d.cat_id = 5 AND h.del_status = 0 AND h.bill_no = d.bill_no AND s.sp_order_no = d.order_id AND  \n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate\n" + 
			"GROUP BY \n" + 
			"        d.item_id, \n" + 
			"        d.bill_no\n" + 
			"ORDER BY \n" + 
			"        h.invoice_no", nativeQuery=true)
	public List<GetBillWiseSpCakeRep> getAllSpCakeDetailGrpInvoice(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	@Query(value="SELECT \n" + 
			"        UUID() AS id, h.invoice_no, DATE_FORMAT(h.bill_date, '%d-%m-%Y') AS bill_date, \n" + 
			"        d.bill_no, \n" + 
			"        SUM(d.bill_qty) AS qty, \n" + 
			"        SUM(d.grand_total) AS grand_total, \n" + 
			"        d.item_id, \n" + 
			"        h.fr_id, \n" + 
			"        CASE WHEN s.is_allocated = 0 THEN s.item_id ELSE SUBSTRING_INDEX(s.item_id, '#', -1) \n" + 
			"             END AS item_name \n" + 
			"FROM \n" + 
			"        t_bill_header h, \n" + 
			"        t_bill_detail d, \n" + 
			"        t_sp_cake s \n" + 
			"WHERE \n" + 
			"        d.cat_id = 5 AND h.del_status = 0 AND h.bill_no = d.bill_no AND s.sp_order_no = d.order_id AND  \n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate AND h.fr_id IN (:frIdList)\n" + 
			"GROUP BY \n" + 
			"        d.item_id, \n" + 
			"        d.bill_no\n" + 
			"ORDER BY \n" + 
			"        h.invoice_no", nativeQuery=true)
	public List<GetBillWiseSpCakeRep> getSpCakeDetailGrpInvoice(@Param("frIdList")List<String> frIdList, 
			@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	
}




