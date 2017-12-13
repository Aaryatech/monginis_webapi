package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.bom.BillOfMaterialHeader;

public interface BillOfMaterialRepository extends JpaRepository<BillOfMaterialHeader, Integer>{
	
	BillOfMaterialHeader save(BillOfMaterialHeader billOfMaterialHeader);
	
	@Query(value=" select * from t_req_bom where  req_date BETWEEN :frmdate and :todate and del_status=0",nativeQuery=true)
	List<BillOfMaterialHeader> getAlllist(@Param("frmdate")String frmdate,@Param("todate")String todate);
	
	@Query(value=" select * from t_req_bom where  req_id=:reqId and del_status=0",nativeQuery=true)
	BillOfMaterialHeader getByReqstId(@Param("reqId")int reqId);
	
	/*@Query(value=" update BillOfMaterialHeader set status=3 and req_id=:reqId")
	int updatestatus(@Param("reqId")int reqId);*/

}
