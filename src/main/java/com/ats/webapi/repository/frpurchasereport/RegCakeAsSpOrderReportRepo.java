package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.regcakeasspreport.RegCakeAsSpOrderReport;

public interface RegCakeAsSpOrderReportRepo extends JpaRepository<RegCakeAsSpOrderReport, Integer> {

	@Query(value=" SELECT t_regular_sp_cake.rsp_id,t_regular_sp_cake.mrp,t_regular_sp_cake.qty,"
			+ " t_regular_sp_cake.rsp_sub_total,t_regular_sp_cake.tax_1 as tax1, t_regular_sp_cake.tax_1_amt AS tax1Amt,"
			+ " t_regular_sp_cake.tax_2 as tax2,t_regular_sp_cake.tax_2_amt AS tax2Amt, t_regular_sp_cake.rsp_cust_name,"
			+ " m_cat_sub.sub_cat_name, m_item.item_name FROM t_regular_sp_cake,m_item,m_cat_sub"
			+ " WHERE t_regular_sp_cake.rsp_sub_cat=m_cat_sub.sub_cat_id AND "
			+ " t_regular_sp_cake.item_id=m_item.id AND t_regular_sp_cake.rsp_delivery_dt "
			+ " BETWEEN :fromDate AND :toDate AND t_regular_sp_cake.fr_id=:frId " ,nativeQuery=true) 
		
		List<RegCakeAsSpOrderReport> getRegCakeAsSpOrderReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
				@Param("frId") int frId);
	
}
