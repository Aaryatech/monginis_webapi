package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.bill.GetBillDetailPrint;

public interface BillDetailForPrintRepo extends JpaRepository<GetBillDetailPrint, Integer>{
	

	@Query(value="SELECT t_bill_detail.* ,m_item.item_name,m_category.cat_name,t_bill_header.bill_date,m_item_sup.item_hsncd,m_item_sup.item_uom "
			+ " FROM t_bill_detail,m_item,m_category,t_bill_header,m_item_sup WHERE t_bill_detail.bill_no IN (:billNoList)  "
			+ "AND t_bill_detail.item_id=m_item.id AND m_category.cat_id=t_bill_detail.cat_id "
			+ "AND t_bill_detail.bill_no=t_bill_header.bill_no AND m_item_sup.item_id=m_item.id",nativeQuery=true)
	
	List<GetBillDetailPrint> getBillDetailsForPrint(@Param("billNoList") List<String> billNoList);
	
}