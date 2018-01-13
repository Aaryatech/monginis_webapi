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
				
}
