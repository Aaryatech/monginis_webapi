package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.UpdateBillDetailForGrnGvn;

public interface UpdateBillDetailForGrnGvnRepository extends JpaRepository<UpdateBillDetailForGrnGvn, Integer> {
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateBillDetailForGrnGvn  SET isGrngvnApplied=:isGrngvnApplied "
			+ " WHERE billNo=:billNo ")
		int updateBillDetailForGrnGvnInsert(@Param("billNo") int billNo,@Param("isGrngvnApplied") 
		int isGrngvnApplied);
	
}
