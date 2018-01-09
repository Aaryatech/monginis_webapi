package com.ats.webapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetRegSpCakeOrders;
import com.ats.webapi.model.RegSpCkOrderResponse;
import com.ats.webapi.model.RegularSpCake;
import com.ats.webapi.model.RegularSpCkOrders;

@Service
public interface RegularSpCkOrderService {

	ErrorMessage placeRegularSpCakeOrder(RegularSpCake regularSpCake);

	RegSpCkOrderResponse findRegularSpCkOrder(List<Integer> frId, String strDate);

	RegSpCkOrderResponse findRegSpCakeOrderAllFr(String strDate);

	List<GetRegSpCakeOrders> getRegSpCakeOrder(List<String> orderNo);

}
