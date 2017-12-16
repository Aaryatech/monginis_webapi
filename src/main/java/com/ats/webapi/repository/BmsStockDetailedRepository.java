package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.BmsStockDetailed;


public interface BmsStockDetailedRepository extends JpaRepository<BmsStockDetailed,Long>{
	
	BmsStockDetailed save(BmsStockDetailed bmsStockDetailed);

}
