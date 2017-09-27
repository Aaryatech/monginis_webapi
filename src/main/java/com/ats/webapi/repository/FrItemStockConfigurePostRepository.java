package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.FrItemStockConfigurePost;

public interface FrItemStockConfigurePostRepository extends JpaRepository<FrItemStockConfigurePost, Integer> {
	
	public FrItemStockConfigurePost save(List<FrItemStockConfigurePost> frItemStockConfigurePost);
	

}
