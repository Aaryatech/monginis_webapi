package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.DashRegSpCakeCount;

public interface DashRegSpCakeCountRepo extends JpaRepository<DashRegSpCakeCount, Integer> {

	/*
	 * select COUNT(t_reg_sp_cake_sup.sup_id) AS
	 * reg_sp_order_count,t_reg_sp_cake_sup.status FROM t_reg_sp_cake_sup WHERE
	 * t_reg_sp_cake_sup.status IN(0,1,2) and t_reg_sp_cake_sup.prod_date=:prodDate
	 * AND t_reg_sp_cake_sup.menu_id IN (:menuIdList) GROUP BY
	 * t_reg_sp_cake_sup.status
	 */
	@Query(value = " SELECT COUNT(t_reg_sp_cake_sup.sup_id) AS reg_sp_order_count,t_reg_sp_cake_sup.status "
			+ " FROM t_reg_sp_cake_sup WHERE t_reg_sp_cake_sup.status IN(0,1,2) AND "
			+ " t_reg_sp_cake_sup.prod_date=:prodDate AND t_reg_sp_cake_sup.menu_id IN (:menuIdList) "
			+ " GROUP BY t_reg_sp_cake_sup.status   ", nativeQuery = true)
	List<DashRegSpCakeCount> getRegSpCakeOrdCountSpecMenu(@Param("prodDate") String prodDate,
			@Param("menuIdList") List<Integer> menuIdList);

	@Query(value = " SELECT COUNT(t_reg_sp_cake_sup.sup_id) AS reg_sp_order_count,t_reg_sp_cake_sup.status "
			+ "	FROM t_reg_sp_cake_sup WHERE t_reg_sp_cake_sup.status IN(0,1,2) AND "
			+ "	 t_reg_sp_cake_sup.prod_date=:prodDate GROUP BY t_reg_sp_cake_sup.status  ", nativeQuery = true)
	List<DashRegSpCakeCount> getRegSpCakeOrdCountAllMenu(@Param("prodDate") String prodDate);

}
