package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.tray.CalCulateTray;

public interface CalculateTrayRepo extends JpaRepository<CalCulateTray, Integer> {

	@Query(value = "SELECT\r\n" + "    t_order.order_id,\r\n" + "    m_franchisee.fr_id,\r\n"
			+ "    m_franchisee.fr_route_id,\r\n" + "    m_fr_route.route_name,\r\n" + "    m_franchisee.fr_name,\r\n"
			+ "    m_cat_sub.sub_cat_id,\r\n" + "    m_cat_sub.sub_cat_name,\r\n"
			+ "    SUM(t_order.order_qty) AS order_qty,\r\n" + "     COALESCE(\r\n" + 
					"        (\r\n" + 
					"            CEILING(SUM(\r\n" + 
					"                \r\n" + 
					"                    (\r\n" + 
					"                        t_order.order_qty / m_item_sup.no_of_item_per_tray\r\n" + 
					"                    )\r\n" + 
					"                \r\n" + 
					"            ))\r\n" + 
					"        ),\r\n" + 
					"        0\r\n" + 
					"    ) AS tray_qty \r\n" + "FROM\r\n"
			+ "    t_order,\r\n" + "    m_cat_sub,\r\n" + "    m_franchisee,\r\n" + "    m_item_sup,\r\n"
			+ "    m_fr_route\r\n" + "WHERE\r\n"
			+ "    m_franchisee.fr_id = t_order.fr_id AND m_cat_sub.sub_cat_id = t_order.order_sub_type AND t_order.delivery_date =:deliveryDate AND t_order.menu_id IN(:menuIdList) AND t_order.fr_id IN(:frIdList)  AND m_item_sup.item_id = t_order.item_id\r\n"
			+ "    AND m_franchisee.fr_route_id=m_fr_route.route_id\r\n" + "\r\n"
			+ "GROUP BY t_order.fr_id,t_order.order_sub_type  ORDER BY t_order.fr_id,t_order.order_type,t_order.order_sub_type ", nativeQuery = true)
	List<CalCulateTray> getCalculateTray(@Param("deliveryDate") String deliveryDate,
			@Param("frIdList") List<Integer> frIdList, @Param("menuIdList") List<Integer> menuIdList);

}
