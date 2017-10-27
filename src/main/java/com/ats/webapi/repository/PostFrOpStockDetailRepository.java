package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.PostFrItemStockDetail;

public interface PostFrOpStockDetailRepository extends JpaRepository<PostFrItemStockDetail, Integer> {
	
	PostFrItemStockDetail save(PostFrItemStockDetail postFrItemStockDetail);
	
	 
}
