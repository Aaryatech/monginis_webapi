package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.PostFrItemStockHeader;

public interface PostFrOpStockHeaderRepository extends JpaRepository<PostFrItemStockHeader, Integer> {
	
	PostFrItemStockHeader save(PostFrItemStockHeader postFrItemStockHeader);
	 
}
