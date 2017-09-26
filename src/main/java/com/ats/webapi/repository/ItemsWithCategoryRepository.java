package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemsWithCategory;



public interface ItemsWithCategoryRepository extends JpaRepository<ItemsWithCategory, Integer>{
	
	
	@Query (value=" SELECT m_item.id,m_item.item_name,m_category.cat_name from "
			+ " m_item,m_category WHERE m_item.item_grp1=m_category.cat_id AND m_item.del_status=0 "+ 
			" ",nativeQuery=true)
	List<ItemsWithCategory> getAllItemsWithCategory();
	 

}
