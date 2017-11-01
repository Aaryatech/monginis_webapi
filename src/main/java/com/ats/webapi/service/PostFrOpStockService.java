package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;


public interface PostFrOpStockService {

	
	List<PostFrItemStockHeader> saveFrOpStockHeader( PostFrItemStockHeader postFrItemStockHeader);
	int updateEndMonth( PostFrItemStockHeader postFrItemStockHeader);
	PostFrItemStockHeader getFrOpStockHeader(int frId, int month, int year);
}
