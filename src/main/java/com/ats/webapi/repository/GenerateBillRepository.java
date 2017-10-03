package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GenerateBill;

public interface GenerateBillRepository extends JpaRepository<GenerateBill, Integer> {
	
	
	@Query(value=" SELECT t_order.order_id ,t_order.fr_id, t_order.menu_id ,t_order.item_id,t_order.order_qty,"
			+ " t_order.order_rate,t_order.order_mrp , m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_rate_cat, m_fr_menu_show.menu_title,"
			+ " m_item.item_name,m_item.item_grp1,m_item.item_grp2 from t_order,m_franchisee, m_fr_menu_show ,"
			+ " m_item where t_order.fr_id IN (:frId) AND t_order.delivery_date=:delDate "
			+ " AND t_order.menu_id IN (:menuId) AND m_franchisee.fr_id=t_order.fr_id AND "
			+ " t_order.menu_id=m_fr_menu_show.menu_id AND t_order.item_id=m_item.id  " + 
			"",nativeQuery=true)
	
	List<GenerateBill> generateBill(@Param("frId")List<Integer> frId,@Param("menuId")List<Integer> menuId,@Param("delDate")String delDate);

	
	@Query(value=" SELECT t_order.order_id ,t_order.fr_id, t_order.menu_id ,t_order.item_id,t_order.order_qty,"
			+ " t_order.order_rate,t_order.order_mrp , m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_rate_cat, m_fr_menu_show.menu_title,"
			+ " m_item.item_name,m_item.item_grp1,m_item.item_grp2 from t_order,m_franchisee, m_fr_menu_show ,"
			+ " m_item where t_order.delivery_date=:delDate "
			+ " AND t_order.menu_id IN (:menuId) AND m_franchisee.fr_id=t_order.fr_id AND "
			+ " t_order.menu_id=m_fr_menu_show.menu_id AND t_order.item_id=m_item.id  " + 
			"",nativeQuery=true)
	
	List<GenerateBill> generateBillForAllFr(@Param("menuId")List<Integer> menuId,@Param("delDate")String delDate);

	
	@Query(value=" SELECT t_order.order_id ,t_order.fr_id, t_order.menu_id ,t_order.item_id,t_order.order_qty,"
			+ " t_order.order_rate,t_order.order_mrp , m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_rate_cat, m_fr_menu_show.menu_title,"
			+ " m_item.item_name,m_item.item_grp1,m_item.item_grp2 from t_order,m_franchisee, m_fr_menu_show ,"
			+ " m_item where t_order.delivery_date=:delDate "
			+ "  AND m_franchisee.fr_id=t_order.fr_id AND "
			+ " t_order.menu_id=m_fr_menu_show.menu_id AND t_order.item_id=m_item.id  " + 
			"",nativeQuery=true)
	
	List<GenerateBill> generateBillForAllFrAllMenu(@Param("delDate")String delDate);

	@Query(value=" SELECT t_order.order_id ,t_order.fr_id, t_order.menu_id ,t_order.item_id,t_order.order_qty,"
			+ " t_order.order_rate,t_order.order_mrp , m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_rate_cat, m_fr_menu_show.menu_title,"
			+ " m_item.item_name,m_item.item_grp1,m_item.item_grp2 from t_order,m_franchisee, m_fr_menu_show ,"
			+ " m_item where t_order.fr_id IN (:frId) AND t_order.delivery_date=:delDate "
			+ " AND m_franchisee.fr_id=t_order.fr_id AND "
			+ " t_order.menu_id=m_fr_menu_show.menu_id AND t_order.item_id=m_item.id  " + 
			"",nativeQuery=true)
	
	List<GenerateBill> generateBillForAllMenu(@Param("frId")List<Integer> frId,@Param("delDate")String delDate);

	
	
}
