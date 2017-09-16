package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.SpCakeOrders;


public interface SpCakeOrdersRepository extends JpaRepository<SpCakeOrders,Long>{
	
	List<SpCakeOrders> findByFrCodeInAndSpProduDate(List<Integer> frId,Date produDate);




}
