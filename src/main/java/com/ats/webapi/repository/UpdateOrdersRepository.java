package com.ats.webapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.UpdateOrder;

public interface UpdateOrdersRepository extends JpaRepository<UpdateOrder, Integer>{
	
	

	@Transactional
	@Modifying
	@Query("UPDATE UpdateOrder t SET t.orderQty =:orderQty  WHERE t.orderId=:orderId")
	int updateOrderQty(@Param("orderId") int orderId,@Param("orderQty") int orderQty);

	
	@Transactional
	@Modifying
	@Query("UPDATE UpdateOrder t SET t.isEdit=1  WHERE t.orderId=:orderId")
	int deleteOrder(@Param("orderId") int orderId);
}
