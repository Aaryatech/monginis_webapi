package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.RegularSpecialStockCal;

public interface StockCalculationRepository extends JpaRepository<RegularSpecialStockCal, Integer> {
	
	
	@Query(value = "SELECT  COALESCE(SUM(CASE WHEN grn_type != 3 THEN bill_qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN grn_type = 3 THEN bill_qty ELSE 0 END),0) as sp  "
			+ "  FROM t_bill_detail WHERE t_bill_detail.item_id=:itemId AND t_bill_detail.bill_no"
			+ " IN(SELECT t_bill_header.bill_no FROM t_bill_header WHERE t_bill_header.fr_id=:frId  AND t_bill_header.status =2  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate )", nativeQuery = true)
	RegularSpecialStockCal getTotalPurchase(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("itemId") int itemId);

	@Query(value = "SELECT  COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) FROM t_grn_gvn WHERE t_grn_gvn.fr_id=:frId AND t_grn_gvn.item_id=:itemId AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	int getRegTotalGrnGvn(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemId") int itemId);

	@Query(value = "SELECT COALESCE(SUM(CASE WHEN bill_stock_type = 1 THEN qty ELSE 0 END),0) as reg , COALESCE(SUM(CASE WHEN bill_stock_type = 2 THEN qty ELSE 0 END),0) as sp FROM t_sell_bill_detail WHERE t_sell_bill_detail.item_id =:itemId AND "
			+ "t_sell_bill_detail.sell_bill_no IN (SELECT t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate)", nativeQuery = true)
	RegularSpecialStockCal getRegTotalSell(@Param("frId") int frId, @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemId") int itemId);

}
