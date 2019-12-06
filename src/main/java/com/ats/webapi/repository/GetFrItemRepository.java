package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemWithSubCat;

public interface GetFrItemRepository extends  CrudRepository<ItemWithSubCat, Long>{
		

	 @Query(value = " SELECT m_item.* , m_cat_sub.sub_cat_name FROM m_item , m_cat_sub WHERE m_item.id IN(:items) AND m_cat_sub.sub_cat_id = m_item.item_grp2 AND m_item.del_status=0 and item_is_used=1 order by item_sort_id", nativeQuery = true)
	    List<ItemWithSubCat> findFrItems(@Param ("items") List<Integer>items);
	 
	 @Query(value = " SELECT m_item.* , m_cat_sub.sub_cat_name, COALESCE((SELECT min_qty FROM m_fr_item_stock WHERE type=:type AND item_id=m_item.id),0) as qty_limit FROM m_item , m_cat_sub WHERE m_item.id IN(:items) AND m_cat_sub.sub_cat_id = m_item.item_grp2 AND m_item.del_status=0 and item_is_used=1  order by item_sort_id", nativeQuery = true)
	    List<ItemWithSubCat> findFrItemsWithLimit(@Param ("items") List<Integer>items,@Param ("type") int type);
	
	
}



