package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.flavour.FlavourDetail;
import com.ats.webapi.model.flavour.FlavourDetailList;
import com.ats.webapi.model.flavour.FlavourRawMaterialInfo;
import com.ats.webapi.repository.FlavourDetailRepo;
import com.ats.webapi.repository.flavour.FlavourRawMaterialInfoRepo;
@RestController
public class FlavourApiController {
	
	@Autowired FlavourDetailRepo flavourRepo;
	
	//Add Flavour
		@Autowired FlavourDetailRepo flavourDetailRepo;
		@RequestMapping(value = { "/saveFlavourDetails" }, method = RequestMethod.POST)
		public @ResponseBody Info saveFlavourDetails(@RequestBody List<FlavourDetail> flavourDetailList)
		{
			System.out.println("Flavour Deatil:"+flavourDetailList.toString());
			
			List<FlavourDetail> iDetail=flavourRepo.save(flavourDetailList);
			Info info=new Info();
			if(iDetail!=null)
			{
				info.setError(false);
				info.setMessage("FlavourDetail  inserted successFully");
			}
			else
			{
				info.setError(true);
				info.setMessage("failed to insert FlavourDetail");
			}
			return info;
		}
	
	@RequestMapping(value = { "/getflavourDetails" }, method = RequestMethod.POST)
	public @ResponseBody FlavourDetailList getItemDetails(@RequestParam ("id")int id)
	{System.out.println("Id Found-------"+id);
		List<FlavourDetail> flvrDetails=flavourRepo.getFlavourDetails(id);
		System.out.println("Flvr List--------"+flvrDetails);
		
		FlavourDetailList flvrDetailList=new FlavourDetailList();
		
		ErrorMessage errorMessage=new ErrorMessage();
		if(flvrDetails!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("FlavourDetail List  Found successFully");
			flvrDetailList.setErrorMessage(errorMessage);
			flvrDetailList.setFlavourDetailList(flvrDetails);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("ItemDetail List Not Found.");
			flvrDetailList.setErrorMessage(errorMessage);
		}
		return flvrDetailList;
	}
	
	//Flavour Raw Material Details
	
	@Autowired FlavourRawMaterialInfoRepo flvrRawMatrl;
	@RequestMapping(value = { "/getRawMaterialDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<FlavourRawMaterialInfo> getRawMaterialDetails(@RequestParam("spOrderNo") List<String> spOrderNo)
	{
		System.out.println("OrdNo--------"+spOrderNo);
		List<FlavourRawMaterialInfo> list =flvrRawMatrl.getFlavourRawMaterialDetails(spOrderNo);
		System.out.println("Flvr List--------"+list);
		
		return list;
	}
	
}
