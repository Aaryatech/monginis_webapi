package com.ats.webapi.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.gatesale.GateEmployee;
import com.ats.webapi.model.gatesale.GateSaleBillHeader;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderRes;
import com.ats.webapi.model.gatesale.GateSaleDiscList;
import com.ats.webapi.model.gatesale.GateSaleDiscount;
import com.ats.webapi.model.gatesale.GateSaleUser;
import com.ats.webapi.model.gatesale.GateSaleUserList;
import com.ats.webapi.model.gatesale.GetGateSaleEmp;
import com.ats.webapi.model.gatesale.GetGateSaleEmpList;
import com.ats.webapi.model.gatesale.OtherItem;
import com.ats.webapi.model.gatesale.OtherItemList;
import com.ats.webapi.model.gatesale.OtherSupplier;
import com.ats.webapi.model.gatesale.OtherSupplierList;
import com.ats.webapi.service.gatesale.GateSaleService;

@RestController
@RequestMapping("/gatesale")
public class GateSaleController {

	@Autowired
	GateSaleService gateSaleService;
	
	//----------------------Save Gate Sale User------------------------------------
	@RequestMapping(value = { "/saveGateSaleUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveGateSaleUser(@RequestBody GateSaleUser gateSaleUser)
	{
		
		ErrorMessage errorMessage=gateSaleService.saveGateSaleUser(gateSaleUser);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	//--------------------------Delete Gate Sale User--------------------------------------------------
		@RequestMapping(value = { "/deleteGateSaleUser" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteGateSaleUser(@RequestParam("userId")int userId)
		{
			
			ErrorMessage errorMessage=gateSaleService.deleteGateSaleUser(userId);
			
			return errorMessage;
		}
	//--------------------------END--------------------------------------------------
		// ---------------------------Getting GateSaleUser List-------------------------
		@RequestMapping(value = { "/getGateSaleUserList" }, method = RequestMethod.GET)
		public @ResponseBody GateSaleUserList getGateSaleUserList() {

			GateSaleUserList gateSaleUserList = gateSaleService.getGateSaleUserList();

			return gateSaleUserList;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting GateSaleUser By userId-------------------------
		@RequestMapping(value = { "/getGateSaleUserByUserId" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleUser getGateSaleUserByUserId(@RequestParam("userId")int userId) {

			GateSaleUser gateSaleUserRes = gateSaleService.getGateSaleUserByUserId(userId);
            
			return gateSaleUserRes;

		}
	    //------------------------------------------------------------------------------------
		// ---------------------------Getting LoginUser-------------------------
		@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleUser loginUser(@RequestParam("mobile")String mobile,@RequestParam("password")String password) {

			GateSaleUser gateSaleUserRes = gateSaleService.loginUser(mobile,password);
		            
			return gateSaleUserRes;

		}
		//------------------------------------------------------------------------------------
		// ---------------------------Update userToken-------------------------
		@RequestMapping(value = { "/updateUserToken" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage updateUserToken(@RequestParam("userId")int userId,@RequestParam("token")String token) {

			ErrorMessage errorMessage = gateSaleService.updateUserToken(userId,token);
				            
		return errorMessage;

		}
		//------------------------------------------------------------------------------------
		//----------------------Save Gate Sale Discount------------------------------------
		@RequestMapping(value = { "/saveGateSaleDiscount" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveGateSaleDiscount(@RequestBody GateSaleDiscount gateSaleDiscount)
		{
			
			ErrorMessage errorMessage=gateSaleService.saveGateSaleDiscount(gateSaleDiscount);
			
			return errorMessage;
		}
		//--------------------------END------------------------------------------------------
		//--------------------------Delete Gate Sale Discount--------------------------------
		@RequestMapping(value = { "/deleteGateSaleDiscount" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteGateSaleDiscount(@RequestParam("discountId")int discountId)
		{
			
			ErrorMessage errorMessage=gateSaleService.deleteGateSaleDiscount(discountId);
			
			return errorMessage;
		}
	//----------------------------------END-------------------------------------------------
		// ---------------------------Getting Gate Sale Discount List-----------------------
		@RequestMapping(value = { "/getGateSaleDiscList" }, method = RequestMethod.GET)
		public @ResponseBody GateSaleDiscList getGateSaleDiscList() {

			GateSaleDiscList gateSaleDiscList = gateSaleService.getGateSaleDiscList();

			return gateSaleDiscList;

		}
		//-------------------------------END----------------------------------------------
		// ---------------------------Getting Gate Sale Discount List By CatId-----------------------
		@RequestMapping(value = { "/getGateSaleDiscListByCatId" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleDiscList getGateSaleDiscListByCatId(@RequestParam("catId")int catId) {

			GateSaleDiscList gateSaleDiscList = gateSaleService.getGateSaleDiscListByCatId(catId);

			return gateSaleDiscList;

		}
		//-------------------------------END----------------------------------------------
		// ---------------------------Getting GateSaleDiscount By discountId-------------------------
		@RequestMapping(value = { "/getGateSaleDiscByDiscId" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleDiscount getGateSaleDiscByDiscId(@RequestParam("discountId")int discountId) {

			GateSaleDiscount gateSaleDiscountRes = gateSaleService.getGateSaleDiscByDiscId(discountId);
		            
			return gateSaleDiscountRes;

		}
	   //----------------------------END-------------------------------------------------
		//----------------------Save Employee------------------------------------
		@RequestMapping(value = { "/saveGateEmployee" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveGateEmployee(@RequestBody GateEmployee gateEmployee)
		{
			
			ErrorMessage errorMessage=gateSaleService.saveGateEmployee(gateEmployee);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete GateEmployee--------------------------------------------------
		@RequestMapping(value = { "/deleteGateEmployee" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteGateEmployee(@RequestParam("empId")int empId)
		{
					
			ErrorMessage errorMessage=gateSaleService.deleteGateEmployee(empId);
					
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//---------------------------Getting Gate  Emp List-------------------------
		@RequestMapping(value = { "/getGateEmpList" }, method = RequestMethod.GET)
		public @ResponseBody GetGateSaleEmpList getGateEmpList() {

			GetGateSaleEmpList getGateSaleEmpList = gateSaleService.getGateEmpList();

			return getGateSaleEmpList;

		}
		//------------------------------END-----------------------------------------------
	    //---------------------------Getting GateEmpList By empId-------------------------
		@RequestMapping(value = { "/getGateEmpByEmpId" }, method = RequestMethod.POST)
		public @ResponseBody GetGateSaleEmp getGateEmpByEmpId(@RequestParam("empId")int empId) {

			GetGateSaleEmp getGateSaleEmpRes = gateSaleService.getGateEmpByEmpId(empId);
				            
		 return getGateSaleEmpRes;

		}
	    //----------------------------------END-------------------------------------------
		//----------------------Insert GateSaleBill------------------------------------
		@RequestMapping(value = { "/saveGateSaleBill" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveGateSaleBill(@RequestBody GateSaleBillHeader gateSaleBillHeader)
		{
			Date date = new Date();
			gateSaleBillHeader.setBillDate(date);
			ErrorMessage errorMessage=gateSaleService.saveGateSaleBill(gateSaleBillHeader);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		// ---------------------------Getting GateBillHeaderAndDetails By userId-------------------------
				@RequestMapping(value = { "/gateBillHeaderAndDetails" }, method = RequestMethod.POST)
				public @ResponseBody List<GateSaleBillHeaderRes> gateBillHeaderAndDetails(@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate,
						@RequestParam("isApproved")int isApproved,@RequestParam("approvedUserId")int approvedUserId,@RequestParam("amtIsCollected")int amtIsCollected,
						@RequestParam("collectedUserId")int collectorUserId) {

					List<GateSaleBillHeaderRes> gateBillHeadersRes = gateSaleService.gateBillHeaderAndDetails(fromDate,toDate,isApproved,approvedUserId,amtIsCollected,collectorUserId);
		            
					return gateBillHeadersRes;

				}
			    //------------------------------------------------------------------------------------
				//----------------------approveGetSaleBill------------------------------------
				@RequestMapping(value = { "/approveGetSaleBill" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage approveGetSaleBill(@RequestParam("billId")int billId,@RequestParam("isApproved")int isApproved,@RequestParam("approvedUserId")int approvedUserId)
				{
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.now();
					ErrorMessage errorMessage=gateSaleService.approveGetSaleBill(billId,isApproved,dtf.format(localDate),approvedUserId);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------	
				//----------------------collectGetSaleAmt------------------------------------
				@RequestMapping(value = { "/collectGetSaleAmt" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage collectGetSaleAmt(@RequestParam("billId")int billId,@RequestParam("amtIsCollected")int amtIsCollected,@RequestParam("collectedUserId")int collectedUserId)
				{
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.now();
					ErrorMessage errorMessage=gateSaleService.collectGetSaleAmt(billId,amtIsCollected,dtf.format(localDate),collectedUserId);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------	
				//----------------------Save GateSaleOtherSupplier------------------------------------
				@RequestMapping(value = { "/saveGateOtherSupplier" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage saveGateOtherSupplier(@RequestBody OtherSupplier otherSupplier)
				{
					
					ErrorMessage errorMessage=gateSaleService.saveGateOtherSupplier(otherSupplier);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//----------------------Save GateSaleSaleOtherItem------------------------------------
				@RequestMapping(value = { "/saveGateOtherItem" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage saveGateOtherItem(@RequestBody OtherItem otherItem)
				{
					
					ErrorMessage errorMessage=gateSaleService.saveGateOtherItem(otherItem);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//--------------------------Delete GateOtherItem--------------------------------------------------
				@RequestMapping(value = { "/deleteGateOtherItem" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage deleteGateOtherItem(@RequestParam("itemId")int itemId)
				{
							
					ErrorMessage errorMessage=gateSaleService.deleteGateOtherItem(itemId);
							
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//--------------------------Delete GateOtherSupplier--------------------------------------------------
				@RequestMapping(value = { "/deleteGateOtherSupplier" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage deleteGateOtherSupplier(@RequestParam("suppId")int suppId)
				{
							
					ErrorMessage errorMessage=gateSaleService.deleteGateOtherSupplier(suppId);
							
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//---------------------------Getting GateSupplierList-------------------------
				@RequestMapping(value = { "/getGateOtherSuppList" }, method = RequestMethod.GET)
				public @ResponseBody OtherSupplierList getGateOtherSuppList() {

					OtherSupplierList otherSupplierListRes = gateSaleService.getGateOtherSuppList();

					return otherSupplierListRes;

				}
				//------------------------------END-----------------------------------------------
				// ---------------------------Getting Gate OtherItem List By suppId-----------------------
				@RequestMapping(value = { "/getGateOtherItemBySuppId" }, method = RequestMethod.POST)
				public @ResponseBody OtherItemList getGateOtherItemBySuppId(@RequestParam("suppId")int suppId) {

					OtherItemList otherItemListRes = gateSaleService.getGateOtherItemBySuppId(suppId);

					return otherItemListRes;

				}
				//-------------------------------END----------------------------------------------
				// ---------------------------Getting GateOtherItem By itemId-------------------------
				@RequestMapping(value = { "/getGateOtherItemByItemId" }, method = RequestMethod.POST)
				public @ResponseBody OtherItem getGateOtherItemByItemId(@RequestParam("itemId")int itemId) {

					OtherItem gateOtherItemRes = gateSaleService.getGateOtherItemByItemId(itemId);
		            
					return gateOtherItemRes;

				}
			    //------------------------------------------------------------------------------------
				// ---------------------------Getting GateOtherSupplier By SuppId-------------------------
				@RequestMapping(value = { "/getGateOtherSupplierBySuppId" }, method = RequestMethod.POST)
				public @ResponseBody OtherSupplier getGateOtherSupplierBySuppId(@RequestParam("suppId")int suppId) {

					OtherSupplier gateOtherSupplierRes = gateSaleService.getGateOtherSupplierBySuppId(suppId);
		            
					return gateOtherSupplierRes;

				}
			    //------------------------------------------------------------------------------------
}
