package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.prodapp.ProdAppUser;

public interface ProdAppUserRepo extends JpaRepository<ProdAppUser, Integer> {
	
	
	public ProdAppUser save(ProdAppUser prodAppUser);//
	
	public ProdAppUser findByUMobNoAndUPass(String uMobNo,String uPass);//
	
	public ProdAppUser findByUserId(int uId);
	
	public List<ProdAppUser> findBydelStatus(int delStatus);//
	
	public List<ProdAppUser> findByuMobNoAndDelStatus(String mobNo,int delStatus);//
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE ProdAppUser  SET uDeviceToken=:uDeviceToken "
			+ " WHERE userId=:userId ")
		int updateDeviceToken(@Param("uDeviceToken") 
		int uDeviceToken,@Param("userId") int userId);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE ProdAppUser  SET delStatus=1 "
			+ " WHERE userId=:userId ")
		int deleteUser(@Param("userId") int userId);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE ProdAppUser  SET uPass=:uPass "
			+ " WHERE userId=:userId ")
		int changePass(@Param("uPass") 
		String uPass,@Param("userId") int userId);
	
	
}
