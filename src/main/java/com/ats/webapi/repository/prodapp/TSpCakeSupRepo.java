package com.ats.webapi.repository.prodapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.prodapp.TSpCakeSup;


public interface TSpCakeSupRepo extends JpaRepository<TSpCakeSup, Integer> {
	
	
	TSpCakeSup save(TSpCakeSup cakeSup);
	

	@Transactional
	@Modifying	
	@Query("UPDATE TSpCakeSup SET startTimeStamp =:startTimeStamp,status=:status  WHERE tSpCakeSupNo=:tSpCakeSupNo")
	int startProdByApp(@Param("startTimeStamp") Long startTimeStamp,
			@Param("tSpCakeSupNo") int tSpCakeSupNo,
			@Param("status") int status);
	
	@Transactional
	@Modifying	
	@Query("UPDATE TSpCakeSup SET endTimeStamp =:endTimeStamp,inputKgProd=:inputKgProd,status=:status,"
			+ "photo1=:photo1,photo2=:photo2, mistryId=:mistryId ,mistryName=:mistryName,isCharUsed=:isCharUsed"
			+ "  WHERE tSpCakeSupNo=:tSpCakeSupNo")
	int endProdByApp(@Param("endTimeStamp") Long endTimeStamp,
			@Param("inputKgProd") float inputKgProd,
			@Param("status") int status,
			@Param("photo1") String photo1,
			@Param("photo2") String photo2,
			@Param("mistryId") int mistryId,
			@Param("mistryName") String mistryName,
			@Param("isCharUsed") String isCharUsed,
			@Param("tSpCakeSupNo") int tSpCakeSupNo);
	
}
