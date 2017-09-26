package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.FrItemStockConfigure;

public interface FrItemStockConfigureRepository extends JpaRepository<FrItemStockConfigure,Integer> {
	
	
	public List<FrItemStockConfigure> findAll();
	
	
	

}
