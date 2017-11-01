package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.PostFrItemStockDetail;
public interface PostFrOpStockDetailRepository extends JpaRepository<PostFrItemStockDetail, Integer> {
	
	PostFrItemStockDetail save(PostFrItemStockDetail postFrItemStockDetail);
	
	@Query(value="SELECT m_fr_opening_stock_detail.*"
			+ " from m_fr_opening_stock_detail WHERE m_fr_opening_stock_detail.opening_stock_header_id =:headerId",nativeQuery=true)
	List<PostFrItemStockDetail> getFrDetail(@Param("headerId")int headerId);
	
	 
}
