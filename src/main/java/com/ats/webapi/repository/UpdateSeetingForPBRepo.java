package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.FrItemStockConfigure;

public interface UpdateSeetingForPBRepo extends JpaRepository<FrItemStockConfigure, Integer> {
	
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE FrItemStockConfigure setting SET setting.settingValue =:settingValue  WHERE setting.settingKey=:settingKey")
	int updateSeetingForPurBill(@Param("settingValue") int settingValue,@Param("settingKey") String settingKey);

}
