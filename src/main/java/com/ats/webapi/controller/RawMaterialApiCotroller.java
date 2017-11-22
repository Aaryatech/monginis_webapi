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
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemGroup;
import com.ats.webapi.model.rawmaterial.RmItemSubCatList;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;
import com.ats.webapi.service.rawmaterial.RawMaterialService;


@RestController
@RequestMapping("/rawMaterial")
public class RawMaterialApiCotroller {

	@Autowired
	RawMaterialService rawMaterialService;
	
	//----------------------Get Data Of Raw Material Item Categories---------------
	@RequestMapping(value = { "/showRmItemCategories" }, method = RequestMethod.GET)
	public @ResponseBody RmItemCatList showRmItemCategories() {

		RmItemCatList rmItemCatList=rawMaterialService.getRmItemCategories();
		    
			return rmItemCatList;
	  }
	//-------------------------END---------------------------------------------------
	
	//----------------------Get Data Of Raw Material Item SubCategories---------------
	@RequestMapping(value = { "/showRmItemSubCategories" }, method = RequestMethod.GET)
	public @ResponseBody RmItemSubCatList showRmItemSubCategories() {

		RmItemSubCatList rmItemSubCatList=rawMaterialService.getRmItemSubCategories();
		    
			return rmItemSubCatList;
	  }
	//--------------------------END--------------------------------------------------
	//----------------------Save Raw Material Item Category---------------
	@RequestMapping(value = { "/saveRmItemCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveRmItemCategory(@RequestBody RmItemCategory rmItemCategory)
	{
		
		ErrorMessage errorMessage=rawMaterialService.saveItemCategory(rmItemCategory);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	
	//----------------------Save Raw Material Item Sub Category---------------
	@RequestMapping(value = { "/saveRmItemSubCategory" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveRmItemSubCategory(@RequestBody RmItemSubCategory rmItemSubCategory)
		{
			
			ErrorMessage errorMessage=rawMaterialService.saveItemSubCategory(rmItemSubCategory);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
	@RequestMapping(value = { "/deleteRmItemCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRmItemCategory(@RequestParam("catId")int catId)
	{
		
		ErrorMessage errorMessage=rawMaterialService.deleteRmItemCategory(catId);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	
	//--------------------------END--------------------------------------------------
	@RequestMapping(value = { "/deleteRmItemSubCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRmItemSubCategory(@RequestParam("subCatId")int subCatId)
	{
		
		ErrorMessage errorMessage=rawMaterialService.deleteRmItemSubCategory(subCatId);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	
	//--------------------------GetOne Item Category By catId--------------------------------------------------
	@RequestMapping(value = { "/getRmItemCategory" }, method = RequestMethod.POST)
	public @ResponseBody RmItemCategory getRmItemCategory(@RequestParam("catId")int catId)
	{
		
		RmItemCategory rmItemCategory=rawMaterialService.getRmItemCategory(catId);
		
		return rmItemCategory;
	}
	//--------------------------END--------------------------------------------------
	
	//--------------------------GetOneBySubCatId--------------------------------------------------
	@RequestMapping(value = { "/getRmItemSubCategory" }, method = RequestMethod.POST)
	public @ResponseBody RmItemSubCategory getRmItemSubCategory(@RequestParam("subCatId")int subCatId)
	{
		
		RmItemSubCategory rmItemSubCategory=rawMaterialService.getRmItemSubCategory(subCatId);
		
		return rmItemSubCategory;
	}
	//--------------------------END--------------------------------------------------
	//--------------------------GetOneBySubCatId--------------------------------------------------
		@RequestMapping(value = { "/getRmItemSubCategories" }, method = RequestMethod.POST)
		public @ResponseBody List<RmItemSubCategory> getRmItemSubCategories(@RequestParam("catId")int catId)
		{
			
			List<RmItemSubCategory> rmItemSubCategories=rawMaterialService.getRmItemSubCategories(catId);
			
			return rmItemSubCategories;
		}
		//--------------------------END--------------------------------------------------
	
	
	
	//---------------------------addNew RM Master----------------------------------
	
	@RequestMapping(value = { "/addRawMaterial" }, method = RequestMethod.POST)
	public @ResponseBody Info addRawMaterial(@RequestBody RawMaterialDetails rawMaterialDetails)
	{
		System.out.println("Data  : "+rawMaterialDetails.toString());
		Info info=rawMaterialService.addRawMaterial(rawMaterialDetails);
		return info;
		
	}
	//---------------------Delete RM Master----------------------------------
	
	@RequestMapping(value = { "/deleteRawMaterial" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRawMaterial(@RequestParam ("rmId")int rmId)
	{
		Info info=rawMaterialService.deleteRawMaterial(rmId);
		return info;
		
	}
	
	//------------------------------Get All RM Master-------------------------------------
	@RequestMapping(value = { "/getAllRawMaterial" }, method = RequestMethod.GET)
	public @ResponseBody List<RawMaterialDetails> getAllRawMaterial()
	{
		List<RawMaterialDetails> rawMaterialDetailsList=rawMaterialService.getAllRawMaterial();
		return rawMaterialDetailsList;
		 
		
	}
	//------------------------------------Get Rm Master------------------------------------
	@RequestMapping(value = { "/getRawMasterDetail" }, method = RequestMethod.POST)
	public @ResponseBody RawMaterialDetails getRawMasterDetail(@RequestParam ("rmId")int rmId)
	{
		RawMaterialDetails rawMaterialDetails=rawMaterialService.getRawMaterialDetails(rmId);
		return rawMaterialDetails;
		 
		
	}
	
	//-------------------------------getCategory-----------------------------------------------
	@RequestMapping(value = { "/getRmItemCategories" }, method = RequestMethod.POST)
	public @ResponseBody List<RmItemCategory> getRmItemCategories(@RequestParam("grpId")int grpId)
	{
		
		List<RmItemCategory> rmItemCategorieList=rawMaterialService.getCategories(grpId);
		
		return rmItemCategorieList;
	}
	//----------------------------getAllGroup----------------------------------------
	@RequestMapping(value = { "/getAllRmItemGroup" }, method = RequestMethod.GET)
	public @ResponseBody List<RmItemGroup> getAllRmItemGroup()
	{
		List<RmItemGroup> rmItemGroupList=rawMaterialService.getAllGroup();
		return rmItemGroupList;
	}
}
