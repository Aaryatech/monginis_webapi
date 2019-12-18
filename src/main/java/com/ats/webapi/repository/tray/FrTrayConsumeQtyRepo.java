package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.FrTrayConsumeQty;

@Repository
public interface FrTrayConsumeQtyRepo extends JpaRepository<FrTrayConsumeQty, Integer> {

	/*@Query(value="SELECT\r\n" + 
			"    t_order.order_id,\r\n" + 
			"    t_order.fr_id,\r\n" + 
			"    SUM(t_order.order_qty) AS order_qty,\r\n" + 
			"    COALESCE(\r\n" + 
			"        (\r\n" + 
			"            CEILING(\r\n" + 
			"                (\r\n" + 
			"                    SUM(t_order.order_qty) / m_item_sup.no_of_item_per_tray\r\n" + 
			"                )\r\n" + 
			"            )\r\n" + 
			"        ),\r\n" + 
			"        0\r\n" + 
			"    ) AS tray_qty\r\n" + 
			"FROM\r\n" + 
			"    t_order,\r\n" + 
			"    m_cat_sub,\r\n" + 
			"    m_item_sup\r\n" + 
			"WHERE\r\n" + 
			"    m_cat_sub.sub_cat_id = t_order.order_sub_type AND t_order.delivery_date = :deliveryDate AND t_order.fr_id IN(:frId)  AND m_item_sup.item_id = t_order.item_id AND m_cat_sub.del_status=0 AND m_item_sup.del_status=0\r\n" + 
			"GROUP BY\r\n" + 
			"    t_order.fr_id,\r\n" + 
			"    t_order.order_sub_type\r\n" + 
			"ORDER BY\r\n" + 
			"    t_order.order_type,\r\n" + 
			"    t_order.order_sub_type  ",nativeQuery=true)
	List<FrTrayConsumeQty> getFrConsumeTrayList(@Param("frId") int frId,@Param("deliveryDate") String deliveryDate);*/
	
	
	@Query(value="SELECT\r\n" + 
			"    t_order.order_id,\r\n" + 
			"    t_order.fr_id,\r\n" + 
			"    COALESCE((SUM(t_order.order_qty)),0) AS order_qty,\r\n" + 
			"    COALESCE(\r\n" + 
			"         CEILING(SUM(\r\n" + 
			"            (\r\n" + 
			"               \r\n" + 
			"                    (\r\n" + 
			"                        t_order.order_qty / m_item_sup.no_of_item_per_tray\r\n" + 
			"                    )\r\n" + 
			"                \r\n" + 
			"            )\r\n" + 
			"        )),\r\n" + 
			"        0\r\n" + 
			"    ) AS tray_qty" + 
			" FROM\r\n" + 
			"    t_order,\r\n" + 
			"    m_cat_sub,\r\n" + 
			"    m_item_sup\r\n" + 
			"WHERE\r\n" + 
			"    m_cat_sub.sub_cat_id = t_order.order_sub_type AND t_order.delivery_date =:deliveryDate AND t_order.fr_id IN(:frId) AND m_item_sup.item_id = t_order.item_id\r\n" + 
			"GROUP BY\r\n" + 
			"    t_order.fr_id  ",nativeQuery=true)
	FrTrayConsumeQty getFrConsumeTrayList(@Param("frId") int frId,@Param("deliveryDate") String deliveryDate);

	
}
