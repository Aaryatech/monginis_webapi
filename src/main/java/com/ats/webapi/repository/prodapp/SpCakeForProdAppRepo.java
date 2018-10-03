package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.SpCakeForProdApp;

public interface SpCakeForProdAppRepo extends JpaRepository<SpCakeForProdApp, Integer> {

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.menu_id IN (:menuIdList) AND t_sp_cake.is_slot_used=:isSlotUsed "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ "ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_sp_cake_sup.fr_id ", nativeQuery = true)

	List<SpCakeForProdApp> getSpCakeOrderForProdOrderBy(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList,
			@Param("isSlotUsed") int isSlotUsed);

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2 "
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake.is_slot_used=:isSlotUsed "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ "ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_sp_cake_sup.fr_id ", nativeQuery = true)

	List<SpCakeForProdApp> getSpCakeOrderForProdOrderByAndAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("isSlotUsed") int isSlotUsed);

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.menu_id IN (:menuIdList) AND t_sp_cake.is_slot_used=:isSlotUsed "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ "", nativeQuery = true)

	List<SpCakeForProdApp> getSpCakeOrderForProdGen(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("menuIdList") List<Integer> menuIdList, @Param("isSlotUsed") int isSlotUsed);

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake.is_slot_used=:isSlotUsed "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ " ", nativeQuery = true)

	List<SpCakeForProdApp> getSpCakeOrderForProdGenAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("isSlotUsed") int isSlotUsed);

}
