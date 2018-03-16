package com.ats.webapi.repository.afe;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.afe.AfeScoreDetail;

public interface AfeScoreDetailRepo extends JpaRepository<AfeScoreDetail, Integer> {
	
	AfeScoreDetail save(AfeScoreDetail detail);
	
}
