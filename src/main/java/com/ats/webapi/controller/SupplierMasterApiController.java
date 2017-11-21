package com.ats.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.SupplierMaster.SupplierDetails;
import com.ats.webapi.service.SuppilerMasterService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class SupplierMasterApiController {

	@Autowired
	SuppilerMasterService suppilerMasterService;
	
	@RequestMapping(value = { "/addNewSupplier" }, method = RequestMethod.POST)
	public @ResponseBody Info addNewSupplier(@RequestBody SupplierDetails supplierDetails)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Data : "+supplierDetails);
		SupplierDetails supplier=suppilerMasterService.addSuppler(supplierDetails);
		Info info=new Info();
		if(supplier!=null)
		{
			info.setError(false);
			info.setMessage("Add new Supplier Successfully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem in Add new Supplier");
		}
		
		return info;
	
}
	
	@RequestMapping(value = { "/getAllSupplier" }, method = RequestMethod.GET)
	public @ResponseBody List<SupplierDetails> getAllSupplier()
	{
		List<SupplierDetails> supplierDetailsList=suppilerMasterService.getAllSupplier();
		if(supplierDetailsList!=null)
		{
			System.out.println("Supplier List "+ supplierDetailsList.toString());
		}
		else
		{
			System.out.println("No supplier in List");
		}
		return supplierDetailsList;
		
	}
	
	@RequestMapping(value = { "/getSupplierDetails" }, method = RequestMethod.POST)
	public @ResponseBody SupplierDetails getSupplierDetails(@RequestParam("suppId") int suppId)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Supp Id : "+suppId);
		SupplierDetails supplierDetails=suppilerMasterService.getSupplier(suppId);
		 
		if(supplierDetails.getSuppName()!=null)
		{
			 
			System.out.println("Suppiler  Name"+supplierDetails.getSuppName());
		}
		else {
			System.out.println("Suppiler not exist");
		}
		
		return supplierDetails;
	
}
	
	@RequestMapping(value = { "/deleteSupplier" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSupplier(@RequestParam("suppId") int suppId)
	{
		System.out.println("Supp Id : "+suppId);
		int result=suppilerMasterService.deleteSupplier(suppId);
		
		Info info=new Info();
		if(result>0)
		{
			info.setError(false);
			info.setMessage("Delete SuccessFully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Deletion Failed");
		}
		return info;
		
	}
}
