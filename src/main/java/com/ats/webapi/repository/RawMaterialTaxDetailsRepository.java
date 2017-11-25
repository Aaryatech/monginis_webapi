package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.rawmaterial.RawMaterialTaxDetails;

public interface RawMaterialTaxDetailsRepository extends JpaRepository<RawMaterialTaxDetails, Integer>{
	
	List<RawMaterialTaxDetails> findAll();
	
	RawMaterialTaxDetails save(RawMaterialTaxDetails rawMaterialTaxDetails);

}
