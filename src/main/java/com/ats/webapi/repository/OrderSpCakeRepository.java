package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.Orders;


public interface OrderSpCakeRepository extends JpaRepository<OrderSpecialCake, Integer>{
	@Query(value="SELECT m_sp_cake.*,m_sp_rates.spr_rate,m_sp_rates.spr_add_on_rate FROM m_sp_rates,m_sp_cake WHERE m_sp_cake.sp_code =:spCode AND m_sp_cake.spr_id=m_sp_rates.spr_id",nativeQuery=true)
	public OrderSpecialCake findBySpCode(@Param("spCode")String spCode);
	
	
	
}
