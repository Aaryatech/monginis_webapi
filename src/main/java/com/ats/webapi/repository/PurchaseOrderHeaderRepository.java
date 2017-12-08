package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;

public interface PurchaseOrderHeaderRepository extends JpaRepository<PurchaseOrderHeader, Integer>{

	
	PurchaseOrderHeader save(PurchaseOrderHeader purchaseOrderHeader);

	@Query(value=" select * from t_purchase_order_header where del_status=0 and supp_id=:suppId",nativeQuery=true)
	List<PurchaseOrderHeader> findBySuppId(@Param("suppId") int suppId);
}
