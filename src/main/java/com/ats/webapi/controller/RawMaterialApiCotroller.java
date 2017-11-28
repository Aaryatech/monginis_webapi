package com.ats.webapi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.rawmaterial.GetRawMaterialByGroup;
import com.ats.webapi.model.rawmaterial.GetRawMaterialDetailList;
import com.ats.webapi.model.rawmaterial.GetUomAndTax;
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialTaxDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialTaxDetailsList;
import com.ats.webapi.model.rawmaterial.RawMaterialUom;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemGroup;
import com.ats.webapi.model.rawmaterial.RmItemSubCatList;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;
import com.ats.webapi.model.rawmaterial.RmRateVerification;
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
	//------------------------------------Get Rm Details------------------------------------
	@RequestMapping(value = { "/getRawMaterialDetail" }, method = RequestMethod.POST)
	public @ResponseBody RawMaterialDetails getRawMaterialDetail(@RequestParam ("rmId")int rmId)
	{
		RawMaterialDetails rawMaterialDetails=rawMaterialService.getRawMaterialDetails(rmId);
		return rawMaterialDetails;
		 
		
	}
	
	//------------------------------------Get Rm Details By group------------------------------------
		@RequestMapping(value = { "/getRawMaterialDetailByGroup" }, method = RequestMethod.POST)
		public @ResponseBody List<GetRawMaterialByGroup> getRawMaterialDetailByGroup(@RequestParam ("grpId")int grpId)
		{
			List<GetRawMaterialByGroup> getRawMaterialByGroupList=rawMaterialService.getRawMaterialDetailByGroup(grpId);
			return getRawMaterialByGroupList;
			 
			
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
	//-----------------------------------get RM UOM--------------------------
	@RequestMapping(value = { "/getRmUom" }, method = RequestMethod.GET)
	public @ResponseBody List<RawMaterialUom> getRmUom()
	{
		List<RawMaterialUom> rawMaterialUomList=rawMaterialService.getAllUom();
		return rawMaterialUomList;
	}
	//-----------------------------getRM Gst--------------------------------------
	
	@RequestMapping(value = { "/getAllRmTax" }, method = RequestMethod.GET)
	public @ResponseBody List<RawMaterialTaxDetails> getAllRmTax()
	{
		List<RawMaterialTaxDetails> rawMaterialTaxDetailsList=rawMaterialService.getAllRmTax();
		return rawMaterialTaxDetailsList;
	}
	
	//---------------------------------------getRateVerification------------------------------
	
	@RequestMapping(value = { "/getRmRateVerification" }, method = RequestMethod.POST)
	public @ResponseBody RmRateVerification getRmRateVerification(@RequestParam("suppId")int suppId, @RequestParam("rmId")int rmId)
	{
		RmRateVerification rmRateVerification=rawMaterialService.getRmRateTaxVerification(suppId, rmId);
		rmRateVerification.setDate2(Common.convertToDMY(rmRateVerification.getDate2()));
		rmRateVerification.setDate1(Common.convertToDMY(rmRateVerification.getDate1()));
		rmRateVerification.setRateDate(Common.convertToDMY(rmRateVerification.getRateDate()));
		
		return rmRateVerification;
	}
	//------------------------------------------SubmitRmRateVerification---------------------
	@RequestMapping(value = { "/insertRmRateVerification" }, method = RequestMethod.POST)
	public @ResponseBody Info insertRmRateVerification(@RequestBody RmRateVerification rmRateVerification)
	{
		System.out.println("Before : "+rmRateVerification.toString());
		//toDate = Common.convertToYMD(toDate);
		rmRateVerification.setDate1(Common.convertToYMD(rmRateVerification.getDate1()));
		rmRateVerification.setDate2(Common.convertToYMD(rmRateVerification.getDate2()));
		rmRateVerification.setRateDate(Common.convertToYMD(rmRateVerification.getRateDate()));
		System.out.println("Before : "+rmRateVerification.toString());
		RmRateVerification rmRateVerify=rawMaterialService.postRmRateVerification(rmRateVerification);
		Info info=new Info();
		if(rmRateVerify!=null)
		{
			info.setError(false);
			info.setMessage("Rm Rate Verification Insert Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to insert Rm Rate Verification");
		}
		return info;
	}
	//----------------------------------Insert RM Tax------------------------------
	@RequestMapping(value = { "/insertRmTax" }, method = RequestMethod.POST)
	public @ResponseBody Info insertRmTax(@RequestBody RawMaterialTaxDetails rawMaterialTaxDetails)
	{
	
		RawMaterialTaxDetails rawMaterialTax=rawMaterialService.insertRmTax(rawMaterialTaxDetails);
		Info info=new Info();
		if(rawMaterialTax!=null)
		{
			info.setError(false);
			info.setMessage("RM Tax Insert Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to insert RM Tax ");
		}
		return info;
	}
	
	//-----------------------------------Insert RM UOM--------------------------
	@RequestMapping(value = { "/insertRmUom" }, method = RequestMethod.POST)
	public @ResponseBody Info insertRmUom(@RequestBody RawMaterialUom rawMaterialUom)
	{
		RawMaterialUom rMUom=rawMaterialService.insertRmUom(rawMaterialUom);
		Info info=new Info();
		if(rMUom!=null)
		{
			info.setError(false);
			info.setMessage("RM Uom insert successFully");
		}
		else
		{
			info.setError(true);
			info.setMessage("failed to insert RM Uom");
		}
		return info;
	}
	
	//---------------------------------------getRmUomAndTax------------------------------
	
	@RequestMapping(value = { "/getUomAndTax" }, method = RequestMethod.POST)
	public @ResponseBody GetUomAndTax getUomAndTax(@RequestParam("rmId")int rmId)
	{
		GetUomAndTax getUomAndTax=rawMaterialService.getUomAndTax( rmId);
		return getUomAndTax;
	}
	
	@RequestMapping(value = { "/getAllRawMaterialList" }, method = RequestMethod.GET)
	public @ResponseBody GetRawMaterialDetailList getAllRawMaterialList()
	{
		List<RawMaterialDetails> rawMaterialDetails=rawMaterialService.getAllRawMaterial();
		GetRawMaterialDetailList rawMaterialDetailsList=new GetRawMaterialDetailList();
		rawMaterialDetailsList.setRawMaterialDetailsList(rawMaterialDetails);
		Info info=new Info();
		if(rawMaterialDetails!=null)
		{
			info.setError(false);
			info.setMessage("successFully");
			rawMaterialDetailsList.setInfo(info);
		}
		else
		{
		 
				info.setError(true);
				info.setMessage("unsuccessFully");
				rawMaterialDetailsList.setInfo(info);
			 
		}
		return rawMaterialDetailsList;
		 
		
	}
	
	@RequestMapping(value = { "/getAllRmTaxList" }, method = RequestMethod.GET)
	public @ResponseBody RawMaterialTaxDetailsList getAllRmTaxList()
	{
		List<RawMaterialTaxDetails> rawMaterialTaxDetails=rawMaterialService.getAllRmTax();
		RawMaterialTaxDetailsList rawMaterialTaxDetailsList=new RawMaterialTaxDetailsList();
		rawMaterialTaxDetailsList.setRawMaterialTaxDetailsList(rawMaterialTaxDetails);
		Info info=new Info();
		if(rawMaterialTaxDetailsList!=null)
		{
			info.setError(false);
			info.setMessage("successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("unsuccessfully");
		}
		return rawMaterialTaxDetailsList;
	}
	
	
}
