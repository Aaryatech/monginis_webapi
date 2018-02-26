package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.FranchiseSup;

@Repository
public interface FranchiseSupRepository extends JpaRepository<FranchiseSup, Integer>{

	@Modifying
	@Transactional
	@Query("Update FranchiseSup  SET del_status=1 WHERE fr_id=:frId")
	int deleteFranchiseSup(@Param("frId")int frId);

	FranchiseSup findFranchiseSupById(int id);

	FranchiseSup findFranchiseSupByFrId(int frId);

	@Modifying
	@Transactional
	@Query("Update FranchiseSup  SET pass1=:pass1,pass2=:pass2,pass3=:pass3 WHERE fr_id=:frId")
	public int updateFranchiseSupUserPwd(@Param("frId")int frId,@Param("pass1") String pass1,@Param("pass2") String pass2,@Param("pass3") String pass3);

	@Modifying
	@Transactional
	@Query("Update FranchiseSup  SET token=:token WHERE fr_id=:frId")
	int updateUserToken(@Param("frId")int userId,@Param("token") String token);

	@Query(value="select token from m_franchise_sup where del_status=0",nativeQuery=true)
	List<String> findTokens();
	
	@Query(value="select token from m_franchise_sup where fr_id=:frId",nativeQuery=true)
	String findTokenByFrId(@Param("frId")int frId);


}
