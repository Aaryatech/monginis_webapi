package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.User;

@Repository("franchiseeRepository")
public interface FranchiseeRepository extends JpaRepository<Franchisee, Integer> {
	 
		public Franchisee save(Franchisee franchisee);

		public Franchisee findOne(int frId);

		//public Franchisee findByFrCode(String frCode);

		//public List<Franchisee> findAllByDelStatus(int i);
		

		@Modifying
		@Transactional
		@Query("Update Franchisee  SET fr_password=:adminPwd WHERE fr_id=:frId")
		public int updateAdminPwd(@Param("frId")int frId,@Param("adminPwd")String adminPwd);

		@Query(value="select MAX(fr_id)+1 from m_franchisee",nativeQuery=true)
		public int getUnigueFrCode();

		public List<Franchisee> findAllByDelStatusOrderByFrNameAsc(int i);

		public List<Franchisee> findAllByDelStatusOrderByFrOpeningDateDesc(int i);

		public List<Franchisee> findAllByOrderByFrOpeningDateDesc();
		
		@Modifying
		@Transactional
		@Query("Update Franchisee  SET fr_password=:newPass WHERE fr_id=:frId")
		public int changeOPSPassword(@Param("frId")int frId,@Param("newPass")String newPass);

		public Franchisee findByfrCodeAndDelStatus(String frCode, int del);
		
		@Query(value="SELECT fr_opening FROM `m_franchisee` WHERE fr_id=:frId",nativeQuery=true)
		public int isFrTcs(@Param("frId")int frId);
		
	}