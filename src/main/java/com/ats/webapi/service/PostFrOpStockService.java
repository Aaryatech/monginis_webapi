package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.PostFrItemStockHeader;


public interface PostFrOpStockService {

	
	List<PostFrItemStockHeader> saveFrOpStockHeader(List<PostFrItemStockHeader> postFrItemStockHeader);
}
