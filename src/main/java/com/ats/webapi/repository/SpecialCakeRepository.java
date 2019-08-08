package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpecialCake;
import com.ats.webapi.model.TSellReport;

public interface SpecialCakeRepository extends JpaRepository<SpecialCake, Integer> {
	public SpecialCake save(SpecialCake specialcake);

	public SpecialCake findOne(int spId);

	public List<SpecialCake> findByDelStatus(int i);

	public List<SpecialCake> findByDelStatusOrderBySpNameAsc(int i);

	@Query(value = "SELECT a.album_id as sp_id,a.album_code as sp_code,a.album_name as sp_name,sc.sp_type,a.min_wt as sp_min_wt,a.max_wt as sp_max_wt,sc.sp_book_b4,sc.spr_id,a.photo1 as sp_image,sc.sp_tax1,sc.sp_tax2,sc.sp_tax3,sc.spe_id_list,sc.is_used,sc.sp_pho_upload,sc.time_two_appli ,sc.del_status ,sc.base_code,sc.sp_desc ,sc.order_qty ,sc.order_discount ,sc.is_cust_choice_ck ,sc.is_addon_rate_appli ,sc.mrp_rate1 ,sc.mrp_rate2 ,sc.mrp_rate3 ,sc. sp_rate1,sc. sp_rate2,sc. sp_rate3,sc. is_slot_used,sc.sp_code as erp_link_code\n"
			+ "FROM m_sp_cake sc ,t_sp_cake_album a WHERE sc.del_status=0 AND a.del_status=0 AND a.is_active=1 AND a.sp_id=sc.sp_id", nativeQuery = true)
	List<SpecialCake> getData();

	@Query(value = "SELECT a.album_id AS sp_id, a.album_code AS sp_code, a.album_name AS sp_name,"
			+ " sc.sp_type, a.min_wt AS sp_min_wt, a.max_wt AS sp_max_wt, sc.sp_book_b4, "
			+ "sc.spr_id, a.photo1 AS sp_image, sc.sp_tax1, sc.sp_tax2, sc.sp_tax3, "
			+ "sc.spe_id_list, sc.is_used, sc.sp_pho_upload, sc.time_two_appli, "
			+ "sc.del_status, sc.base_code, sc.sp_desc, sc.order_qty, sc.order_discount, "
			+ "sc.is_cust_choice_ck, sc.is_addon_rate_appli, sc.mrp_rate1, sc.mrp_rate2, "
			+ "sc.mrp_rate3, sc.sp_rate1, sc.sp_rate2, sc.sp_rate3, sc.is_slot_used, "
			+ "sc.sp_code AS erp_link_code FROM m_sp_cake_category sc, t_sp_cake_album a "
			+ "WHERE sc.del_status = 0 AND a.del_status = 0 AND a.is_active = 1 AND "
			+ "a.sp_id = sc.sp_id AND FIND_IN_SET(a.album_id,(SELECT GROUP_CONCAT(fc.item_show) "
			+ "FROM m_fr_configure fc,m_fr_menu_show m WHERE fc.menu_id=m.menu_id AND "
			+ "fc.is_del=0 AND m.del_status=0 AND fc.fr_id=:frId AND m.cat_id=5 AND "
			+ "m.is_same_day_applicable=4))", nativeQuery = true)
	List<SpecialCake> getDataByFr(@Param("frId")int frId);
	
	
}
