package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;

public interface PurchaseOrderHeaderRepository extends JpaRepository<PurchaseOrderHeader, Integer>{

	
	PurchaseOrderHeader save(PurchaseOrderHeader purchaseOrderHeader);
}
