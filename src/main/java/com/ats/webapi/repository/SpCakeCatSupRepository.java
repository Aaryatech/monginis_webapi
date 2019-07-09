package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SpCakeCatSupplement;

@Repository
public interface SpCakeCatSupRepository extends JpaRepository<SpCakeCatSupplement, Integer>{

	SpCakeCatSupplement saveAndFlush(SpCakeCatSupplement spCakeSupplement);

	@Modifying
	@Transactional
	@Query("Update SpCakeCatSupplement  SET del_status=1 WHERE sp_id=:id")
	int deleteSpCakeCatSup(@Param("id") int id);


}
