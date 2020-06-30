package com.ats.webapi.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetSpCakeOrders;
import com.ats.webapi.model.GetSpCkOrder;
import com.ats.webapi.model.GetSpCkOrderAlbum;
import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;
import com.ats.webapi.repository.GetSpCakeOrderRepository;
import com.ats.webapi.repository.GetSpCakeOrdersRepository;
import com.ats.webapi.repository.GetSpCkOrderAlbumRepo;
import com.ats.webapi.repository.SpCakeOrdersRepoAdmin;
import com.ats.webapi.repository.SpCakeOrdersRepository;

@Service
public class SpCkOrdersServiceImpl implements SpCkOrdersService {
	
	
	String jsonSpCakeOrder="{}";
	//SpCakeOrders spCakeOrders;
	@Autowired
	SpCakeOrdersRepoAdmin spCakeOrdersRepository;
	
	@Autowired
	GetSpCakeOrdersRepository getSpCakeOrdersRepository;
	
    @Autowired
    GetSpCakeOrderRepository getSpCakeOrderRepository;
    
    @Autowired GetSpCkOrderAlbumRepo getAlbumSpCkOrderRepo;
    
	@Override
	public List<SpCakeOrdersBean> findSpCakeOrder(List<Integer> frId, String prodDate) {
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeOrder(frId, prodDate);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
	}


	@Override
	public List<SpCakeOrdersBean> findSpCakeOrderAllFr(String prodDate) {
		
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeOrderAllFr(prodDate);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
		
		
	}


	@Override
	public List<GetSpCakeOrders> getSpCakeOrder(List<String> spOrderNo) {
		 
	return getSpCakeOrdersRepository.getSpCakeOrders(spOrderNo);
		
	}


	@Override
	public List<GetSpCkOrder> getSpCkOrder(List<String> spOrderNo) {
		
		return getSpCakeOrderRepository.getSpCakeOrder(spOrderNo);
	}


	@Override
	public List<SpCakeOrdersBean> findSpCakeAlbumOrder(List<Integer> frId, String prodDate,int spMenuId) {
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeAlbumOrder(frId, prodDate,spMenuId);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order service impl ex"+e.getMessage());
		}
		return spCakeOrders;
	}


	@Override
	public List<SpCakeOrdersBean> findSpCakeAlbumOrderAllFr(String prodDate, int spMenuId) {
		List<SpCakeOrdersBean> spCakeOrders=null;
		try {
			spCakeOrders=spCakeOrdersRepository.FindAllSpCakeAlbumOrderAllFr(prodDate,spMenuId);
					
		
		}catch (Exception e) {
			System.out.println("inside sp cake order album service impl ex"+e.getMessage());
		}
		return spCakeOrders;
	}


	@Override
	public List<GetSpCakeOrders> getSpCakeAlbumOrder(List<String> spOrderNo) {
		return getSpCakeOrdersRepository.getSpCakeOrdersAlbum(spOrderNo);
	}


	@Override
	public List<GetSpCkOrder> getSpCkAlbumOrder(List<String> spOrderNo) {
		return getSpCakeOrderRepository.getSpCakeAlbumOrder(spOrderNo);
	}


	@Override
	public List<GetSpCkOrderAlbum> getAlbumSpCkOrder(List<String> spOrderNo) {
		// TODO Auto-generated method stub
		return getAlbumSpCkOrderRepo.getAlbumSpCakeOrder(spOrderNo);
	}
}


