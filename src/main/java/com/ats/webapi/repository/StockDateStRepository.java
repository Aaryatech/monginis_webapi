package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.StockDate;

@RestController
public interface StockDateStRepository extends JpaRepository<StockDate, Integer>{

	@Query(value="select (1) as id, coalesce((select store_stock_date from t_store_stock_header where store_stock_status=1 and ex_int1=1 limit 1),0) as date1,coalesce((select store_stock_date from t_store_stock_header where store_stock_status=1 and ex_int1=2 limit 1),0) as date2,coalesce((select store_stock_date from t_store_stock_header h where h.store_stock_status=1 and h.ex_int1=3 limit 1),0) as date3,coalesce((select store_stock_date from t_store_stock_header h where h.store_stock_status=1 and h.ex_int1=4 limit 1),0) as date4,coalesce((select store_stock_date from t_store_stock_header h where h.store_stock_status=1 and h.ex_int1=5 limit 1),0) as date5 ",nativeQuery=true)
	StockDate getStockDates();

}
