package com.ats.webapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.service.GetOrderItemQtyService;

@RestController
public class PorductionApiController {

	@Autowired
	private GetOrderItemQtyService getOrderItemQtyService;
	
	@RequestMapping(value = { "/getOrderItemQty" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderItemQty getOrderItemQty(@RequestParam int itemId,
			@RequestParam String orderDate) {
		GetOrderItemQty getOrderItemQty=new GetOrderItemQty();
		try {
			
			System.out.println("date str :" + orderDate);

			String strDate = Common.convertToYMD(orderDate);
			System.out.println("Converted date " + strDate);

		
			 getOrderItemQty = getOrderItemQtyService.getOrderQty(itemId, strDate);


		} catch (Exception e) {
e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getOrderItemQty;

	}
}
