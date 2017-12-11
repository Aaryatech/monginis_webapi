package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetProductionDetail;
import com.ats.webapi.model.GetProductionItemQty;
import com.ats.webapi.model.MaxTimeSlot;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.PostProdPlanHeader;
import com.ats.webapi.model.PostProductionHeader;

public interface ProductionService {

	
	public List<PostProductionHeader> saveProductionHeader(PostProductionHeader postProductionHeader);

	public List<GetProductionDetail> getProdQty(List<String> catId, String productionDate, int timeSlot);

	public List<Integer> getMenuIdsByCatId(int catId);

	public List<GetProductionItemQty> getProdQty(String strDate, int catId);

	public PostProdPlanHeader saveProductionPlanHeader(PostProdPlanHeader postProdPlanHeader);

	public PostProdPlanHeader getMaxTimeSlot(String strDate, int catId);
	
	}
