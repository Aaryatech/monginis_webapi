package com.ats.webapi.repository.bmsstock;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.FinishedGoodStockDetail;

public interface FinishedGoodStockDetailRepo  extends JpaRepository<FinishedGoodStockDetail, Integer> {

	FinishedGoodStockDetail save(FinishedGoodStockDetail finishedGoodStockDetail);
	
	List<FinishedGoodStockDetail> findByStockDateAndCatId(Date stockDate,int catId);
	
	@Query(value=" SELECT d.cat_id, d.op_t1,d.op_t2,d.op_t3,d.stock_date,d.item_id,d.item_name,SUM(d.op_total) AS op_total,SUM(d.prod_qty)AS prod_qty ,SUM(d.rej_qty) AS rej_qty,\n" + 
			"SUM(d.fr_sale_qty) AS fr_sale_qty,SUM(d.gate_sale_qty)AS gate_sale_qty,d.clo_t1,d.clo_t2,d.clo_t3,SUM(d.clo_current) AS clo_current,SUM(d.total_clo_stk) AS total_clo_stk,d.fin_stock_detail_id,\n" + 
			"d.fin_stock_id,d.del_status\n" + 
			" FROM finished_good_stock_detail d,\n" + 
			"			finished_good_stock h WHERE h.fin_good_stock_status=:stockStatus AND h.fin_stock_id=d.fin_stock_id\n" + 
			"			 AND d.stock_date BETWEEN :fromDate AND :toDate  GROUP BY d.item_id\n" + 
			"" + 
			"",nativeQuery=true)
	
		List<FinishedGoodStockDetail> findByStockDateBetween(@Param("fromDate")Date fromStockDate, 
			@Param("toDate")Date toStockDate,@Param("stockStatus") int stockStatus);

	List<FinishedGoodStockDetail> findByStockDate(Date stkDate);
	
}
