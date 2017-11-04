package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.PostFrItemStockHeader;

public interface PostFrOpStockHeaderRepository extends JpaRepository<PostFrItemStockHeader, Integer> {
	
	PostFrItemStockHeader save(PostFrItemStockHeader postFrItemStockHeader);
	
	@Query(value="SELECT m_fr_opening_stock_header.*"
			+ " from m_fr_opening_stock_header WHERE m_fr_opening_stock_header.opening_stock_header_id =:headerId",nativeQuery=true)
	PostFrItemStockHeader getHeader(@Param("headerId")int headerId);

	
	@Transactional
	@Modifying
	@Query("UPDATE PostFrItemStockHeader SET isMonthClosed=1 WHERE openingStockHeaderId=:headerId")
	int endMonth(@Param("headerId") int headerId);
	
	//frId , from and to date
	@Query(value="SELECT m_fr_opening_stock_header.*"
			+ " from m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id =:frId AND m_fr_opening_stock_header.month=:month AND m_fr_opening_stock_header.year=:year ",nativeQuery=true)
	PostFrItemStockHeader getFrHeader(@Param("frId")int frId, @Param("month")int month, @Param("year")int year );
}