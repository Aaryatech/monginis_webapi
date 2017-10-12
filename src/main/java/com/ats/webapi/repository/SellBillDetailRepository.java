package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SellBillDetail;
@Repository
public interface SellBillDetailRepository extends JpaRepository<SellBillDetail, Long>{

	SellBillDetail save(SellBillDetail sellBillDetail);

}
