package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetGrnItemConfig;

public interface GetGrnItemConfigRepository extends JpaRepository<GetGrnItemConfig, Integer> {

	@Query(value = "select t_bill_header.bill_no,t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,t_bill_detail.grn_type,"
			+ "	t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no,"
			+ "	t_bill_detail.bill_no,t_bill_header.fr_id from t_bill_header ,t_bill_detail,m_item "
			+ "	 where t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no "
			+ "	AND t_bill_detail.item_id=m_item.id AND t_bill_detail.expiry_date=:cDate " + "", nativeQuery = true)
	
	public List<GetGrnItemConfig> getAllGrnItemConfig(@Param("cDate") Date cDate,@Param("frId") int frId);

	
	
	@Query(value = "select t_bill_header.bill_no,t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,t_bill_detail.grn_type,"
			+ "	t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no,"
			+ "	t_bill_detail.bill_no,t_bill_header.fr_id from t_bill_header ,t_bill_detail,m_item "
			+ "	 where t_bill_detail.bill_no=:billNo AND t_bill_header.bill_no=t_bill_detail.bill_no "
			+ "	AND t_bill_detail.item_id=m_item.id " + "", nativeQuery = true)
	
	public List<GetGrnItemConfig> getGvnItemConfig(@Param("billNo") int billNo);
	
	
	
}
