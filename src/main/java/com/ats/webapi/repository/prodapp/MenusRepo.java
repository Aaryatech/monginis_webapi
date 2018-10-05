package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.AllMenus;

public interface MenusRepo extends JpaRepository<AllMenus, Integer> {
	
	
	
	
	List<AllMenus> findByMainCatIdAndIsSameDayApplicable(int catId,int isSameDayApp);
	
}
