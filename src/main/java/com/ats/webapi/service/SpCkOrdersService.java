package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.GetSpCakeOrders;
import com.ats.webapi.model.GetSpCkOrder;
import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;

public interface SpCkOrdersService {
	public List<SpCakeOrdersBean> findSpCakeOrder(List<Integer> frId,String prodDate);
	
	public List<SpCakeOrdersBean> findSpCakeOrderAllFr(String prodDate);

	public List<GetSpCakeOrders> getSpCakeOrder(List<String> spOrderNo);

	public List<GetSpCkOrder> getSpCkOrder(List<String> spOrderNo);
	
//Anmol 13-7-19
	public List<SpCakeOrdersBean> findSpCakeAlbumOrder(List<Integer> frId,String prodDate);
	
	public List<SpCakeOrdersBean> findSpCakeAlbumOrderAllFr(String prodDate);
	
	public List<GetSpCakeOrders> getSpCakeAlbumOrder(List<String> spOrderNo);
	
	public List<GetSpCkOrder> getSpCkAlbumOrder(List<String> spOrderNo);
}
