package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;

public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, Integer>{
	
	PurchaseOrderDetail save(PurchaseOrderDetail purchaseOrderDetail);

}
