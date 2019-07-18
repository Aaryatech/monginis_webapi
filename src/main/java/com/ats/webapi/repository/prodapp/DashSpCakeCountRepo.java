package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.DashSpCakeCount;

public interface DashSpCakeCountRepo extends JpaRepository<DashSpCakeCount, Integer> {

	/*
	 * select COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS
	 * order_count,t_sp_cake_sup.status FROM t_sp_cake_sup WHERE
	 * t_sp_cake_sup.status IN(0,1,2) and t_sp_cake_sup.date='2018-10-03' AND
	 * menu_id=40 GROUP BY t_sp_cake_sup.status
	 */

	
	/*@Query(value = " SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS sp_order_count,t_sp_cake_sup.status FROM "
			+ " t_sp_cake_sup WHERE t_sp_cake_sup.status IN(0,1,2) and t_sp_cake_sup.del_status=0 and t_sp_cake_sup.date=:prodDate "
			+ " AND menu_id IN (:menuIdList) GROUP BY t_sp_cake_sup.status  ", nativeQuery = true)
	List<DashSpCakeCount> getSpCakeOrdCountSpecMenu(@Param("prodDate") String prodDate,@Param("menuIdList") List<Integer> menuIdList);
	*/
	
	/*@Query(value = " SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS sp_order_count,t_sp_cake_sup.status FROM "
			+ " t_sp_cake_sup WHERE t_sp_cake_sup.status IN(0,1,2) and t_sp_cake_sup.del_status=0 and t_sp_cake_sup.date=:prodDate "
			+ "  GROUP BY t_sp_cake_sup.status  ", nativeQuery = true)
	List<DashSpCakeCount> getSpCakeOrdCountAllMenu(@Param("prodDate") String prodDate);
	*/
	
	
	//Anmol 16-7-2019
	
	@Query(value = " SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS sp_order_count, t_sp_cake_sup.status FROM "
			+ "t_sp_cake_sup,t_sp_cake WHERE t_sp_cake_sup.status IN(0, 1, 2) AND t_sp_cake_sup.del_status = 0 "
			+ "AND t_sp_cake_sup.date = :prodDate AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no "
			+ "AND t_sp_cake.is_allocated=0 GROUP BY t_sp_cake_sup.status   ", nativeQuery = true)
	List<DashSpCakeCount> getSpCakeOrdCountAllMenu(@Param("prodDate") String prodDate);

	//Anmol 16-7-2019
	
	@Query(value = " SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS sp_order_count, t_sp_cake_sup.status FROM "
			+ "t_sp_cake_sup,t_sp_cake WHERE t_sp_cake_sup.status IN(0, 1, 2) AND t_sp_cake_sup.del_status = 0 "
			+ "AND t_sp_cake_sup.date = :prodDate AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no "
			+ "AND t_sp_cake.is_allocated=1 GROUP BY t_sp_cake_sup.status   ", nativeQuery = true)
	List<DashSpCakeCount> getAlbumSpCakeOrdCountAllMenu(@Param("prodDate") String prodDate);


	
	@Query(value = " SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS sp_order_count, t_sp_cake_sup.status FROM "
			+ "t_sp_cake_sup,t_sp_cake WHERE t_sp_cake_sup.status IN(0, 1, 2) AND t_sp_cake_sup.del_status = 0 "
			+ "AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.menu_id IN(:menuIdList) "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated=0 "
			+ "GROUP BY t_sp_cake_sup.status   ", nativeQuery = true)
	List<DashSpCakeCount> getSpCakeOrdCountSpecMenu(@Param("prodDate") String prodDate,@Param("menuIdList") List<Integer> menuIdList);

	//Anmol 16-7-2019
	
	@Query(value = " SELECT COUNT(t_sp_cake_sup.t_sp_cake_sup_no) AS sp_order_count, t_sp_cake_sup.status FROM "
			+ "t_sp_cake_sup,t_sp_cake WHERE t_sp_cake_sup.status IN(0, 1, 2) AND t_sp_cake_sup.del_status = 0 "
			+ "AND t_sp_cake_sup.date = :prodDate AND t_sp_cake_sup.menu_id IN(:menuIdList) "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake.is_allocated=1 "
			+ "GROUP BY t_sp_cake_sup.status   ", nativeQuery = true)
	List<DashSpCakeCount> getAlbumSpCakeOrdCountSpecMenu(@Param("prodDate") String prodDate,@Param("menuIdList") List<Integer> menuIdList);


}
