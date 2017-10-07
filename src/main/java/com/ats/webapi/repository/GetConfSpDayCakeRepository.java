package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetConfiguredSpDayCk;

@Repository
public interface GetConfSpDayCakeRepository extends JpaRepository<GetConfiguredSpDayCk, Long>{


	List<GetConfiguredSpDayCk> findAllByDelStatus(int delStatus);
	
	

}
