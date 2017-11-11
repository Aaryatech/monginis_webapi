package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetGrnItemConfig;

public interface GetGrnItemConfigRepository extends JpaRepository<GetGrnItemConfig, Integer> {

	@Query(value = "SELECT t_bill_header.bill_no," + 
			"t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,t_bill_detail.grn_type," + 
			"t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no," + 
			"t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.igst_per,"
			+ "t_bill_detail.cat_id,t_bill_detail.menu_id, " + 
			"t_bill_header.fr_id,t_bill_header.invoice_no FROM t_bill_header ,t_bill_detail,m_item " + 
			" WHERE t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no " + 
			"AND t_bill_detail.item_id=m_item.id AND "
			+ "t_bill_detail.expiry_date=:cDate AND t_bill_detail.is_grngvn_applied=0", nativeQuery = true)
	
	public List<GetGrnItemConfig> getAllGrnItemConfig(@Param("cDate") Date cDate,@Param("frId") int frId);

	
	
	@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,"
			+ "t_bill_detail.grn_type,t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no,"
			+ "	t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,"
			+ " t_bill_detail.igst_per,t_bill_header.fr_id,t_bill_header.invoice_no,"
			+ " t_bill_detail.cat_id,t_bill_detail.menu_id "
			+ " FROM t_bill_header ,t_bill_detail,m_item "
			+ "	 WHERE t_bill_detail.bill_no=:billNo AND t_bill_header.bill_no=t_bill_detail.bill_no "
			+ "	AND t_bill_detail.item_id=m_item.id AND t_bill_detail.is_grngvn_applied=0 " + "", nativeQuery = true)
	
	public List<GetGrnItemConfig> getGvnItemConfig(@Param("billNo") int billNo);
	
	
	
}
