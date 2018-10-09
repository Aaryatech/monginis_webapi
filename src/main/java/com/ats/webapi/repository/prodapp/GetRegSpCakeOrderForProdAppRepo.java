package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.GetRegSpCakeOrderForProdApp;

public interface GetRegSpCakeOrderForProdAppRepo extends JpaRepository<GetRegSpCakeOrderForProdApp, Integer> {

	@Query(value = " SELECT t_reg_sp_cake_sup.sr_no,t_reg_sp_cake_sup.sup_id,t_reg_sp_cake_sup.t_reg_sup_order_id,t_reg_sp_cake_sup.photo1,t_reg_sp_cake_sup.photo2, t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.status,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.is_char_used,"
			+ " m_fr_route.route_name,m_franchise_sup.no_in_route,"
			+ " m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,"
			+ " m_item.item_name,m_item.id,m_item.item_id,m_item.item_image,"
			+ " t_regular_sp_cake.rsp_place,t_regular_sp_cake.rsp_delivery_dt,"
			+ " t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time,"
			+ " m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id"
			+ " FROM t_reg_sp_cake_sup,m_fr_route,m_franchise_sup,t_regular_sp_cake,m_franchisee,m_item,m_cat_sub,m_category "
			+  " WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate AND t_reg_sp_cake_sup.menu_id IN (:menuIdList) "
			+ " AND t_regular_sp_cake.rsp_id=t_reg_sp_cake_sup.t_reg_sup_order_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ " AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id "
			+ " AND m_item.id=t_reg_sp_cake_sup.item_id AND "
			+ " m_item.item_grp1=m_category.cat_id AND m_item.item_grp2=m_cat_sub.sub_cat_id "
			+ " ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_reg_sp_cake_sup.fr_id ", nativeQuery = true)

	List<GetRegSpCakeOrderForProdApp> getRegSpCakeOrderForProdOrderBy(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList);// D] specific menu order by
	@Query(value = " SELECT t_reg_sp_cake_sup.sr_no,t_reg_sp_cake_sup.sup_id,t_reg_sp_cake_sup.t_reg_sup_order_id,t_reg_sp_cake_sup.photo1,t_reg_sp_cake_sup.photo2, t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.status,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.is_char_used,"
			+ " m_fr_route.route_name,m_franchise_sup.no_in_route,"
			+ " m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,"
			+ " m_item.item_name,m_item.id,m_item.item_id,m_item.item_image,"
			+ " t_regular_sp_cake.rsp_place,t_regular_sp_cake.rsp_delivery_dt,"
			+ " t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time,"
			+ " m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id"
			+ " FROM t_reg_sp_cake_sup,m_fr_route,m_franchise_sup,t_regular_sp_cake,m_franchisee,m_item,m_cat_sub,m_category "
			+  " WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate "
			+ " AND t_regular_sp_cake.rsp_id=t_reg_sp_cake_sup.t_reg_sup_order_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ " AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id "
			+ " AND m_item.id=t_reg_sp_cake_sup.item_id AND "
			+ " m_item.item_grp1=m_category.cat_id AND m_item.item_grp2=m_cat_sub.sub_cat_id "
			+ " ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_reg_sp_cake_sup.fr_id ", nativeQuery = true)


	List<GetRegSpCakeOrderForProdApp> getRegSpCakeOrderForProdOrderByAndAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);// B] all menu order by

	@Query(value = " SELECT t_reg_sp_cake_sup.sr_no,t_reg_sp_cake_sup.sup_id,t_reg_sp_cake_sup.t_reg_sup_order_id,t_reg_sp_cake_sup.photo1,t_reg_sp_cake_sup.photo2, t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.status,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.is_char_used,"
			+ " m_fr_route.route_name,m_franchise_sup.no_in_route,"
			+ " m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,"
			+ " m_item.item_name,m_item.id,m_item.item_id,m_item.item_image,"
			+ " t_regular_sp_cake.rsp_place,t_regular_sp_cake.rsp_delivery_dt,"
			+ " t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time,"
			+ " m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id"
			+ " FROM t_reg_sp_cake_sup,m_fr_route,m_franchise_sup,t_regular_sp_cake,m_franchisee,m_item,m_cat_sub,m_category "
			+  " WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate AND t_reg_sp_cake_sup.menu_id IN (:menuIdList) "
			+ " AND t_regular_sp_cake.rsp_id=t_reg_sp_cake_sup.t_reg_sup_order_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ " AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id "
			+ " AND m_item.id=t_reg_sp_cake_sup.item_id AND "
			+ " m_item.item_grp1=m_category.cat_id AND m_item.item_grp2=m_cat_sub.sub_cat_id "
			+ " ", nativeQuery = true)

	List<GetRegSpCakeOrderForProdApp> getRegSpCakeOrderForProdGen(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList); // C] specific menu no order by

	@Query(value = " SELECT t_reg_sp_cake_sup.sr_no,t_reg_sp_cake_sup.sup_id,t_reg_sp_cake_sup.t_reg_sup_order_id,t_reg_sp_cake_sup.photo1,t_reg_sp_cake_sup.photo2, t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.status,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.is_char_used,"
			+ " m_fr_route.route_name,m_franchise_sup.no_in_route,"
			+ " m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,"
			+ " m_item.item_name,m_item.id,m_item.item_id,m_item.item_image,"
			+ " t_regular_sp_cake.rsp_place,t_regular_sp_cake.rsp_delivery_dt,"
			+ " t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time,"
			+ " m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id"
			+ " FROM t_reg_sp_cake_sup,m_fr_route,m_franchise_sup,t_regular_sp_cake,m_franchisee,m_item,m_cat_sub,m_category "
			+  " WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate "
			+ " AND t_regular_sp_cake.rsp_id=t_reg_sp_cake_sup.t_reg_sup_order_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ " AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id "
			+ " AND m_item.id=t_reg_sp_cake_sup.item_id AND "
			+ " m_item.item_grp1=m_category.cat_id AND m_item.item_grp2=m_cat_sub.sub_cat_id "
			+ " ", nativeQuery = true)

	List<GetRegSpCakeOrderForProdApp> getRegSpCakeOrderForProdGenAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);// A onload all menu no order
																							// by
	
	//these two to consume 2pm
	
	
	@Query(value = " SELECT t_reg_sp_cake_sup.sr_no,t_reg_sp_cake_sup.sup_id,t_reg_sp_cake_sup.t_reg_sup_order_id,t_reg_sp_cake_sup.photo1,t_reg_sp_cake_sup.photo2, t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.status,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.is_char_used,"
			+ " m_fr_route.route_name,m_franchise_sup.no_in_route,"
			+ " m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,"
			+ " m_item.item_name,m_item.id,m_item.item_id,m_item.item_image,"
			+ " t_regular_sp_cake.rsp_place,t_regular_sp_cake.rsp_delivery_dt,"
			+ " t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time,"
			+ " m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id"
			+ " FROM t_reg_sp_cake_sup,m_fr_route,m_franchise_sup,t_regular_sp_cake,m_franchisee,m_item,m_cat_sub,m_category "
			+  " WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate AND t_reg_sp_cake_sup.menu_id IN (:menuIdList) "
			+ " AND t_regular_sp_cake.rsp_id=t_reg_sp_cake_sup.t_reg_sup_order_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ " AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id AND m_fr_route.route_id=:routeId  "
			+ " AND m_item.id=t_reg_sp_cake_sup.item_id AND "
			+ " m_item.item_grp1=m_category.cat_id AND m_item.item_grp2=m_cat_sub.sub_cat_id "
			+ " ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_reg_sp_cake_sup.fr_id ", nativeQuery = true)

	List<GetRegSpCakeOrderForProdApp> getRegSpCakeOrderByRouteIdSpecMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("menuIdList") List<Integer> menuIdList,@Param("routeId") int routeId);// D] specific menu order by
	
	@Query(value = " SELECT t_reg_sp_cake_sup.sr_no,t_reg_sp_cake_sup.sup_id,t_reg_sp_cake_sup.t_reg_sup_order_id,t_reg_sp_cake_sup.photo1,t_reg_sp_cake_sup.photo2, t_reg_sp_cake_sup.prod_date,t_reg_sp_cake_sup.status,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.is_char_used,"
			+ " m_fr_route.route_name,m_franchise_sup.no_in_route,"
			+ " m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,"
			+ " m_item.item_name,m_item.id,m_item.item_id,m_item.item_image,"
			+ " t_regular_sp_cake.rsp_place,t_regular_sp_cake.rsp_delivery_dt,"
			+ " t_reg_sp_cake_sup.start_time,t_reg_sp_cake_sup.end_time,"
			+ " m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id"
			+ " FROM t_reg_sp_cake_sup,m_fr_route,m_franchise_sup,t_regular_sp_cake,m_franchisee,m_item,m_cat_sub,m_category "
			+  " WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate  "
			+ " AND t_regular_sp_cake.rsp_id=t_reg_sp_cake_sup.t_reg_sup_order_id AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ " AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id AND m_fr_route.route_id=:routeId  "
			+ " AND m_item.id=t_reg_sp_cake_sup.item_id AND "
			+ " m_item.item_grp1=m_category.cat_id AND m_item.item_grp2=m_cat_sub.sub_cat_id "
			+ " ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_reg_sp_cake_sup.fr_id ", nativeQuery = true)

	List<GetRegSpCakeOrderForProdApp> getRegSpCakeOrderByRouteIdAllMenu(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("routeId") int routeId);// D] specific menu order by


}
