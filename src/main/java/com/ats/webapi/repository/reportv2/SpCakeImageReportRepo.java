package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.SpCakeImageReport;

public interface SpCakeImageReportRepo extends JpaRepository<SpCakeImageReport, Integer> {
	
	
	@Query(value = " SELECT t_sp_cake.sp_order_no,t_sp_cake.sp_selected_weight,t_sp_cake.order_photo,t_sp_cake.order_photo2,t_sp_cake.sp_id, " + 
			" t_sp_cake.order_date,t_sp_cake.sp_delivery_date, " + 
			" m_sp_cake_category.sp_code, " + 
			"  m_sp_cake_category.sp_name, " + 
			"  m_franchisee.fr_name,m_franchisee.fr_code, " + 
			" m_sp_flavour.spf_name " + 
			" FROM t_sp_cake,m_sp_cake_category,m_franchisee,m_sp_flavour " + 
			"    WHERE  t_sp_cake.sp_id = m_sp_cake_category.sp_id AND m_sp_cake_category.del_status=0 AND t_sp_cake.del_status=0 AND " + 
			"    t_sp_cake.fr_id=m_franchisee.fr_id AND t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id  " + 
			"    AND t_sp_cake.sp_delivery_date BETWEEN :fromDate AND :toDate AND (m_sp_cake_category.is_cust_choice_ck=1 OR m_sp_cake_category.sp_pho_upload=1)"
			+ " ORDER BY m_franchisee.fr_id,t_sp_cake.sp_delivery_date ASC " + 
			" " + 
			" ", nativeQuery = true)
	List<SpCakeImageReport> getSpCakeImageReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate);


}
