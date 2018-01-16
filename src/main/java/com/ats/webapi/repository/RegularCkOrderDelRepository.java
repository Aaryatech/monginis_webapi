package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.RegSpCkOrder;

@Repository
public interface RegularCkOrderDelRepository extends JpaRepository<RegSpCkOrder, Integer>{


	@Transactional
	@Modifying
	@Query("UPDATE RegSpCkOrder t SET t.delStatus =1 WHERE t.rspId=:rspId")
	int deleteRegularSpOrder(@Param("rspId")int rspId);
}
