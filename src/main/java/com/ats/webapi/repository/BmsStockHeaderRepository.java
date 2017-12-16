package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.BmsStockHeader;

public interface BmsStockHeaderRepository extends JpaRepository<BmsStockHeader,Long>{
	
	BmsStockHeader save(BmsStockHeader bmsStockHeader);

}
