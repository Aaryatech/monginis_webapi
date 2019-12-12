package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ProdItemStock;

public interface ProdItemStockRepo extends JpaRepository<ProdItemStock, Integer> {
	
	@Query(value = "SELECT UUID() AS unique_id, t1.id, t1.item_name, t1.item_grp1, COALESCE((t2.item_limit), 0) AS item_limit, "
			+ "COALESCE((t2.type), 0) AS type, COALESCE((t3.tot_fr), 0) AS tot_fr "
			+ "FROM ( SELECT i.id, i.item_name, i.item_grp1 FROM m_item i WHERE i.item_grp1 =:catId AND i.del_status = 0 GROUP BY i.id ) "
			+ "AS t1 LEFT JOIN( SELECT s.item_id AS id, s.min_qty AS item_limit, s.type FROM m_fr_item_stock s, m_item i "
			+ "WHERE s.item_id = i.id ) AS t2 ON t1.id = t2.id LEFT JOIN( SELECT f.stock_type AS type, COUNT(f.fr_id) AS tot_fr "
			+ "FROM m_franchisee f WHERE f.del_status = 0 GROUP BY f.stock_type ) AS t3 ON t2.type = t3.type ", nativeQuery = true)
	public List<ProdItemStock> getItemwiseStocklimit(@Param("catId") int catId);

}
