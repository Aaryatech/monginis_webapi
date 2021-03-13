package com.ats.webapi.repo.spcakedispatchreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCakeDispatchReport;

public interface SpCakeDispatchRepo extends JpaRepository<SpCakeDispatchReport, Integer>{

	
//	@Query(value="\n" + 
//			"SELECT m_franchisee.fr_code,m_franchisee.fr_name,COUNT(t_sp_cake.sp_id) AS sp_id,GROUP_CONCAT(t_sp_cake_sup.sr_no) AS sr_no,GROUP_CONCAT(sp_delivery_place) AS sp_delivery_place FROM `t_sp_cake`,m_franchisee,t_sp_cake_sup,m_fr_route WHERE `sp_delivery_date` =:spCakeDelDate And t_sp_cake_sup.menu_id IN (:menuIdList) AND m_franchisee.fr_id=t_sp_cake.fr_id and t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND m_franchisee.fr_route_id=m_fr_route.route_id AND m_fr_route.route_id=:routId GROUP BY t_sp_cake.fr_id ORDER BY m_fr_route.route_seq_no ",nativeQuery=true)
//	 List<SpCakeDispatchReport>  getSpecialCakeDispatchReport(@Param("spCakeDelDate")String spCakeDelDate,@Param("routId")int routId, @Param("menuIdList") List<String> menuIdList);

	@Query(value="\n" + 
	"SELECT m_franchisee.fr_code,m_franchisee.not_show_items AS fr_name,COUNT(t_sp_cake.sp_id) AS sp_id,GROUP_CONCAT(t_sp_cake_sup.sr_no) AS sr_no,GROUP_CONCAT(sp_delivery_place) AS sp_delivery_place FROM `t_sp_cake`,m_franchisee,t_sp_cake_sup,m_fr_route WHERE `sp_delivery_date` =:spCakeDelDate And t_sp_cake_sup.menu_id IN (:menuIdList) AND m_franchisee.fr_id=t_sp_cake.fr_id and t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND m_franchisee.fr_route_id=m_fr_route.route_id AND m_fr_route.route_id=:routId GROUP BY t_sp_cake.fr_id ORDER BY m_fr_route.route_seq_no ",nativeQuery=true)
List<SpCakeDispatchReport>  getSpecialCakeDispatchReport(@Param("spCakeDelDate")String spCakeDelDate,@Param("routId")int routId, @Param("menuIdList") List<String> menuIdList);

}
