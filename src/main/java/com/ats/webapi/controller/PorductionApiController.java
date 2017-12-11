package com.ats.webapi.controller;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.GetBillHeader;
import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.model.GetProductionDetail;
import com.ats.webapi.model.GetProductionItemQty;
import com.ats.webapi.model.GetRegSpCakeOrderQty;
import com.ats.webapi.model.GetSellBillHeader;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.MaxTimeSlot;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.PostProdPlanHeader;
import com.ats.webapi.model.PostProductionDetail;
import com.ats.webapi.model.PostProductionHeader;
import com.ats.webapi.model.UpdateBillStatus;
import com.ats.webapi.model.report.GetRepFrDatewiseSell;
import com.ats.webapi.model.report.GetRepItemwiseSell;
import com.ats.webapi.model.report.GetRepMonthwiseSell;
import com.ats.webapi.model.report.GetRepTaxSell;
import com.ats.webapi.service.GetBillHeaderService;
import com.ats.webapi.service.GetOrderItemQtyService;
import com.ats.webapi.service.ProductionService;
import com.ats.webapi.service.RepFrSellServise;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class PorductionApiController {

	@Autowired
	private GetOrderItemQtyService getOrderItemQtyService;
	
	@Autowired
	private ProductionService productionService;
	
 
	
	@Autowired
	RepFrSellServise repFrSellServise;
	
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
			@RequestParam String productionDate) {
		List<GetRegSpCakeOrderQty> getRegSpCakeOrederList=new ArrayList<GetRegSpCakeOrderQty>();
		try {
			
			System.out.println("date str :" + productionDate);

			String strDate = Common.convertToYMD(productionDate);
			System.out.println("Converted date " + strDate);

		
			getRegSpCakeOrederList = getOrderItemQtyService.getRegSpCakeOrderQty(strDate, menuId);


		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getRegSpCakeOrederList;

	}
	@RequestMapping(value = { "/getTimeSlot" }, method = RequestMethod.POST)
	@ResponseBody
	public PostProdPlanHeader getTimeSlot(@RequestParam int catId,@RequestParam String productionDate) {
		PostProdPlanHeader maxTimeSlot =null;
		try {
			
			System.out.println("date str :" + productionDate);

			String strDate = Common.convertToYMD(productionDate);
			System.out.println("Converted date " + strDate);

		
			 maxTimeSlot = productionService.getMaxTimeSlot(strDate, catId);


		} catch (Exception e) {
				e.printStackTrace();
			System.out.println("exception in  /getTimeSlot rest controller" + e.getMessage());
		}
		return maxTimeSlot;

	}
	
	@RequestMapping(value = { "/getOrderAllItemQty" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetOrderItemQty> getOrderAllItemQty(@RequestParam List<String> menuId,
			@RequestParam String productionDate) {
		List<GetOrderItemQty> getOrderItemQtyList=new ArrayList<GetOrderItemQty>();
		try {
			
			System.out.println("date str :" + productionDate);

			String strDate = Common.convertToYMD(productionDate);
			System.out.println("Converted date " + strDate);

		
			getOrderItemQtyList = getOrderItemQtyService.getOrderQty(strDate, menuId);


		} catch (Exception e) {
			
              e.printStackTrace();
			  System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return getOrderItemQtyList;

	}
	@RequestMapping(value = { "/getProduItemQty" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetProductionItemQty> getProdItemQty(@RequestParam int catId,@RequestParam String productionDate) {
		
		List<GetProductionItemQty> getProdItemQtyList=new ArrayList<GetProductionItemQty>();
		try {
			
			System.out.println("date str :" + productionDate);

			String strDate = Common.convertToYMD(productionDate);
			System.out.println("Converted date " + strDate);

		
			getProdItemQtyList = productionService.getProdQty(strDate, catId);


		} catch (Exception e) {
			
              e.printStackTrace();
			  System.out.println("Exception in Prod Qty list Rest controller" + e.getMessage());
		}
		return getProdItemQtyList;

	}
	
	@RequestMapping(value = { "/postProduction" }, method = RequestMethod.POST)

	public @ResponseBody Info postProduction(@RequestBody PostProductionHeader postProductionHeader)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		
        System.out.println("postProductionHeaderBean:"+postProductionHeader.toString());
		List<PostProductionHeader> jsonBillHeader;

		jsonBillHeader = productionService.saveProductionHeader(postProductionHeader);

		Info info = new Info();

		if (jsonBillHeader.size() > 0) {

			info.setError(false);
			info.setMessage("post Fr Stock header inserted  Successfully");

		}

		else {

			info.setError(true);
			info.setMessage("Error in post Fr Stock header insertion : RestApi");

		}

		return info;

	}
	@RequestMapping(value = { "/postProductionPlan" }, method = RequestMethod.POST)

	public @ResponseBody Info postProductionPlan(@RequestBody PostProdPlanHeader postProdPlanHeader)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		
        System.out.println("postProductionHeaderBean:"+postProdPlanHeader.toString());
        PostProdPlanHeader jsonBillHeader;

		jsonBillHeader = productionService.saveProductionPlanHeader(postProdPlanHeader);

		Info info = new Info();

		if (jsonBillHeader!=null) {

			info.setError(false);
			info.setMessage("post Fr Stock header inserted  Successfully");

		}

		else {

			info.setError(true);
			info.setMessage("Error in post Fr Stock header insertion : RestApi");

		}

		return info;

	}
	
	@RequestMapping(value = { "/getProdOrderQty" }, method = RequestMethod.POST)
	public @ResponseBody List<GetProductionDetail> getProdOrderQty(@RequestParam("catId") List<String> catId,
			@RequestParam("productionDate") String productionDate, @RequestParam("timeSlot") int timeSlot )
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		productionDate = Common.convertToYMD(productionDate);
		List<GetProductionDetail> getProductionDetailList;
        System.out.println(productionDate);
		getProductionDetailList = productionService.getProdQty(catId, productionDate, timeSlot);
		System.out.println("Data Common " + getProductionDetailList.toString());

		Info info = new Info();

		if (getProductionDetailList.toString()!=null) {

			info.setError(false);
			info.setMessage("  Successfully");

		}

		else {

			info.setError(true);
			info.setMessage("Error in  production order Qty insertion : RestApi");

		}

		return getProductionDetailList;

	}
	@RequestMapping(value = { "/getMenuIdByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<Integer> getMenuIdsByCatId(@RequestParam int catId)
	{
		
		List<Integer> menuList=productionService.getMenuIdsByCatId(catId);
		
		return menuList;
		
	}
	 
	
}
