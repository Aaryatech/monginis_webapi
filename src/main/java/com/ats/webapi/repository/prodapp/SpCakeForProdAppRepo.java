package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.GetSpCakeOrderForProdApp;

public interface SpCakeForProdAppRepo extends JpaRepository<GetSpCakeOrderForProdApp, Integer> {

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,t_sp_cake_sup.is_char_used,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,t_sp_cake_sup.input_kg_prod,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date, t_sp_cake.sp_events,t_sp_cake.sp_events_name,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.menu_id IN (:menuIdList) AND t_sp_cake.is_slot_used IN (:isSlotUsed) "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ " GROUP BY t_sp_cake_sup.t_sp_cake_order_no  ORDER BY m_fr_route.route_seq_no DESC,m_franchise_sup.no_in_route,t_sp_cake_sup.fr_id ", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeOrderForProdOrderBy(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList,
			@Param("isSlotUsed") List<Integer> isSlotUsed);// D] specific menu order by

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,t_sp_cake_sup.is_char_used,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route, t_sp_cake_sup.input_kg_prod,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date, t_sp_cake.sp_events,t_sp_cake.sp_events_name, \n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2 "
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake.is_slot_used IN (:isSlotUsed) "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ " GROUP BY t_sp_cake_sup.t_sp_cake_order_no ORDER BY m_fr_route.route_seq_no DESC,m_franchise_sup.no_in_route,t_sp_cake_sup.fr_id   ", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeOrderForProdOrderByAndAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("isSlotUsed") List<Integer> isSlotUsed);// B] all menu order by

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,t_sp_cake_sup.is_char_used,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,t_sp_cake_sup.input_kg_prod, \n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date,  t_sp_cake.sp_events,t_sp_cake.sp_events_name, \n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.menu_id IN (:menuIdList) AND t_sp_cake.is_slot_used IN (:isSlotUsed) "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id GROUP BY t_sp_cake_sup.t_sp_cake_order_no \n"
			+ "", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeOrderForProdGen(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList,
			@Param("isSlotUsed") List<Integer> isSlotUsed); // C] specific menu no order by

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status, t_sp_cake_sup.is_char_used, \n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route, t_sp_cake_sup.input_kg_prod,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date,  t_sp_cake.sp_events,t_sp_cake.sp_events_name,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake.is_slot_used IN (:isSlotUsed) "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id\n"
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id GROUP BY t_sp_cake_sup.t_sp_cake_order_no \n"
			+ " ", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeOrderForProdGenAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("isSlotUsed") List<Integer> isSlotUsed);// A onload all menu no order
																							// by

	// these two to consume
	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,t_sp_cake_sup.is_char_used,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,t_sp_cake_sup.input_kg_prod,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date, t_sp_cake.sp_events,t_sp_cake.sp_events_name,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.menu_id IN (:menuIdList) "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id AND m_fr_route.route_id=:routeId "
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ "ORDER BY m_fr_route.route_seq_no DESC,m_franchise_sup.no_in_route,t_sp_cake_sup.fr_id ", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeOrderByRouteIdSpecMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList,
			@Param("routeId") int routeId);// specific menu order by

	@Query(value = "SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,t_sp_cake_sup.is_char_used,\n"
			+ "t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,t_sp_cake_sup.input_kg_prod,\n"
			+ "m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,\n"
			+ "m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,\n"
			+ "t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date, t_sp_cake.sp_events,t_sp_cake.sp_events_name,\n"
			+ "t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2\n"
			+ "FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour\n"
			+ "WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate   "
			+ "AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n"
			+ "AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id AND m_fr_route.route_id=:routeId "
			+ "AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id\n"
			+ "ORDER BY m_fr_route.route_seq_no DESC,m_franchise_sup.no_in_route,t_sp_cake_sup.fr_id ", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeOrderByRouteIdAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("routeId") int routeId);// specific menu order by

	
	//-------------------------------------------------------------------------------------------------------
	
	
	
	
	
	//----Anmol 13-7-2019---------------
	
	@Query(value = "SELECT\n" + 
			"    t_sp_cake_sup.sr_no,\n" + 
			"    t_sp_cake_sup.t_sp_cake_sup_no,\n" + 
			"    t_sp_cake_sup.date,\n" + 
			"    t_sp_cake_sup.status,\n" + 
			"    t_sp_cake_sup.is_char_used,\n" + 
			"    t_sp_cake_sup.input_kg_fr,\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_franchise_sup.no_in_route,\n" + 
			"    t_sp_cake_sup.input_kg_prod,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_franchisee.fr_code,\n" + 
			"    m_franchisee.fr_id,\n" + 
			"    m_fr_route.route_id,\n" + 
			"    m_sp_cake_category.sp_name,\n" + 
			"    m_sp_cake_category.sp_code,\n" + 
			"    m_sp_cake_category.sp_image,\n" + 
			"    t_sp_cake.sp_flavour_id,\n" + 
			"    m_sp_flavour.spf_name,\n" + 
			"    t_sp_cake.sp_delivery_place,\n" + 
			"    t_sp_cake.sp_instructions,\n" + 
			"    t_sp_cake.sp_delivery_date,\n" + 
			"    t_sp_cake.sp_events,\n" + 
			"    t_sp_cake.sp_events_name,\n" + 
			"    t_sp_cake_sup.start_time_stamp,\n" + 
			"    t_sp_cake_sup.end_time_stamp,\n" + 
			"    t_sp_cake.order_photo,\n" + 
			"    t_sp_cake.order_photo2\n" + 
			"FROM\n" + 
			"    t_sp_cake_sup,\n" + 
			"    m_fr_route,\n" + 
			"    m_franchise_sup,\n" + 
			"    t_sp_cake,\n" + 
			"    m_franchisee,\n" + 
			"    m_sp_cake_category,\n" + 
			"    m_sp_flavour\n" + 
			"WHERE\n" + 
			"    t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake.is_slot_used IN(:isSlotUsed) AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id = m_franchisee.fr_id AND m_franchisee.fr_id = m_franchise_sup.fr_id AND m_franchisee.fr_route_id = m_fr_route.route_id AND m_sp_cake_category.sp_id = t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id\n" + 
			"GROUP BY\n" + 
			"    t_sp_cake_sup.t_sp_cake_order_no"
			+ " ", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeAlbumOrderForProdGenAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("isSlotUsed") List<Integer> isSlotUsed);// A onload all menu no order
	
	
	
	@Query(value = "SELECT\n" + 
			"    t_sp_cake_sup.sr_no,\n" + 
			"    t_sp_cake_sup.t_sp_cake_sup_no,\n" + 
			"    t_sp_cake_sup.date,\n" + 
			"    t_sp_cake_sup.status,\n" + 
			"    t_sp_cake_sup.is_char_used,\n" + 
			"    t_sp_cake_sup.input_kg_fr,\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_franchise_sup.no_in_route,\n" + 
			"    t_sp_cake_sup.input_kg_prod,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_franchisee.fr_code,\n" + 
			"    m_franchisee.fr_id,\n" + 
			"    m_fr_route.route_id,\n" + 
			"    m_sp_cake_category.sp_name,\n" + 
			"    m_sp_cake_category.sp_code,\n" + 
			"    m_sp_cake_category.sp_image,\n" + 
			"    t_sp_cake.sp_flavour_id,\n" + 
			"    m_sp_flavour.spf_name,\n" + 
			"    t_sp_cake.sp_delivery_place,\n" + 
			"    t_sp_cake.sp_instructions,\n" + 
			"    t_sp_cake.sp_delivery_date,\n" + 
			"    t_sp_cake.sp_events,\n" + 
			"    t_sp_cake.sp_events_name,\n" + 
			"    t_sp_cake_sup.start_time_stamp,\n" + 
			"    t_sp_cake_sup.end_time_stamp,\n" + 
			"    t_sp_cake.order_photo,\n" + 
			"    t_sp_cake.order_photo2\n" + 
			"FROM\n" + 
			"    t_sp_cake_sup,\n" + 
			"    m_fr_route,\n" + 
			"    m_franchise_sup,\n" + 
			"    t_sp_cake,\n" + 
			"    m_franchisee,\n" + 
			"    m_sp_cake_category,\n" + 
			"    m_sp_flavour\n" + 
			"WHERE\n" + 
			"    t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake.is_slot_used IN(:isSlotUsed) AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id = m_franchisee.fr_id AND m_franchisee.fr_id = m_franchise_sup.fr_id AND m_franchisee.fr_route_id = m_fr_route.route_id AND m_sp_cake_category.sp_id = t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id\n" + 
			"GROUP BY\n" + 
			"    t_sp_cake_sup.t_sp_cake_order_no\n" + 
			"ORDER BY\n" + 
			"    m_fr_route.route_seq_no\n" + 
			"DESC\n" + 
			"    ,\n" + 
			"    m_franchise_sup.no_in_route,\n" + 
			"    t_sp_cake_sup.fr_id   ", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeAlbumOrderForProdOrderByAndAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("isSlotUsed") List<Integer> isSlotUsed);// B] all menu order by
	
	
	@Query(value = "SELECT\n" + 
			"    t_sp_cake_sup.sr_no,\n" + 
			"    t_sp_cake_sup.t_sp_cake_sup_no,\n" + 
			"    t_sp_cake_sup.date,\n" + 
			"    t_sp_cake_sup.status,\n" + 
			"    t_sp_cake_sup.is_char_used,\n" + 
			"    t_sp_cake_sup.input_kg_fr,\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_franchise_sup.no_in_route,\n" + 
			"    t_sp_cake_sup.input_kg_prod,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_franchisee.fr_code,\n" + 
			"    m_franchisee.fr_id,\n" + 
			"    m_fr_route.route_id,\n" + 
			"    m_sp_cake_category.sp_name,\n" + 
			"    m_sp_cake_category.sp_code,\n" + 
			"    m_sp_cake_category.sp_image,\n" + 
			"    t_sp_cake.sp_flavour_id,\n" + 
			"    m_sp_flavour.spf_name,\n" + 
			"    t_sp_cake.sp_delivery_place,\n" + 
			"    t_sp_cake.sp_instructions,\n" + 
			"    t_sp_cake.sp_delivery_date,\n" + 
			"    t_sp_cake.sp_events,\n" + 
			"    t_sp_cake.sp_events_name,\n" + 
			"    t_sp_cake_sup.start_time_stamp,\n" + 
			"    t_sp_cake_sup.end_time_stamp,\n" + 
			"    t_sp_cake.order_photo,\n" + 
			"    t_sp_cake.order_photo2\n" + 
			"FROM\n" + 
			"    t_sp_cake_sup,\n" + 
			"    m_fr_route,\n" + 
			"    m_franchise_sup,\n" + 
			"    t_sp_cake,\n" + 
			"    m_franchisee,\n" + 
			"    m_sp_cake_category,\n" + 
			"    m_sp_flavour\n" + 
			"WHERE\n" + 
			"    t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.menu_id IN(:menuIdList) AND t_sp_cake.is_slot_used IN(:isSlotUsed) AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id = m_franchisee.fr_id AND m_franchisee.fr_id = m_franchise_sup.fr_id AND m_franchisee.fr_route_id = m_fr_route.route_id AND m_sp_cake_category.sp_id = t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id\n" + 
			"GROUP BY\n" + 
			"    t_sp_cake_sup.t_sp_cake_order_no"
			+ "", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeAlbumOrderForProdGen(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList,
			@Param("isSlotUsed") List<Integer> isSlotUsed); // C] specific menu no order by
	
	
	
	
	@Query(value = "SELECT\n" + 
			"    t_sp_cake_sup.sr_no,\n" + 
			"    t_sp_cake_sup.t_sp_cake_sup_no,\n" + 
			"    t_sp_cake_sup.date,\n" + 
			"    t_sp_cake_sup.status,\n" + 
			"    t_sp_cake_sup.is_char_used,\n" + 
			"    t_sp_cake_sup.input_kg_fr,\n" + 
			"    m_fr_route.route_name,\n" + 
			"    m_franchise_sup.no_in_route,\n" + 
			"    t_sp_cake_sup.input_kg_prod,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_franchisee.fr_code,\n" + 
			"    m_franchisee.fr_id,\n" + 
			"    m_fr_route.route_id,\n" + 
			"    m_sp_cake_category.sp_name,\n" + 
			"    m_sp_cake_category.sp_code,\n" + 
			"    m_sp_cake_category.sp_image,\n" + 
			"    t_sp_cake.sp_flavour_id,\n" + 
			"    m_sp_flavour.spf_name,\n" + 
			"    t_sp_cake.sp_delivery_place,\n" + 
			"    t_sp_cake.sp_instructions,\n" + 
			"    t_sp_cake.sp_delivery_date,\n" + 
			"    t_sp_cake.sp_events,\n" + 
			"    t_sp_cake.sp_events_name,\n" + 
			"    t_sp_cake_sup.start_time_stamp,\n" + 
			"    t_sp_cake_sup.end_time_stamp,\n" + 
			"    t_sp_cake.order_photo,\n" + 
			"    t_sp_cake.order_photo2\n" + 
			"FROM\n" + 
			"    t_sp_cake_sup,\n" + 
			"    m_fr_route,\n" + 
			"    m_franchise_sup,\n" + 
			"    t_sp_cake,\n" + 
			"    m_franchisee,\n" + 
			"    m_sp_cake_category,\n" + 
			"    m_sp_flavour\n" + 
			"WHERE\n" + 
			"    t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.menu_id IN(:menuIdList) AND t_sp_cake.is_slot_used IN(:isSlotUsed) AND t_sp_cake.sp_order_no = t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id = m_franchisee.fr_id AND m_franchisee.fr_id = m_franchise_sup.fr_id AND m_franchisee.fr_route_id = m_fr_route.route_id AND m_sp_cake_category.sp_id = t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id = t_sp_cake.sp_flavour_id\n" + 
			"GROUP BY\n" + 
			"    t_sp_cake_sup.t_sp_cake_order_no\n" + 
			"ORDER BY\n" + 
			"    m_fr_route.route_seq_no\n" + 
			"DESC\n" + 
			"    ,\n" + 
			"    m_franchise_sup.no_in_route,\n" + 
			"    t_sp_cake_sup.fr_id", nativeQuery = true)

	List<GetSpCakeOrderForProdApp> getSpCakeAlbumOrderForProdOrderBy(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList,
			@Param("isSlotUsed") List<Integer> isSlotUsed);// D] specific menu order by
	
			
}
