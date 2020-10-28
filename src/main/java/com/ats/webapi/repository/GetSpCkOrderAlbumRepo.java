package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetSpCkOrderAlbum;

public interface GetSpCkOrderAlbumRepo extends JpaRepository<GetSpCkOrderAlbum, Integer> {

	@Query(value="SELECT\n" + 
			"        f.fr_name ,\n" + 
			"        s.sp_selected_weight,\n" + 
			"        s.order_photo,\n" + 
			"        s.item_id,\n" + 
			"        s.sp_events,\n" + 
			"        s.sp_events_name,\n" + 
			"        s.order_photo2,\n" + 
			"        s.sp_order_no,\n" + 
			"        f.fr_mob,\n" + 
			"        sp.sp_name,\n" + 
			"        s.order_date,\n" + 
			"        s.sp_price,\n" + 
			"        s.sp_instructions,\n" + 
			"        s.sp_sub_total,\n" + 
			"        s.sp_advance,\n" + 
			"        s.rm_amount,\n" + 
			"        s.sp_delivery_date,\n" + 
			"        s.sp_delivery_place,\n" + 
			"        s.sp_cust_name,\n" + 
			"        s.sp_cust_mob_no,\n" + 
			"        sf.spf_name,\n" + 
			"        album.photo1 as album_photo1,\n" + 
			"        album.photo2 as album_photo2, f.not_show_items as fr_name_mr \n" + 
			"    FROM\n" + 
			"        m_franchisee f ,\n" + 
			"        m_sp_cake_category sp,\n" + 
			"        m_sp_flavour sf,\n" + 
			"        t_sp_cake s,\n" + 
			"        t_sp_cake_album album\n" + 
			"    WHERE\n" + 
			"        s.sp_order_no IN(:spOrderNo) \n" + 
			"        AND s.sp_id = sp.sp_id \n" + 
			"        AND s.fr_id = f.fr_id \n" + 
			"        AND sf.spf_id=s.sp_flavour_id \n" + 
			"        AND SUBSTRING_INDEX(s.item_id, \"#\", 1)=album.album_id",nativeQuery=true)
	List<GetSpCkOrderAlbum> getAlbumSpCakeOrder(@Param("spOrderNo")List<String> spOrderNo);
}
