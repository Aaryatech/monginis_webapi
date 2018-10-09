package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.RoutewiseOrdCountBean;

public interface RoutewiseOrdCountBeanRepo extends JpaRepository<RoutewiseOrdCountBean, Integer> {
	
	@Query(value = " SELECT m_fr_route.route_name,m_fr_route.route_id,m_fr_route.route_seq_no,\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			  AND t_sp_cake_sup.status=0  ),0) AS sp_status_zero_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			 AND t_sp_cake_sup.status=1  ),0) AS sp_status_one_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			 AND t_sp_cake_sup.status=2  ),0) AS sp_status_two_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			 AND t_sp_cake_sup.status=3  ),0) AS sp_status_three_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate),0) \n" + 
			"			 AS sp_total_ord_count,\n" + 
			"\n" + 
			"\n" + 
			"coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=0  ),0) AS reg_sp_status_zero_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=1  ),0) AS reg_sp_status_one_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=2  ),0) AS reg_sp_status_two_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=3  ),0) AS reg_sp_status_three_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate),0) \n" + 
			"			 AS reg_sp_total_ord_count \n" + 
			"\n" + 
			"			\n" + 
			"			 FROM m_fr_route WHERE m_fr_route.del_status=0 GROUP BY m_fr_route.route_id ORDER BY m_fr_route.route_seq_no DESC", nativeQuery = true)


	List<RoutewiseOrdCountBean> getRoutewiseOrderCountAllMenu(@Param("prodDate") String prodDate);// B] all menu

	
	@Query(value = " SELECT m_fr_route.route_name,m_fr_route.route_id,m_fr_route.route_seq_no,\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			  AND t_sp_cake_sup.status=0 AND t_sp_cake_sup.menu_id IN (:menuIdList)),0) AS sp_status_zero_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			 AND t_sp_cake_sup.status=1 AND t_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS sp_status_one_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			 AND t_sp_cake_sup.status=2  AND t_sp_cake_sup.menu_id IN (:menuIdList) ),0) AS sp_status_two_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate \n" + 
			"			 AND t_sp_cake_sup.status=3  AND t_sp_cake_sup.menu_id IN (:menuIdList) ),0) AS sp_status_three_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) FROM m_franchisee,t_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.date=:prodDate AND t_sp_cake_sup.menu_id IN (:menuIdList)),0) \n" + 
			"			 AS sp_total_ord_count,\n" + 
			"\n" + 
			"\n" + 
			"coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=0 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_zero_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=1 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_one_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=2 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_two_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate \n" + 
			"			 AND t_reg_sp_cake_sup.status=3 AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)  ),0) AS reg_sp_status_three_ord_count,\n" + 
			"\n" + 
			"			 coalesce((SELECT COUNT(t_reg_sp_cake_sup.sup_id) FROM m_franchisee,t_reg_sp_cake_sup \n" + 
			"			 WHERE m_fr_route.route_id=m_franchisee.fr_route_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.prod_date=:prodDate AND t_reg_sp_cake_sup.menu_id IN (:menuIdList)),0) \n" + 
			"			 AS reg_sp_total_ord_count \n" + 
			"\n" + 
			"			\n" + 
			"			 FROM m_fr_route WHERE m_fr_route.del_status=0 GROUP BY m_fr_route.route_id ORDER BY m_fr_route.route_seq_no DESC", nativeQuery = true)

	
	
	List<RoutewiseOrdCountBean> getRoutewiseOrderCountSpecMenu(@Param("prodDate") String prodDate,
			@Param("menuIdList") List<Integer> menuIdList);// A] specific menu 

}
