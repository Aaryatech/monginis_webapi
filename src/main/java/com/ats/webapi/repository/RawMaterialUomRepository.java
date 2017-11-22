package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.rawmaterial.RawMaterialUom;

public interface RawMaterialUomRepository extends JpaRepository<RawMaterialUom, Integer>{
	
	List<RawMaterialUom> findAll();

}
