package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.ItemCreamType;

public interface ItemCreamTypeRepo extends JpaRepository<ItemCreamType, Integer> {
	
	public List<ItemCreamType> findBydelStatus(int del);

}
