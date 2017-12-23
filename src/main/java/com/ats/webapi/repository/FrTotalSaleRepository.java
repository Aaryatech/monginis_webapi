package com.ats.webapi.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.FrTotalSale;

@Repository
public interface FrTotalSaleRepository extends JpaRepository<FrTotalSale, Integer>{

	@Query(value="select fr_id, EXTRACT(MONTH FROM :firstDate) as month,SUM(grand_total) as total_sale from t_sell_bill_header where fr_id=:frId AND bill_date  Between :firstDate AND :lastDate",nativeQuery=true)
	FrTotalSale findFrTotalSale(@Param("frId")int frId,@Param("firstDate") String firstDate,@Param("lastDate") String lastDate);

}
