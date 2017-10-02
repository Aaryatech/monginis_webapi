package com.ats.webapi.service;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.RegularSpCake;

@Service
public interface RegularSpCkOrderService {

	ErrorMessage placeRegularSpCakeOrder(RegularSpCake regularSpCake);

}
