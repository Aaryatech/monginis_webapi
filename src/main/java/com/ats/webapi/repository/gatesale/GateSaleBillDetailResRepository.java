package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.gatesale.GateSaleBillDetail;
import com.ats.webapi.model.gatesale.GateSaleBillDetailRes;

@Repository
public interface GateSaleBillDetailResRepository extends JpaRepository<GateSaleBillDetailRes, Integer>{

	@Query(value="select t_gatesale_bill_detail.bill_detail_id,t_gatesale_bill_detail.bill_id,t_gatesale_bill_detail.item_id,t_gatesale_bill_detail.item_qty,\n" + 
			"t_gatesale_bill_detail.item_rate,t_gatesale_bill_detail.item_value,m_item.item_name from t_gatesale_bill_detail,m_item where t_gatesale_bill_detail.item_id=m_item.id And t_gatesale_bill_detail.bill_id=:billId",nativeQuery=true)
	List<GateSaleBillDetailRes> findGateSaleBillDetailByBillId(@Param("billId")int billId);

}
