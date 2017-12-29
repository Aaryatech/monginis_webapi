package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.mixing.GetSFPlanDetailForMixing;

//New Repo Sachin

public interface GetSFPlanDetailForMixingRepo extends JpaRepository<GetSFPlanDetailForMixing, Integer> {

	

	@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN \n" + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total  from m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail "
			+ " where  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND  "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND m_item_detail.rm_type=2 AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	
	
	
	

	//same Bean Used for Bom and Mixing
	
	@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN \n" + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total  from m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail "
			+ "where  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND  "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId);
	
}
