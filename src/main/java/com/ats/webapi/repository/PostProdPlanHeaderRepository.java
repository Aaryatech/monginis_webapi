package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.PostProdPlanHeader;

@Repository
public interface PostProdPlanHeaderRepository extends JpaRepository<PostProdPlanHeader, Integer>{

	
	@Query(value="SELECT production_header_id,production_date,cat_id,MAX(time_slot) as time_slot,production_batch,production_status,production_date,is_mixing,is_bom,del_status FROM t_production_plan_header  "
			+ "WHERE production_date=:strDate And cat_id=:catId ",nativeQuery=true)
	PostProdPlanHeader findTopTimeSlotByProductionDateAndCatId(@Param("strDate")String strDate,@Param("catId") int catId);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE PostProdPlanHeader SET is_mixing=1 WHERE production_header_id=:productionId")
	int updateisMixing(@Param("productionId")int productionId);

}
