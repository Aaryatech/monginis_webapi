package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.Orders;



public interface OrderRepository extends JpaRepository<Orders,Long> {

	@Query(value = "SELECT * FROM t_order WHERE t_order.fr_id=:frId AND t_order.item_id =:items AND t_order.production_date=:date AND t_order.menu_id=:menuId", nativeQuery = true)
    Orders findPreviousOrder(@Param("items")String items ,@Param("frId") int frId,@Param("date") Date date,@Param("menuId") int menuId);
		
		
	Orders save(Orders order);
	
	//Orders save(Orders order);
	
	@Transactional
    Long deleteByOrderDateAndMenuIdAndItemId(Date orderDate, int menuId, String itemId);

	@Query(value = "UPDATE t_order SET is_bill_generated = 1 WHERE t_order.order_id=:orderId", nativeQuery = true)
	int updateBillStatus(@Param("orderId") int orderId);
	
	
	
	 
	

}
