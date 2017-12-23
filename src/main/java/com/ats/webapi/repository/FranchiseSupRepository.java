package com.ats.webapi.repository;

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

}
