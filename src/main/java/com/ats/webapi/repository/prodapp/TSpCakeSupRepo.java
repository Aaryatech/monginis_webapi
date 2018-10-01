package com.ats.webapi.repository.prodapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.prodapp.TSpCakeSup;


public interface TSpCakeSupRepo extends JpaRepository<TSpCakeSup, Integer> {
	
	
	
	TSpCakeSup save(TSpCakeSup cakeSup);
	

}
