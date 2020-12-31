package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.RoutewiseOrdCountBean;

public interface RoutewiseOrdCountBeanRepo extends JpaRepository<RoutewiseOrdCountBean, Integer> {
	
//	@Query(value = " SELECT m_fr_route.route_name,m_fr_route.route_id,m_fr_route.route_seq_no,\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			  AND t_sp_cake_sup.status=0  ),0) AS sp_status_zero_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			 AND t_sp_cake_sup.status=1  ),0) AS sp_status_one_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			 AND t_sp_cake_sup.status=2  ),0) AS sp_status_two_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			 AND t_sp_cake_sup.status=3  ),0) AS sp_status_three_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate),0) \n" + 
//			"			 AS sp_total_ord_count,\n" + 
//			"\n" + 
//			"\n" + 
//			"coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=0  ),0) AS reg_sp_status_zero_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=1  ),0) AS reg_sp_status_one_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=2  ),0) AS reg_sp_status_two_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=3  ),0) AS reg_sp_status_three_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate),0) \n" + 
//			"			 AS reg_sp_total_ord_count \n" + 
//			"\n" + 
//			"			\n" + 
//			"			 FROM m_fr_route WHERE m_fr_route.del_status=0 GROUP BY m_fr_route.route_id ORDER BY m_fr_route.route_seq_no DESC", nativeQuery = true)
//
//
//	List<RoutewiseOrdCountBean> getRoutewiseOrderCountAllMenu(@Param("prodDate") String prodDate);// B] all menu

	
//	@Query(value = " SELECT m_fr_route.route_name,m_fr_route.route_id,m_fr_route.route_seq_no,\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			  AND t_sp_cake_sup.status=0 AND t_sp_cake_sup.menu_id IN (:menuIdList)),0) AS sp_status_zero_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			 AND t_sp_cake_sup.status=1 AND t_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS sp_status_one_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			 AND t_sp_cake_sup.status=2  AND t_sp_cake_sup.menu_id IN (:menuIdList) ),0) AS sp_status_two_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
//			"			 AND t_sp_cake_sup.status=3  AND t_sp_cake_sup.menu_id IN (:menuIdList) ),0) AS sp_status_three_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate AND t_sp_cake_sup.menu_id IN (:menuIdList)),0) \n" + 
//			"			 AS sp_total_ord_count,\n" + 
//			"\n" + 
//			"\n" + 
//			"coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=0 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_zero_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=1 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_one_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=2 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_two_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
//			"			 AND t_reg_sp_cake_sup.status=3 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_three_ord_count,\n" + 
//			"\n" + 
//			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
//			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)),0) \n" + 
//			"			 AS reg_sp_total_ord_count \n" + 
//			"\n" + 
//			"			\n" + 
//			"			 FROM m_fr_route WHERE m_fr_route.del_status=0 GROUP BY m_fr_route.route_id ORDER BY m_fr_route.route_seq_no DESC", nativeQuery = true)
//
//	
//	
//	List<RoutewiseOrdCountBean> getRoutewiseOrderCountSpecMenu(@Param("prodDate") String prodDate,
//			@Param("menuIdList") List<Integer> menuIdList);// A] specific menu 
	
	
	
	//-----------------------------------------------------------------------------------------------
	
	//----Anmol 17-7-2019
	
	@Query(value = "SELECT t1.*,COALESCE(t2.sp_status_zero_ord_count,0) as sp_status_zero_ord_count,\n" + 
			"COALESCE(t3.sp_status_one_ord_count,0) as sp_status_one_ord_count,\n" + 
			"COALESCE(t4.sp_status_two_ord_count,0) as sp_status_two_ord_count,\n" + 
			"COALESCE(t5.sp_status_three_ord_count,0) AS sp_status_three_ord_count,\n" + 
			"COALESCE(t6.sp_total_ord_count,0) as sp_total_ord_count,\n" + 
			"COALESCE(t7.reg_sp_status_zero_ord_count,0) as reg_sp_status_zero_ord_count,\n" + 
			"COALESCE(t8.reg_sp_status_one_ord_count,0) as reg_sp_status_one_ord_count,\n" + 
			"COALESCE(t9.reg_sp_status_two_ord_count,0) as reg_sp_status_two_ord_count,\n" + 
			"COALESCE(t10.reg_sp_status_three_ord_count,0) as reg_sp_status_three_ord_count,\n" + 
			"COALESCE(t11.reg_sp_total_ord_count,0) as reg_sp_total_ord_count,\n" + 
			"COALESCE(t12.album_status_zero_ord_count,0) as album_status_zero_ord_count,\n" + 
			"COALESCE(t13.album_status_one_ord_count,0) as album_status_one_ord_count,\n" + 
			"COALESCE(t14.album_status_two_ord_count,0) as album_status_two_ord_count,\n" + 
			"COALESCE(t15.album_status_three_ord_count,0) as album_status_three_ord_count,\n" + 
			"COALESCE(t16.album_total_ord_count,0) as album_total_ord_count\n" + 
			"\n" + 
			"FROM \n" + 
			"(\n" + 
			"    SELECT\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_fr_route.route_id,\n" + 
			"    m_fr_route.route_seq_no,\n" + 
			"	1 as flag\n" + 
			"FROM\n" + 
			"    m_fr_route\n" + 
			"WHERE\n" + 
			"    m_fr_route.del_status = 0\n" + 
			"GROUP BY\n" + 
			"    m_fr_route.route_id\n" + 
			"ORDER BY\n" + 
			"    m_fr_route.route_seq_no\n" + 
			"DESC\n" + 
			"    ) t1\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_zero_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"           t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 0 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 GROUP BY m_franchisee.fr_route_id\n" + 
			") t2 ON t1.route_id=t2.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_one_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 1 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 GROUP BY m_franchisee.fr_route_id\n" + 
			") t3 ON t1.route_id=t3.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_two_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"           t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 2 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 GROUP BY m_franchisee.fr_route_id\n" + 
			") t4 ON t1.route_id=t4.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_three_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"           t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 3 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 GROUP BY m_franchisee.fr_route_id\n" + 
			") t5 ON t1.route_id=t5.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT\n" + 
			"    m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_total_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 GROUP BY m_franchisee.fr_route_id\n" + 
			") t6 ON t1.route_id=t6.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_zero_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 0 GROUP BY m_franchisee.fr_route_id\n" + 
			")t7 on t1.route_id=t7.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_one_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 1 GROUP BY m_franchisee.fr_route_id\n" + 
			")t8 on t1.route_id=t8.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_two_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 2 GROUP BY m_franchisee.fr_route_id\n" + 
			")t9 on t1.route_id=t9.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_three_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 3 GROUP BY m_franchisee.fr_route_id\n" + 
			")t10 on t1.route_id=t10.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_total_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate GROUP BY m_franchisee.fr_route_id\n" + 
			")t11 on t1.route_id=t11.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_zero_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 0 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 GROUP BY m_franchisee.fr_route_id\n" + 
			")t12 on t1.route_id=t12.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_one_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 1 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 GROUP BY m_franchisee.fr_route_id\n" + 
			")t13 on t1.route_id=t13.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_two_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 2 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 GROUP BY m_franchisee.fr_route_id\n" + 
			")t14 on t1.route_id=t14.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_three_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 3 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 GROUP BY m_franchisee.fr_route_id\n" + 
			")t15 on t1.route_id=t15.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_total_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 GROUP BY m_franchisee.fr_route_id\n" + 
			")t16 on t1.route_id=t16.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"", nativeQuery = true)


	List<RoutewiseOrdCountBean> getRoutewiseOrderCountAllMenu(@Param("prodDate") String prodDate);// B] all menu
	
	
	
	
	@Query(value = " SELECT t1.*,COALESCE(t2.sp_status_zero_ord_count,0) as sp_status_zero_ord_count,\n" + 
			"COALESCE(t3.sp_status_one_ord_count,0) as sp_status_one_ord_count,\n" + 
			"COALESCE(t4.sp_status_two_ord_count,0) as sp_status_two_ord_count,\n" + 
			"COALESCE(t5.sp_status_three_ord_count,0) AS sp_status_three_ord_count,\n" + 
			"COALESCE(t6.sp_total_ord_count,0) as sp_total_ord_count,\n" + 
			"COALESCE(t7.reg_sp_status_zero_ord_count,0) as reg_sp_status_zero_ord_count,\n" + 
			"COALESCE(t8.reg_sp_status_one_ord_count,0) as reg_sp_status_one_ord_count,\n" + 
			"COALESCE(t9.reg_sp_status_two_ord_count,0) as reg_sp_status_two_ord_count,\n" + 
			"COALESCE(t10.reg_sp_status_three_ord_count,0) as reg_sp_status_three_ord_count,\n" + 
			"COALESCE(t11.reg_sp_total_ord_count,0) as reg_sp_total_ord_count,\n" + 
			"COALESCE(t12.album_status_zero_ord_count,0) as album_status_zero_ord_count,\n" + 
			"COALESCE(t13.album_status_one_ord_count,0) as album_status_one_ord_count,\n" + 
			"COALESCE(t14.album_status_two_ord_count,0) as album_status_two_ord_count,\n" + 
			"COALESCE(t15.album_status_three_ord_count,0) as album_status_three_ord_count,\n" + 
			"COALESCE(t16.album_total_ord_count,0) as album_total_ord_count\n" + 
			"\n" + 
			"FROM \n" + 
			"(\n" + 
			"    SELECT\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_fr_route.route_id,\n" + 
			"    m_fr_route.route_seq_no,\n" + 
			"	1 as flag\n" + 
			"FROM\n" + 
			"    m_fr_route\n" + 
			"WHERE\n" + 
			"    m_fr_route.del_status = 0\n" + 
			"GROUP BY\n" + 
			"    m_fr_route.route_id\n" + 
			"ORDER BY\n" + 
			"    m_fr_route.route_seq_no\n" + 
			"DESC\n" + 
			"    ) t1\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_zero_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"           t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 0 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 AND t_sp_cake_sup.menu_id IN(:menuIdList) GROUP BY m_franchisee.fr_route_id\n" + 
			") t2 ON t1.route_id=t2.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_one_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 1 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			") t3 ON t1.route_id=t3.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_two_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"           t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 2 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			") t4 ON t1.route_id=t4.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT	m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_status_three_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"           t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 3 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			") t5 ON t1.route_id=t5.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"     SELECT\n" + 
			"    m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as sp_total_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 0 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			") t6 ON t1.route_id=t6.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_zero_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 0 AND t_reg_sp_cake_sup.menu_id IN(:menuIdList)   GROUP BY m_franchisee.fr_route_id\n" + 
			")t7 on t1.route_id=t7.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_one_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 1 AND t_reg_sp_cake_sup.menu_id IN(:menuIdList) GROUP BY m_franchisee.fr_route_id\n" + 
			")t8 on t1.route_id=t8.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_two_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 2 AND t_reg_sp_cake_sup.menu_id IN(:menuIdList) GROUP BY m_franchisee.fr_route_id\n" + 
			")t9 on t1.route_id=t9.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_status_three_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.status = 3 AND t_reg_sp_cake_sup.menu_id IN(:menuIdList) GROUP BY m_franchisee.fr_route_id\n" + 
			")t10 on t1.route_id=t10.fr_route_id\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_reg_sp_cake_sup.sup_id) as reg_sp_total_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_reg_sp_cake_sup\n" + 
			"        WHERE\n" + 
			"            t_reg_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date = :prodDate AND t_reg_sp_cake_sup.menu_id IN(:menuIdList) GROUP BY m_franchisee.fr_route_id\n" + 
			")t11 on t1.route_id=t11.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_zero_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 0 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			")t12 on t1.route_id=t12.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_one_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 1 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			")t13 on t1.route_id=t13.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_two_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 2 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			")t14 on t1.route_id=t14.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_status_three_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.status = 3 AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			")t15 on t1.route_id=t15.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN (\n" + 
			"SELECT\n" + 
			"    		m_franchisee.fr_route_id,\n" + 
			"            COUNT(t_sp_cake_sup.t_sp_cake_sup_no) as album_total_ord_count\n" + 
			"        FROM\n" + 
			"            m_franchisee,\n" + 
			"            t_sp_cake_sup,\n" + 
			"            t_sp_cake\n" + 
			"        WHERE\n" + 
			"            t_sp_cake_sup.fr_id = m_franchisee.fr_id AND t_sp_cake_sup.date = :prodDate AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated = 1 AND t_sp_cake_sup.menu_id IN(:menuIdList)  GROUP BY m_franchisee.fr_route_id\n" + 
			")t16 on t1.route_id=t16.fr_route_id\n" + 
			"\n" + 
			"\n" + 
			"", nativeQuery = true)

	
	
	List<RoutewiseOrdCountBean> getRoutewiseOrderCountSpecMenu(@Param("prodDate") String prodDate,
			@Param("menuIdList") List<Integer> menuIdList);// A] specific menu 

}
