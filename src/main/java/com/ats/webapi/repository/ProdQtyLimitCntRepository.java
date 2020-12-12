package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ProdQtyLimitCnt;

public interface ProdQtyLimitCntRepository extends JpaRepository<ProdQtyLimitCnt,Integer> {
	
	
	@Query(value="SELECT\n" + 
			"	menu_id,\n" + 
			"    COUNT('') AS prod_count,\n" + 
			"    0 AS total\n" + 
			"FROM\n" + 
			"    t_sp_cake\n" + 
			"WHERE\n" + 
			"    sp_prod_date = :prodDate AND del_status = 0\n" + 
			"GROUP BY\n" + 
			"	menu_id",nativeQuery=true)
	List<ProdQtyLimitCnt> getProdQtyLimitCntList(@Param("prodDate") String prodDate);

}
