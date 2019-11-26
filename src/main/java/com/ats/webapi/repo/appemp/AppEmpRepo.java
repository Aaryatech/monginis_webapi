package com.ats.webapi.repo.appemp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.album.Album;
import com.ats.webapi.model.appemp.AppEmp;

public interface AppEmpRepo extends JpaRepository<AppEmp, Integer> {
	
	AppEmp findByEmpId(int empId);
	
	@Modifying
	@Transactional
	@Query("Update AppEmp  SET emp_dsc=:dsc WHERE emp_id=:empId")
	public int updateAppEmpDsc(@Param("empId") int empId, @Param("dsc") String dsc);
	
	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token1=:token WHERE emp_id=:empId")
	public int updateToken1(@Param("empId") int empId, @Param("token") String token);
	
	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token2=:token WHERE emp_id=:empId")
	public int updateToken2(@Param("empId") int empId, @Param("token") String token);

	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token3=:token WHERE emp_id=:empId")
	public int updateToken3(@Param("empId") int empId, @Param("token") String token);

	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token4=:token WHERE emp_id=:empId")
	public int updateToken4(@Param("empId") int empId, @Param("token") String token);

	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token5=:token WHERE emp_id=:empId")
	public int updateToken5(@Param("empId") int empId, @Param("token") String token);

	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token6=:token WHERE emp_id=:empId")
	public int updateToken6(@Param("empId") int empId, @Param("token") String token);

	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token7=:token WHERE emp_id=:empId")
	public int updateToken7(@Param("empId") int empId, @Param("token") String token);

	@Modifying
	@Transactional
	@Query("Update AppEmp  SET token8=:token WHERE emp_id=:empId")
	public int updateToken8(@Param("empId") int empId, @Param("token") String token);
	
	

}
