package com.ats.webapi.service;

import com.ats.webapi.model.GetOrderItemQty;

public interface GetOrderItemQtyService {

	GetOrderItemQty getOrderQty(int itemId, String orderDate);
}
