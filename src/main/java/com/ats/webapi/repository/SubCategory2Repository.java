package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.SubCategory2;

@Repository
public interface SubCategory2Repository extends JpaRepository<SubCategory2, Integer>{
	
	SubCategory2 findByMiniCatIdAndDelStatus(int miniCatId,int delStatus);

	@Transactional
	@Modifying
	@Query(" update  SubCategory2 set delStatus=1 where miniCatId=:miniCatId")
	int deleteSubCategory2ById(@Param("miniCatId")int miniCatId);
}
