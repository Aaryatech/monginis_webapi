package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.PostProdPlanHeader;

@Repository
public interface PostProdPlanHeaderRepository extends JpaRepository<PostProdPlanHeader, Integer>{

}
