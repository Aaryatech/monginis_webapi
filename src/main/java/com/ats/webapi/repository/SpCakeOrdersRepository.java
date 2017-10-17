package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCakeOrders;


public interface SpCakeOrdersRepository extends JpaRepository<SpCakeOrders,Long>{
	
	List<SpCakeOrders> findByFrIdInAndSpProdDate(List<Integer> frId, Date prodDate);

	
	
	@Query(value="select count(*) from t_sp_cake where sp_prod_date=:sqlSpProduDate AND is_slot_used=1",nativeQuery=true)
	int findCountByProduDateAndIsSlotUsed(@Param("sqlSpProduDate")String sqlSpProduDate);





}
