package com.ats.webapi.repository.taxreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.OrderDispatchRepDao;
@Repository
public interface OrderDispatchRepDaoRepository extends JpaRepository<OrderDispatchRepDao, Integer>{

	@Query(value="select item.id,item.item_name,coalesce(stock.op_total) as op_total,coalesce(iorder.order_qty,0) as order_qty from\n" + 
			"(select i.id,i.item_name,i.item_grp1,i.item_grp2 from m_item i where i.del_status=0 and i.item_grp1=:catId) as item\n" + 
			"LEFT JOIN\n" + 
			"(select d.item_id,d.op_total  from finished_good_stock_detail d,finished_good_stock h where h.fin_stock_id=d.fin_stock_id and h.fin_good_stock_status=0 and h.del_status=0 and  d.del_status=0) as stock  ON stock.item_id=item.id\n" + 
			"LEFT JOIN\n" + 
			"(select o.item_id,SUM(o.order_qty) as order_qty from t_order o where o.menu_id IN(:menuId) and o.delivery_date=:deliveryDate group by o.item_id) as iorder ON\n" + 
			"iorder.item_id=item.id And iorder.item_id=stock.item_id order by item.item_grp1,item.item_grp2,item.item_name",nativeQuery=true)
	List<OrderDispatchRepDao> getOrderDispatchReport(@Param("deliveryDate")String deliveryDate,@Param("catId")int catId,@Param("menuId") List<String> menuId);

}
