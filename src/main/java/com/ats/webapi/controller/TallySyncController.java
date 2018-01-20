package com.ats.webapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.model.SupplierMaster.SupplierDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialDetailsList;
import com.ats.webapi.model.tally.CreditNoteList;
import com.ats.webapi.model.tally.FranchiseeList;
import com.ats.webapi.model.tally.ItemList;
import com.ats.webapi.model.tally.MaterialRecNoteList;
import com.ats.webapi.model.tally.MaterialReceiptNote;
import com.ats.webapi.model.tally.RawMaterialResList;
import com.ats.webapi.model.tally.SalesVoucherList;
import com.ats.webapi.model.tally.SpCakeList;
import com.ats.webapi.model.tally.SuppliersList;
import com.ats.webapi.service.SuppilerMasterService;
import com.ats.webapi.service.MaterialRcNote.MaterialRecNoteService;
import com.ats.webapi.service.rawmaterial.RawMaterialService;
import com.ats.webapi.service.tally.CreditNoteService;
import com.ats.webapi.service.tally.FranchiseeService;
import com.ats.webapi.service.tally.SalesVoucherService;
import com.ats.webapi.service.tally.SpCakeService;
import com.ats.webapi.service.tally.TallyItemService;
import com.ats.webapi.util.JsonUtil;

@RestController
@RequestMapping("/tally")
public class TallySyncController {

	@Autowired
	FranchiseeService franchiseeService;
	
	@Autowired
	TallyItemService itemService;
	
	@Autowired
	SpCakeService specialCakeService;
	
	@Autowired
	SalesVoucherService salesVoucherService;
	
	@Autowired
	CreditNoteService creditNoteService;
	
	@Autowired
	SuppilerMasterService supplierMasterService;
	
	@Autowired
	RawMaterialService rawMaterialService;
	
	@Autowired
	MaterialRecNoteService materialRecNoteService;
	
	@RequestMapping(value = { "/getAllFranchisee" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllFranchisee()
	  {

		    FranchiseeList franchiseeList=franchiseeService.getAllFranchisee();
		    
		    String regData =JsonUtil.javaToJson(franchiseeList);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=allFranchisee.txt");



		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);


	  }
	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllItem()
	  {

		    ItemList itemList=itemService.getAllItems();
		    
            String regData =JsonUtil.javaToJson(itemList);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=allItems.txt");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		    
	  }
	@RequestMapping(value = { "/getAllSpCake" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllSpCake()
	  {

		SpCakeList spCakeList=specialCakeService.getAllSpCake();
		    
		String regData =JsonUtil.javaToJson(spCakeList);

	    byte[] output = regData.getBytes();

	    HttpHeaders responseHeaders = new HttpHeaders();

	    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

	    responseHeaders.setContentLength(output.length);

	    responseHeaders.set("Content-disposition", "attachment; filename=allSpecialCakes.txt");

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	    
	  }
	
	@RequestMapping(value = { "/updateFranchisees" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> updateFranchisees(@RequestParam("customerId")int customerId,@RequestParam("isTallySync")int isTallySync)
	  {
		
		ErrorMessage errorMessage=franchiseeService.updateFranchisees(customerId,isTallySync);
		
		String regData =JsonUtil.javaToJson(errorMessage);

	    byte[] output = regData.getBytes();

	    HttpHeaders responseHeaders = new HttpHeaders();

	    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

	    responseHeaders.setContentLength(output.length);

	    responseHeaders.set("Content-disposition", "attachment; filename=updateFranchisees.txt");

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	  }
	
	  @RequestMapping(value = { "/updateItems" }, method = RequestMethod.GET)
	  public @ResponseBody ResponseEntity<byte[]> updateItems(@RequestParam("id")int id,@RequestParam("isTallySync")int isTallySync)
	  {

		    ErrorMessage errorMessage=itemService.updateItems(id,isTallySync);
		    
		    String regData =JsonUtil.javaToJson(errorMessage);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=updateItems.txt");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	  }
	  
	  @RequestMapping(value = { "/updateSpCakes" }, method = RequestMethod.GET)
		public @ResponseBody ResponseEntity<byte[]> updateSpCakes(@RequestParam("id")int id,@RequestParam("isTallySync")int isTallySync)
		  {

		  ErrorMessage errorMessage=specialCakeService.updateSpCakes(id,isTallySync);
			    
		  String regData =JsonUtil.javaToJson(errorMessage);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=updateSpecialCakes.txt");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		  }
		
	     @RequestMapping(value = { "/getAllSalesVouchers" }, method = RequestMethod.GET)
		public @ResponseBody ResponseEntity<byte[]> showAllSalesVoucher()
		  {

	    	 SalesVoucherList salesVoucherList=salesVoucherService.getAllSalesVoucher();
			    
	    	 String regData =JsonUtil.javaToJson(salesVoucherList);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=allSalesVouchers.txt");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		  }
	     @RequestMapping(value = { "/updateSalesVoucher" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> updateSalesVouchers(@RequestParam("VNo")int billNo,@RequestParam("isTallySync")int isTallySync)
			  {

			  ErrorMessage errorMessage=salesVoucherService.updateSalesVouchers(billNo,isTallySync);
				    
			  String regData =JsonUtil.javaToJson(errorMessage);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=updateSalesVouchers.txt");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
			  }
	     @RequestMapping(value = { "/getAllCreditNotes" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> showAllCreditNote()
			  {

	    	 CreditNoteList creditNoteList=creditNoteService.getAllCreditNote();
				    
	    	 String regData =JsonUtil.javaToJson(creditNoteList);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=allCreditNotes.txt");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
			    
			  }
	     @RequestMapping(value = { "/updateCreditNote" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> updateCreditNote(@RequestParam("VNo")int crnId,@RequestParam("isTallySync")int isTallySync)
			  {

			  ErrorMessage errorMessage=creditNoteService.updateCreditNote(crnId,isTallySync);
				    
			  String regData =JsonUtil.javaToJson(errorMessage);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=updateCreditNotes.txt");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
			  }
			//-------------------------------------------------------------------------------------
			@RequestMapping(value = { "/getAllSupplier" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> getAllSupplier()
			{
				SuppliersList supplierList=supplierMasterService.getAllSupplierForTally();
				
				 String regData =JsonUtil.javaToJson(supplierList);

				    byte[] output = regData.getBytes();

				    HttpHeaders responseHeaders = new HttpHeaders();

				    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

				    responseHeaders.setContentLength(output.length);

				    responseHeaders.set("Content-disposition", "attachment; filename=allSuppliers.txt");

				    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
				
			}
			//-------------------------------------------------------------------------------------
			//------------------------------Get All RM Master-------------------------------------
			@RequestMapping(value = { "/getAllRawMaterial" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> getAllRawMaterial()
			{
				RawMaterialResList rawMaterialDetailsList=rawMaterialService.getAllRawMaterialForTally();
				
				 String regData =JsonUtil.javaToJson(rawMaterialDetailsList);

				    byte[] output = regData.getBytes();

				    HttpHeaders responseHeaders = new HttpHeaders();

				    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

				    responseHeaders.setContentLength(output.length);

				    responseHeaders.set("Content-disposition", "attachment; filename=allRawMaterial.txt");

				    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
				
			}
			//----------------------------------------------------------------------------------------
			   @RequestMapping(value = { "/updateSupplier" }, method = RequestMethod.GET)
				public @ResponseBody ResponseEntity<byte[]> updateSupplier(@RequestParam("suppId")int suppId,@RequestParam("isTallySync")int isTallySync)
				  {

				  ErrorMessage errorMessage=supplierMasterService.updateSupplier(suppId,isTallySync);
					    
				  String regData =JsonUtil.javaToJson(errorMessage);

				    byte[] output = regData.getBytes();

				    HttpHeaders responseHeaders = new HttpHeaders();

				    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

				    responseHeaders.setContentLength(output.length);

				    responseHeaders.set("Content-disposition", "attachment; filename=updateSupplier.txt");

				    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
				  }
				//----------------------------------------------------------------------------------------
				   @RequestMapping(value = { "/updateRawMaterial" }, method = RequestMethod.GET)
					public @ResponseBody ResponseEntity<byte[]> updateRawMaterial(@RequestParam("rmId")int rmId,@RequestParam("isTallySync")int isTallySync)
					  {

					  ErrorMessage errorMessage=rawMaterialService.updateRawMaterial(rmId,isTallySync);
						    
					  String regData =JsonUtil.javaToJson(errorMessage);

					    byte[] output = regData.getBytes();

					    HttpHeaders responseHeaders = new HttpHeaders();

					    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

					    responseHeaders.setContentLength(output.length);

					    responseHeaders.set("Content-disposition", "attachment; filename=updateRawMaterial.txt");

					    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
					  }	
					@RequestMapping(value = { "/getAllInwards" }, method = RequestMethod.GET)
					public @ResponseBody ResponseEntity<byte[]> getAllInwards()
					{

						MaterialRecNoteList materialRecNoteRes = materialRecNoteService.getAllInwards();
						  String regData =JsonUtil.javaToJson(materialRecNoteRes);

						    byte[] output = regData.getBytes();

						    HttpHeaders responseHeaders = new HttpHeaders();

						    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

						    responseHeaders.setContentLength(output.length);

						    responseHeaders.set("Content-disposition", "attachment; filename=allInwards.txt");

						    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
					}
					
					//----------------------------------------------------------------------------------------
					   @RequestMapping(value = { "/updateInward" }, method = RequestMethod.GET)
						public @ResponseBody ResponseEntity<byte[]> updateInward(@RequestParam("mrnId")int mrnId,@RequestParam("isTallySync")int isTallySync)
						  {

						  ErrorMessage errorMessage=materialRecNoteService.updateInward(mrnId,isTallySync);
							    
						  String regData =JsonUtil.javaToJson(errorMessage);

						    byte[] output = regData.getBytes();

						    HttpHeaders responseHeaders = new HttpHeaders();

						    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

						    responseHeaders.setContentLength(output.length);

						    responseHeaders.set("Content-disposition", "attachment; filename=updateInward.txt");

						    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
						  }	
}
