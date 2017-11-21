package com.ats.webapi.service.rawmaterial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemSubCatList;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;
import com.ats.webapi.repository.RmItemCategoryRepository;
import com.ats.webapi.repository.RmItemSubCategoryRepository;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{

	@Autowired
	RmItemCategoryRepository rmItemCategoryRepository;
	
	@Autowired
	RmItemSubCategoryRepository rmItemSubCategoryRepository;
	
	@Override
	public RmItemCatList getRmItemCategories() {

		RmItemCatList rmItemCategoryList=new RmItemCatList();
		
		List<RmItemCategory> rmItemCatList=rmItemCategoryRepository.findRmItemCategoryByDelStatus(0); 
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(rmItemCatList==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Raw Material Item Categories Not Found.");
			
			rmItemCategoryList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Raw Material Item Categories Found Successfully.");
			
			rmItemCategoryList.setErrorMessage(errorMessage);
			rmItemCategoryList.setRmItemCategoryList(rmItemCatList);
			
		}
		return rmItemCategoryList;
	}

	@Override
	public RmItemSubCatList getRmItemSubCategories() {

		RmItemSubCatList rmItemSubCategoryList=new RmItemSubCatList();
		
		List<RmItemSubCategory> rmItemSubCatList=rmItemSubCategoryRepository.findRmItemSubCategoryByDelStatus(0); 
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(rmItemSubCatList==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Raw Material Item Categories Not Found.");
			
			rmItemSubCategoryList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Raw Material Item Categories Found Successfully.");
			
			rmItemSubCategoryList.setErrorMessage(errorMessage);
			rmItemSubCategoryList.setRmItemSubCategory(rmItemSubCatList);
			
		}
		return rmItemSubCategoryList;
	}

	@Override
	public ErrorMessage saveItemCategory(RmItemCategory rmItemCategory) {

		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemCategory rmItemCategoryRes=rmItemCategoryRepository.save(rmItemCategory);
		
		if(rmItemCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Insert Raw Material Item Category.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage(" Raw Material Item Category  Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Error:Failed To Insert Raw Material Item  SubCategory.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage saveItemSubCategory(RmItemSubCategory rmItemSubCategory) {

		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemSubCategory rmItemSubCategoryRes=rmItemSubCategoryRepository.save(rmItemSubCategory);
		
		if(rmItemSubCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Insert Raw Material Item  SubCategory.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Raw Material Item SubCategory  Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Error:Failed To Insert Raw Material Item  SubCategory.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteRmItemCategory(int catId) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemCategory rmItemCategory=rmItemCategoryRepository.findRmItemCategoryByCatId(catId);
		
		rmItemCategory.setDelStatus(1);
		
		RmItemCategory rmItemCategoryRes=rmItemCategoryRepository.save(rmItemCategory);
		
		if(rmItemCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Delete Raw Material Item Category.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage(" Raw Material Item Category deleted Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Failed To Delete Raw Material ItemCategory.");
			return errorMessage;
		}
		return errorMessage;

	}
	
	@Override
	public ErrorMessage deleteRmItemSubCategory(int subCatId) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemSubCategory rmItemSubCategory=rmItemSubCategoryRepository.findRmItemSubCategoryBySubCatId(subCatId);
		
		rmItemSubCategory.setDelStatus(1);
		
		RmItemSubCategory rmItemSubCategoryRes=rmItemSubCategoryRepository.save(rmItemSubCategory);
		
		if(rmItemSubCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Delete Raw Material Item Sub Category.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage(" Raw Material Item Sub Category deleted Successfully.");
			
		}

		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Failed To Delete Raw Material Item Sub Category.");
			return errorMessage;
		}
		return errorMessage;

	}
}
