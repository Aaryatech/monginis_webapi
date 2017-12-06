package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.FrItemStockConfigure;
import com.ats.webapi.repository.FrItemStockConfigureRepository;

@Service
public class FrItemStockConfigureServiceImpl implements FrItemStockConfigureService {
	
	@Autowired
	FrItemStockConfigureRepository frItemStockConfRepo;

	@Override
	public List<FrItemStockConfigure> getFrItemConfigure() {
		
		
		
		List<FrItemStockConfigure> frItemStockConfigures=frItemStockConfRepo.findAll();
		
		return frItemStockConfigures;
	}

	@Override
	public int findTotalAvailableSlot() {
		
		   int totalAvailableSlot=frItemStockConfRepo.findBySettingKey("total_available_slot");
		return totalAvailableSlot;
	}

	@Override
	public int findProductionTimeSlot() {
		int productionTimeSlot=frItemStockConfRepo.findBySettingKey("production_time_slot");
		return productionTimeSlot;
	}

	@Override
	public int findbykey(String key) {
		
		int valuebykey=frItemStockConfRepo.findBySettingKey(key);
		return valuebykey;
		
	}

}
