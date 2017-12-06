package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetProductionItemQty;


@Repository
public interface GetProductionItemQtyRepository extends JpaRepository<GetProductionItemQty, Integer>{

	
	@Query(value = "SELECT t_production_plan_header.production_header_id, t_production_plan_detail.production_detail_id ,t_production_plan_header.production_date, SUM(t_production_plan_detail.production_qty) as qty, t_production_plan_detail.item_id, m_item.item_name FROM t_production_plan_header,t_production_plan_detail, m_item WHERE t_production_plan_header.production_date =:productionDate AND  t_production_plan_header.cat_id=:catId AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND m_item.id=t_production_plan_detail.item_id GROUP BY t_production_plan_detail.item_id", nativeQuery = true)
	List<GetProductionItemQty> findProdItemQty(@Param("productionDate") String productionDate, @Param("catId") int catId);

}
