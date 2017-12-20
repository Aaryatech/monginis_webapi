package com.ats.webapi.repository.storestock;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.stock.StoreStockDetail;

public interface StoreStockDetailRepository extends JpaRepository<StoreStockDetail, Integer>{

}
