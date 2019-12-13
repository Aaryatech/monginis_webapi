package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemRecordByDate;

public interface ItemRecordByDateRepo extends JpaRepository<ItemRecordByDate, Integer>{

	@Query(value="select t.order_id,t.item_id,sum(t.order_qty) as order_qty,t.delivery_date,m.item_name from t_order t,m_item m where delivery_date between "
			+ ":fromDate and :toDate and m.id=t.item_id group by t.item_id,t.delivery_date order by m.item_grp1,m.item_grp2,m.item_name",nativeQuery=true)
	List<ItemRecordByDate> getorderreportByItemIdandDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	@Query(value="select t.order_id,t.item_id,sum(t.order_qty) as order_qty,t.delivery_date,m.item_name from t_order t,m_item m where delivery_date between"
			+ " :fromDate and :toDate and m.id=t.item_id AND t.fr_id IN(:frIds) group by t.item_id,t.delivery_date order by "
			+ "m.item_grp1,m.item_grp2,m.item_name",nativeQuery=true)
	List<ItemRecordByDate> getOrderReportByDateAndFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frIds") List<Integer> frIds);

	
}
