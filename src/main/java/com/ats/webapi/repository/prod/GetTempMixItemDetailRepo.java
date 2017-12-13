package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.temp.GetTempMixItemDetail;

public interface GetTempMixItemDetailRepo extends JpaRepository<GetTempMixItemDetail, Integer> {
	
	@Query(value=" SELECT m_item_sf_detail.sf_id,m_item_sf_detail.rm_id,t_mixing_temp.temp_id,m_item_sf_detail.rm_name,"
			+ "m_item_sf_detail.rm_type,m_rm_uom.uom "
			+ ",SUM(t_mixing_temp.qty * m_item_sf_detail.rm_qty*m_item_sf_detail.rm_weight) AS total "
			+ "FROM m_item_sf_detail,m_rm_uom,t_mixing_temp WHERE "
			+ "m_item_sf_detail.sf_id=t_mixing_temp.rm_id AND m_rm_uom.uom_id=m_item_sf_detail.rm_unit"
			+ " AND m_item_sf_detail.rm_type=2 AND t_mixing_temp.prod_header_id=:prodHeaderId "
			+ "GROUP BY m_item_sf_detail.rm_id ",nativeQuery=true)
		

	List<GetTempMixItemDetail> getMxItemDetail(@Param("prodHeaderId") int prodHeaderId);
	
	
	
}
