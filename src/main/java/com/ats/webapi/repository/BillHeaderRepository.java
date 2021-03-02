package com.ats.webapi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.BillHeader;
import com.ats.webapi.model.SpCakeDispatchReport;


//Akhilesh Friday 11/12/2020 15:34
public interface BillHeaderRepository extends JpaRepository<BillHeader, Integer> {

	@Query(value="SELECT * FROM t_bill_header WHERE  bill_no > :billNo AND del_status=0 LIMIT 500",nativeQuery=true)
	List<BillHeader> getListGreaterThanBillNo(@Param("billNo") int billNo);
	
}
