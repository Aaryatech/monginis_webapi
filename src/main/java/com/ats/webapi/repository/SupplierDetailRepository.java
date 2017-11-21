package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.SupplierMaster.SupplierDetails;

public interface SupplierDetailRepository extends JpaRepository<SupplierDetails, Integer>{
	
	SupplierDetails save(SupplierDetails supplierDetails);

}
