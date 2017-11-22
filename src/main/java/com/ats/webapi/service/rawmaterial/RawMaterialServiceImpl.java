package com.ats.webapi.service.rawmaterial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.SupplierMaster.Transporter;
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemSubCatList;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;
import com.ats.webapi.repository.RmItemCategoryRepository;
import com.ats.webapi.repository.RmItemSubCategoryRepository;
import com.ats.webapi.repository.RawMaterialDetailsRepository;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{

	@Autowired
	RmItemCategoryRepository rmItemCategoryRepository;
	
	@Autowired
	RmItemSubCategoryRepository rmItemSubCategoryRepository;
	
	@Autowired
	RawMaterialDetailsRepository RawMaterialDetailsRepository;
	
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

	@Override
	public Info addRawMaterial(RawMaterialDetails rawMaterialMasterDetails) {
		
		RawMaterialDetails rawMaterialMaster=RawMaterialDetailsRepository.save(rawMaterialMasterDetails);
		
		Info info=new Info();
		if(rawMaterialMaster!=null)
		{
			info.setError(false);
			info.setMessage("Add new Raw material ");
		}
		else
		{
			
				info.setError(true);
				info.setMessage("Failed add new Raw material ");
			
		}
		return info;
	}

	@Override
	public RawMaterialDetails getRawMaterialDetails(int rmId) {
		
		RawMaterialDetails rawMaterialMaster=RawMaterialDetailsRepository.findByRmId(rmId);
		if(rawMaterialMaster!=null)
		{
			System.out.println("RM  Details : "+rawMaterialMaster.toString());
		}
		else
		{
			System.out.println("Raw material  Not exist");
		}
		return rawMaterialMaster;
	}

	@Override
	public List<RawMaterialDetails> getAllRawMaterial() {
		List<RawMaterialDetails> rawMaterialMasterDetailList=RawMaterialDetailsRepository.findByDelStatus(1);
		if(rawMaterialMasterDetailList!=null)
		{
			System.out.println("RM  Details List : "+rawMaterialMasterDetailList.toString());
		}
		else
		{
			System.out.println("Raw material  Not exist");
		}
		return rawMaterialMasterDetailList;
	}

	@Override
	public Info deleteRawMaterial(int rmId) {
		
		int res=RawMaterialDetailsRepository.deleteRawMaterial(rmId);
	
		Info info=new Info();
		if(res>0)
		{
			info.setError(false);
			info.setMessage("Delete Raw material ");
		}
		else
		{
			
				info.setError(true);
				info.setMessage("Failed delete Raw material ");
			
		}
		return info;
	}

	@Override
	public RmItemCategory getRmItemCategory(int catId) {
		RmItemCategory rmItemCategory=null;
		try {
			rmItemCategory=rmItemCategoryRepository.findRmItemCategoryByCatId(catId);
		}
		catch(Exception e)
		{
			rmItemCategory=new RmItemCategory();
		}
		
		return rmItemCategory;
	}

	@Override
	public RmItemSubCategory getRmItemSubCategory(int subCatId) {
		
		RmItemSubCategory rmItemSubCategory=null;
		try {
			rmItemSubCategory=rmItemSubCategoryRepository.findRmItemSubCategoryBySubCatId(subCatId);
		}
		catch(Exception e)
		{
			rmItemSubCategory=new RmItemSubCategory();
		}
		
		return rmItemSubCategory;
	}

	@Override
	public List<RmItemSubCategory> getRmItemSubCategories(int catId) {
		List<RmItemSubCategory> rmItemSubCategories=null;
		try {
			
			rmItemSubCategories=rmItemSubCategoryRepository.findRmItemSubCategoryByCatId(catId);
	        	
		}
		catch(Exception e)
		{
			rmItemSubCategories=new ArrayList<RmItemSubCategory>();
		}
		
		return rmItemSubCategories;
	}
}
