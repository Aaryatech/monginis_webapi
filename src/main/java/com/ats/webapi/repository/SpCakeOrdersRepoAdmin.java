package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;

public interface SpCakeOrdersRepoAdmin extends JpaRepository<SpCakeOrdersBean, Integer> {
	
	
	
	
	@Query(value="SELECT m_franchisee.fr_name ,m_sp_cake.sp_code ,m_sp_cake.sp_name ,"
			+ "t_sp_cake.item_id ,t_sp_cake.sp_vno,"
			+ "m_sp_flavour.spf_name,t_sp_cake.sp_events,"
			+ " t_sp_cake.sp_delivery_dt, t_sp_cake.sp_price,t_sp_cake.sp_add_rate"
			+ " FROM m_franchisee ,m_sp_cake,m_sp_flavour,"
			+ "t_sp_cake WHERE t_sp_cake.sp_produ_date = :PDate AND t_sp_cake.fr_id IN (:frId) AND "
			+ "t_sp_cake.sp_id = m_sp_cake.sp_id AND t_sp_cake.fr_id = m_franchisee.fr_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour  "
			,nativeQuery=true)
	
	
	List<SpCakeOrdersBean> FindAllSpCakeOrder(@Param("frId")List<Integer> frId,@Param("PDate")String pDate);


	@Query(value="SELECT m_franchisee.fr_name ,m_sp_cake.sp_code ,"
			+ "t_sp_cake.item_id,m_sp_cake.sp_name ,t_sp_cake.sp_vno,"
			+ "m_sp_flavour.spf_name,t_sp_cake.sp_events,"
			+ " t_sp_cake.sp_delivery_dt, t_sp_cake.sp_price,t_sp_cake.sp_add_rate "
			+ " FROM m_franchisee ,m_sp_cake,m_sp_flavour"
			+ "t_sp_cake WHERE t_sp_cake.sp_produ_date = :PDate AND "
			+ "t_sp_cake.sp_id = m_sp_cake.sp_id AND t_sp_cake.fr_id = m_franchisee.fr_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour "
			,nativeQuery=true)
	
	
	List<SpCakeOrdersBean> FindAllSpCakeOrderAllFr(@Param("PDate")String pDate);

	
	
}
