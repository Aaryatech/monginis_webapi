package com.ats.webapi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetOrderItemQty;


public interface GetOrderItemRepository extends JpaRepository<GetOrderItemQty, Integer>
{

	@Query(value = " SELECT order_id, SUM(order_qty) as qty, item_id FROM t_order WHERE order_date =:orderDate AND item_id =:itemId ", nativeQuery = true)
	GetOrderItemQty getOrderItemQty(@Param("itemId") int itemId, @Param("orderDate") String orderDate);


	
//	
//	@Query(value = "SELECT t_order.item_id, t_order.order_id FROM t_order WHERE t_order.order_date=:orderDate AND t_order.item_id=:itemId" , nativeQuery=true)
//	GetOrderItemQty getOrderItemQty(@Param("itemId") int itemId, @Param("orderDate") String orderDate );
}
