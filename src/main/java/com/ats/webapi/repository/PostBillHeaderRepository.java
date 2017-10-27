package com.ats.webapi.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Orders;
import com.ats.webapi.model.PostBillHeader;

public interface PostBillHeaderRepository extends JpaRepository<PostBillHeader, Integer> {
	
	PostBillHeader save(PostBillHeader postBillHeader);
	
	
	
	@Query(value = "SELECT  COALESCE(SUM(bill_qty),0)  FROM t_bill_detail WHERE t_bill_detail.item_id=:itemId AND t_bill_detail.bill_no IN(SELECT t_bill_header.bill_no"
			+ " FROM t_bill_header WHERE t_bill_header.fr_id=:frId  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate )", nativeQuery = true)
	int getTotalPurchase(@Param("frId") int frId,@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);


	@Query(value = "SELECT  COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) FROM t_grn_gvn WHERE t_grn_gvn.fr_id=:frId AND t_grn_gvn.item_id=:itemId AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	int getTotalGrnGvn(@Param("frId") int frId,@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);

	
	
	@Query(value = "SELECT COALESCE( SUM(t_sell_bill_detail.qty) ,0) FROM t_sell_bill_detail WHERE t_sell_bill_detail.item_id =:itemId AND t_sell_bill_detail.sell_bill_no"
			+ " IN(SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate)", nativeQuery = true)
	int getTotalSell(@Param("frId") int frId,@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("itemId") int itemId);

	
	
	@Query(value = "SELECT m_fr_opening_stock_detail.opening_stock FROM m_fr_opening_stock_detail WHERE m_fr_opening_stock_detail.item_id=:itemId AND m_fr_opening_stock_detail.opening_stock_header_id" + 
			" IN(SELECT m_fr_opening_stock_header.opening_stock_header_id FROM m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id=:frId AND m_fr_opening_stock_header.month=10)", nativeQuery = true)
	int getOpeningStock(@Param("frId") int frId,@Param("fromDate") String fromDate, @Param("itemId") int itemId);

	
	
	/*
	SELL -
	SELECT  SUM(t_sell_bill_detail.qty) FROM t_sell_bill_detail WHERE t_sell_bill_detail.item_id =8  AND t_sell_bill_detail.sell_bill_no IN(SELECT t_sell_bill_header.sell_bill_no 
	FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=37 AND t_sell_bill_header.bill_date BETWEEN '2017-10-01' AND '2017-10-26')

	Stock-
	SELECT m_fr_opening_stock_detail.opening_stock FROM m_fr_opening_stock_detail WHERE m_fr_opening_stock_detail.item_id=22 AND m_fr_opening_stock_detail.opening_stock_header_id
	 IN(SELECT m_fr_opening_stock_header.opening_stock_header_id FROM m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id=17 AND m_fr_opening_stock_header.month=10)
	*/
	
	
}
