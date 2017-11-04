package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.PostProductionHeader;

public interface PostPoductionHeaderRepository extends JpaRepository<PostProductionHeader, Integer> {

	PostProductionHeader save(PostProductionHeader postProductionHeader);
}
