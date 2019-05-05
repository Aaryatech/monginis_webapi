package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCakeWtCount;

public interface SpCakeWtCountRepo extends JpaRepository<SpCakeWtCount, Integer> {

	@Query(value = "SELECT t_sp_cake.sp_selected_weight as sp_selected_wt, COUNT(t_sp_cake.sp_selected_weight) as count FROM t_sp_cake WHERE t_sp_cake.del_status=1 AND t_sp_cake.sp_delivery_date BETWEEN :fromDate AND :toDate GROUP BY t_sp_cake.sp_selected_weight", nativeQuery = true)
	List<SpCakeWtCount> getSpCakeBetDateCount(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
