package com.ats.webapi.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.model.GetRegSpCakeOrderQty;
import com.ats.webapi.service.GetOrderItemQtyService;

@RestController
public class PorductionApiController {

	@Autowired
	private GetOrderItemQtyService getOrderItemQtyService;
	
	/*@RequestMapping(value = { "/getOrderItemQty" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderItemQty getOrderItemQty(@RequestParam int itemId,
			@RequestParam String orderDate, @RequestParam int menuId) {
		GetOrderItemQty getOrderItemQty=new GetOrderItemQty();
		try {
			
			System.out.println("date str :" + orderDate);

			String strDate = Common.convertToYMD(orderDate);
			System.out.println("Converted date " + strDate);

		
			 getOrderItemQty = getOrderItemQtyService.getOrderQty(itemId, strDate, menuId);


		} catch (Exception e) {
e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getOrderItemQty;

	}
	
	@RequestMapping(value = { "/getOrderQtyRegSpCake" }, method = RequestMethod.POST)
	@ResponseBody
	public GetRegSpCakeOrderQty getOrderQtyRegSpCake(@RequestParam int itemId,
			@RequestParam String orderDate, @RequestParam int menuId) {
		GetRegSpCakeOrderQty getRegSpCakeOreder=new GetRegSpCakeOrderQty();
		try {
			
			System.out.println("date str :" + orderDate);

			String strDate = Common.convertToYMD(orderDate);
			System.out.println("Converted date " + strDate);

		
			getRegSpCakeOreder = getOrderItemQtyService.getRegSpCakeOrderQty(itemId, strDate, menuId);


		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getRegSpCakeOreder;

	}*/
	
	@RequestMapping(value = { "/getOrderQtyRegSpCakeAllItems" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetRegSpCakeOrderQty> getOrderQtyRegSpCakeAllItems(@RequestParam List<String> menuId,
			@RequestParam String orderDate) {
		List<GetRegSpCakeOrderQty> getRegSpCakeOrederList=new ArrayList<GetRegSpCakeOrderQty>();
		try {
			
			System.out.println("date str :" + orderDate);

			String strDate = Common.convertToYMD(orderDate);
			System.out.println("Converted date " + strDate);

		
			getRegSpCakeOrederList = getOrderItemQtyService.getRegSpCakeOrderQty(strDate, menuId);


		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getRegSpCakeOrederList;

	}
	
	@RequestMapping(value = { "/getOrderAllItemQty" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetOrderItemQty> getOrderAllItemQty(@RequestParam List<String> menuId,
			@RequestParam String orderDate) {
		List<GetOrderItemQty> getOrderItemQtyList=new ArrayList<GetOrderItemQty>();
		try {
			
			System.out.println("date str :" + orderDate);

			String strDate = Common.convertToYMD(orderDate);
			System.out.println("Converted date " + strDate);

		
			getOrderItemQtyList = getOrderItemQtyService.getOrderQty(strDate, menuId);


		} catch (Exception e) {
e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getOrderItemQtyList;

	}
}
