package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.FrItemStockConfigure;
import com.ats.webapi.model.FrItemStockConfigurePost;

public interface FrItemStockConfigurePostService {
	
	public List<FrItemStockConfigurePost> saveFrItemStockConf(List<FrItemStockConfigurePost> frItemStockConfigurePosts);
	

}
