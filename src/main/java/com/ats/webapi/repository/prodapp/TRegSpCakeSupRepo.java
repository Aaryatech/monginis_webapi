package com.ats.webapi.repository.prodapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.prodapp.TRegSpCakeSup;

public interface TRegSpCakeSupRepo extends JpaRepository<TRegSpCakeSup, Integer>{
	
	
	
	TRegSpCakeSup save(TRegSpCakeSup regSpCakeSup );
	
	

	
	@Transactional
	@Modifying	
	@Query("UPDATE TRegSpCakeSup SET startTime =:startTime,status=:status  WHERE supId=:supId")
	int startRegSpCakeProdByApp(@Param("startTime") Long startTime,
			@Param("supId") int supId,
			@Param("status") int status);
	
	/*@Transactional
	@Modifying	
	@Query("UPDATE TRegSpCakeSup  SET endTime =:endTime,status=:status,inputKgProd=:inputKgProd"
			+ "photo1=:photo1,photo2=:photo2, mistryId=:mistryId ,mistryName=:mistryName"
			+ "  WHERE supId=:supId")
	int endRegSpCakeProdByApp(@Param("endTime") Long endTime,
			@Param("inputKgProd") float inputKgProd,
			@Param("status") int status,
			@Param("photo1") String photo1,
			@Param("photo2") String photo2,
			@Param("mistryId") int mistryId,
			@Param("mistryName") String mistryName,
			@Param("supId") int supId);*/
}
