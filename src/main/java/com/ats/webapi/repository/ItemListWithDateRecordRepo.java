package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemListWithDateRecord;

public interface ItemListWithDateRecordRepo extends JpaRepository<ItemListWithDateRecord, Integer>{

	@Query(value="select distinct t.item_id,i.item_name  from t_order t,m_item i where delivery_date between :fromDate and :toDate "
			+ "and i.id = t.item_id  order by i.item_grp1,i.item_grp2,i.item_name",nativeQuery=true)
	List<ItemListWithDateRecord> getorderreportByItemIdandDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
