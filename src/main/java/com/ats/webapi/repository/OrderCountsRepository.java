package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OrderCounts;

public interface OrderCountsRepository extends JpaRepository<OrderCounts, Integer>{
	
	@Query (value="Select m_fr_menu_show.menu_id,m_fr_menu_show.menu_title,SUM(t_order.order_qty) "+
	"as Total from m_fr_menu_show,t_order "+
	"where t_order.production_date=:cDate and m_fr_menu_show.menu_id = t_order.menu_id",nativeQuery=true)
	List<OrderCounts> getOrderTotal(@Param("cDate") Date cDate);
	 

}
