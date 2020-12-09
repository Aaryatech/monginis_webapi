package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.SpCakeOrders;


public interface SpCakeOrdersRepository extends JpaRepository<SpCakeOrders,Integer>{
	
	
	
	SpCakeOrders save(SpCakeOrders spCakeOrders);
	
	List<SpCakeOrders> findByFrIdInAndSpProdDate(List<Integer> frId, Date prodDate);
	
	
	@Query(value="select count(*) from t_sp_cake where sp_prod_date=:sqlSpProduDate AND is_slot_used=1",nativeQuery=true)
	int findCountByProduDateAndIsSlotUsed(@Param("sqlSpProduDate")String sqlSpProduDate);
	
	//Sachin 03-10-2018 for ProdApp
	/*@Query(value="select count(*) from t_sp_cake where sp_prod_date=:sqlSpProduDate",nativeQuery=true)
	int findSpCakeOrdCountByProduDate(@Param("sqlSpProduDate")String sqlSpProduDate);
	*/
	
	//neha 15/02-2019
	@Query(value="select COALESCE(count(*),0) from t_sp_cake_sup where date=:sqlSpProduDate",nativeQuery=true)
	int findSpCakeOrdCountByProduDate(@Param("sqlSpProduDate")String sqlSpProduDate);
	
	@Query(value="select COALESCE(count(*),0) from t_sp_cake where sp_prod_date=:sqlSpProduDate",nativeQuery=true)
	int findCakeCountByProduDate(@Param("sqlSpProduDate")String sqlSpProduDate);
	

	@Transactional
	@Modifying	
	@Query("UPDATE SpCakeOrders t SET t.isBillGenerated =:status  WHERE t.spOrderNo=:orderId")
	int updateSpBillStatus(@Param("orderId") int orderId,@Param("status") int status);

	@Transactional
	@Modifying	
	@Query("UPDATE SpCakeOrders t SET t.isAllocated=1  WHERE t.spOrderNo=:gettSpCakeId")	
	int updateSpCkAllocDId(@Param("gettSpCakeId")int gettSpCakeId);
	



}
