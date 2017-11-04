package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.PostProductionDetail;

public interface PostProductionDetailRepository extends JpaRepository<PostProductionDetail, Integer>{
	
	PostProductionDetail save(PostProductionDetail postProductionDetail);

}
