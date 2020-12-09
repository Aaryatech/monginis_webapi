package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MenuOrderLimit;

@Repository
public interface MenuOrderLimitRepo extends JpaRepository<MenuOrderLimit, Integer>{

	@Query(value = "SELECT uuid() as id,t1.menu_id,t1.menu_title,t1.cat_id,t2.sub_cat_id,t2.sub_cat_name,0 as qty_limit FROM\r\n" + 
			"(\r\n" + 
			"SELECT m.* FROM m_fr_menu_show m  WHERE m.del_status=0 AND m.cat_id=5\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN\r\n" + 
			"(\r\n" + 
			"    SELECT s.* FROM m_cat_sub s WHERE s.del_status=0 \r\n" + 
			") t2 ON t1.cat_id=t2.cat_id\r\n" + 
			"ORDER BY t1.menu_id, t2.sub_cat_name", nativeQuery = true)
	public List<MenuOrderLimit> getMenuWiseSubCatForLimit();
	
}
