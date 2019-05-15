package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.prodapp.TSpCakeSup;

public interface TSpCakeSupDeleteRepository extends JpaRepository<TSpCakeSup, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE TSpCakeSup SET  delStatus=1 WHERE tSpCakeOrderNo=:spOrderNo")
	int deleteSpCkOrderSupplement(@Param("spOrderNo") int spOrderNo);

}
