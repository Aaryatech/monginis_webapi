package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetConfiguredSpDayCk;

@Repository
public interface GetConfSpDayCakeRepository extends JpaRepository<GetConfiguredSpDayCk, Long>{


	List<GetConfiguredSpDayCk> findAllByDelStatus(int delStatus);

	GetConfiguredSpDayCk findBySpdayId(int spdayId);

    @Query(value="SELECT * from m_spday_configure where :cDate BETWEEN delivery_from_date AND delivery_to_date  AND del_status=0",nativeQuery=true)
	List<GetConfiguredSpDayCk> findAllSpDayCake(@Param("cDate")java.util.Date cDate);

	
	

}
