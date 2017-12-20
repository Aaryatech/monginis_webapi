package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.BmsStockHeader;

public interface BmsStockHeaderRepository extends JpaRepository<BmsStockHeader,Long>{
	
	BmsStockHeader save(BmsStockHeader bmsStockHeader);

	
	
	//BmsStockHeader findByBmsStockDateAndRmType(Date bmsStockDate, int rmType);


	@Query(value=" SELECT * FROM t_bms_stock WHERE "
			+ "bms_stock_date =:stockDate AND rm_type=:rmType"
			+ "",nativeQuery=true)
	BmsStockHeader getStockDetails(@Param("stockDate")String stockDate, @Param("rmType")int rmType);



	 

}
