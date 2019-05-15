package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.prodapp.TRegSpCakeSup;

public interface TRegSpCakeSupDeleteRepository extends JpaRepository<TRegSpCakeSup, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE TRegSpCakeSup SET  ex_int=1 WHERE t_reg_sup_order_id=:rspId")
	int deleteRegularSpCkOrderSupplement(@Param("rspId") int rspId);

}
