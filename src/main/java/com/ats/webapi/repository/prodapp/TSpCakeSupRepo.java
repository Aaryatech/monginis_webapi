package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.prodapp.GetSpCakeOrderForProdApp;
import com.ats.webapi.model.prodapp.TSpCakeSup;

public interface TSpCakeSupRepo extends JpaRepository<TSpCakeSup, Integer> {

	TSpCakeSup save(TSpCakeSup cakeSup);

	/*
	 * @Query(value =
	 * "SELECT t_sp_cake.* WHERE date=:date AND menu_id IN (:menIdList) GROUP BY status "
	 * + "", nativeQuery = true)
	 * 
	 * List<TSpCakeSup> getSpCakeOrderForProdGen(@Param("date") String date,
	 * 
	 * @Param("menuIdList") List<Integer> menuIdList);
	 * 
	 */
	@Transactional
	@Modifying
	@Query("UPDATE TSpCakeSup SET startTimeStamp =:startTimeStamp,status=:status  WHERE tSpCakeSupNo=:tSpCakeSupNo")
	int startProdByApp(@Param("startTimeStamp") Long startTimeStamp, @Param("tSpCakeSupNo") int tSpCakeSupNo,
			@Param("status") int status);

	@Transactional
	@Modifying
	@Query("UPDATE TSpCakeSup SET endTimeStamp =:endTimeStamp,inputKgProd=:inputKgProd,status=:status,exInt=:isRateChange,"
			+ "photo1=:photo1,photo2=:photo2, mistryId=:mistryId ,mistryName=:mistryName,isCharUsed=:isCharUsed,"
			+ "ex_var=:timeRequired" + "  WHERE tSpCakeSupNo=:tSpCakeSupNo")
	int endProdByApp(@Param("endTimeStamp") Long endTimeStamp, @Param("inputKgProd") float inputKgProd,
			@Param("status") int status, @Param("photo1") String photo1, @Param("photo2") String photo2,
			@Param("mistryId") int mistryId, @Param("mistryName") String mistryName,
			@Param("isCharUsed") String isCharUsed, @Param("tSpCakeSupNo") int tSpCakeSupNo,
			@Param("isRateChange") int isRateChange, @Param("timeRequired") String timeRequired);

	@Transactional
	@Modifying
	@Query("UPDATE TSpCakeSup SET photo4=:photo4  WHERE tSpCakeOrderNo=:tSpCakeOrderNo")
	int updatePhoto4(@Param("tSpCakeOrderNo") int tSpCakeOrderNo, @Param("photo4") String photo4);

}
