package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.BillDetailUpdate;

public interface BillDetailUpdateRepository extends JpaRepository<BillDetailUpdate, Integer> {
	
	
	
	

	@Query(value=" UPDATE t_bill_detail SET bill_qty=:billQty,total=:total,total_without_tax=:totWithoutTax "
			+ "where bill_detail_no=:billDetailNo "
			+ "",nativeQuery=true)
	
	
	BillDetailUpdate updateBillDetail(@Param("billDetailNo") int billDetailNo,@Param("billQty") int billQty, @Param("total") float total,@Param("totWithoutTax") float totWithoutTax);
	

}
