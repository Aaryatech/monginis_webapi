package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.PostBillHeader;

public interface PostBillHeaderRepository extends JpaRepository<PostBillHeader, Integer> {
	
	PostBillHeader save(PostBillHeader postBillHeader);
	

}
