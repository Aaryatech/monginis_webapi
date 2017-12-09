package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.PostProductionPlanDetail;

@Repository
public interface PostProdPlanDetailRepository extends JpaRepository<PostProductionPlanDetail, Integer>{

}
