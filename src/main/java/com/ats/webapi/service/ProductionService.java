package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetProductionDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.PostProductionHeader;

public interface ProductionService {

	
	public List<PostProductionHeader> saveProductionHeader(PostProductionHeader postProductionHeader);

	public List<GetProductionDetail> getProdQty(List<String> catId, String productionDate, int timeSlot);
	}
