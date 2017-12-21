package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Variance;

public interface VarianceRepository extends JpaRepository<Variance, Integer>{

	@Query(value="SELECT m_item.item_name,m_item.id,m_item.item_id, coalesce((Select sum(t_order.order_qty) From t_order where "
			+ "t_order.production_date=:Date AND m_item.id=t_order.item_id ),0) AS t_order_qty,coalesce((Select SUM( t_regular_sp_cake.qty) "
			+ "From t_regular_sp_cake where m_item.id= t_regular_sp_cake.item_id AND t_regular_sp_cake.rsp_produ_date=:Date),0)"
			+ " AS prod_rejected_qty "
			+ "from m_item,m_rm WHERE m_item.item_grp1=:group_type Group by id",nativeQuery=true)
	List<Variance> variancelist(@Param("Date")String date,@Param("group_type")String groupType);
	
	
	
}
