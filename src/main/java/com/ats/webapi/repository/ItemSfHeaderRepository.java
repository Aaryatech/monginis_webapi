package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Orders;
import com.ats.webapi.model.rawmaterial.GetItemSfHeader;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;

@Repository
public interface  ItemSfHeaderRepository extends JpaRepository<GetItemSfHeader, Integer>{

//manual query two tables
	
	@Query(value = "SELECT m_sf_type.sf_type_name, m_item_sf_header.sf_name,m_item_sf_header.sf_id,"
			+ "m_item_sf_header.sf_type,"
			+ "m_item_sf_header.sf_uom_id,m_item_sf_header.sf_weight,m_item_sf_header.stock_qty,"
			+ "m_item_sf_header.min_level_qty,"
			+ "m_item_sf_header.max_level_qty,"
			+ "m_item_sf_header.reorder_level_qty,m_item_sf_header.del_status"
			+ " from m_item_sf_header,m_sf_type WHERE"
			+ " m_item_sf_header.sf_type=m_sf_type.id AND m_item_sf_header.del_status=:delStatus", nativeQuery = true)

	List<GetItemSfHeader> getSfItemHeader(@Param("delStatus")int delStatus);
	
}
