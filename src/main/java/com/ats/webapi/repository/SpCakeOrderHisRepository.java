package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCkOrderHis;


public interface SpCakeOrderHisRepository extends JpaRepository<SpCkOrderHis, Long> {
	@Query(value="select t_sp_cake.*,m_sp_flavour.spf_name,m_sp_cake.sp_name from t_sp_cake,m_sp_flavour,m_sp_cake where t_sp_cake.sp_delivery_date=:spDeliveryDate AND t_sp_cake.menu_id=:menuId AND t_sp_cake.fr_code=:frCode AND t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id AND t_sp_cake.sp_id=m_sp_cake.sp_id",nativeQuery=true)
	List<SpCkOrderHis> findByMenuIdInAndSpDeliveryDt(@Param("menuId")int menuId, @Param("spDeliveryDate")String spDeliveryDate,@Param("frCode")String frCode);
	
	
	/*@Query(value="SELECT t_sp_cake.*, m_sp_flavour.spf_name, t_sp_cake_album.album_name as sp_name FROM t_sp_cake, m_sp_flavour, t_sp_cake_album WHERE t_sp_cake.sp_delivery_date = :spDeliveryDate AND t_sp_cake.menu_id = :menuId AND t_sp_cake.fr_code = :frCode AND t_sp_cake.sp_flavour_id = m_sp_flavour.spf_id AND t_sp_cake.sp_id = t_sp_cake_album.album_id ",nativeQuery=true)
	List<SpCkOrderHis> findByMenuIdInAndSpDeliveryDtAlbum(@Param("menuId")int menuId, @Param("spDeliveryDate")String spDeliveryDate,@Param("frCode")String frCode);
	*/
	
	@Query(value="SELECT t_sp_cake.*, m_sp_flavour.spf_name, SUBSTRING_INDEX(t_sp_cake.item_id,'#',-1) AS sp_name FROM t_sp_cake, m_sp_flavour, t_sp_cake_album WHERE t_sp_cake.sp_delivery_date = :spDeliveryDate AND t_sp_cake.menu_id = :menuId AND t_sp_cake.fr_code = :frCode AND t_sp_cake.sp_flavour_id = m_sp_flavour.spf_id AND t_sp_cake.sp_id = t_sp_cake_album.album_id  ",nativeQuery=true)
	List<SpCkOrderHis> findByMenuIdInAndSpDeliveryDtAlbum(@Param("menuId")int menuId, @Param("spDeliveryDate")String spDeliveryDate,@Param("frCode")String frCode);
	
	@Query(value="SELECT t_sp_cake.*, m_sp_flavour.spf_name, SUBSTRING_INDEX(t_sp_cake.item_id,'#',-1) AS sp_name FROM t_sp_cake, m_sp_flavour, t_sp_cake_album WHERE t_sp_cake.sp_order_no=:spOrderNo AND t_sp_cake.sp_flavour_id = m_sp_flavour.spf_id AND t_sp_cake.sp_id = t_sp_cake_album.album_id  ",nativeQuery=true)
	SpCkOrderHis findBySpOrderNo(@Param("spOrderNo") int spOrderNo);
	
}
