package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.RegularSpCake;

@Repository
public interface RegularSpCkOrderRepository extends JpaRepository<RegularSpCake, Long>{


	RegularSpCake save(RegularSpCake regularSpCake);

	
	
	@Transactional
	@Modifying
	@Query("UPDATE RegularSpCake t SET t.isBillGenerated =:status  WHERE t.rspId=:orderId")
	int updateRegSpCakeBillStatus(@Param("orderId") int orderId,@Param("status") int status);
}
