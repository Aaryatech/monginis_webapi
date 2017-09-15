package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemOrderHis;


public interface ItemOrderHisRepository extends JpaRepository<ItemOrderHis,Long> {
	@Query(value="select o.*,m.menu_title,i.item_name from t_order o,m_fr_menu_show m,m_item i where o.menu_id=m.menu_id AND o.item_id=i.item_id AND o.menu_id=:menuId AND o.delivery_date=:deliveryDate AND o.fr_id=:frId",nativeQuery=true)
	List<ItemOrderHis> findByMenuIdInAndDeliveryDate(@Param("menuId") int menuId,@Param("deliveryDate") Date deliveryDate,@Param("frId")int frId);
}
