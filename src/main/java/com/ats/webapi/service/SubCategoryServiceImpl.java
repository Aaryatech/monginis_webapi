package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.repository.SubCategoryRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;
	String jsonUser = "{}";

	public String saveSubCategory(SubCategory subCategory) {
		SubCategory subCategory1;
		
		if(subCategory.getSubCatId()!=0||!subCategory.getSubCatName().equalsIgnoreCase("")){
			 subCategory1=subCategoryRepository.findOne(subCategory.getSubCatId());

			if(subCategory.getSubCatName()==""||!subCategory.getSubCatName().equalsIgnoreCase(""))
			{
				subCategory1 = subCategoryRepository.save(subCategory);	

				ErrorMessage errorMessage=new ErrorMessage();
				errorMessage.setError(false);
				errorMessage.setMessage("SubCategory Inserted Successfully");
				jsonUser = JsonUtil.javaToJson(errorMessage);

			}
	else
	{
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setError(true);
		errorMessage.setMessage("SubCategory already exist");
		jsonUser = JsonUtil.javaToJson(errorMessage);
	
	}
	}
		else
		{
			ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("SubCategory fields are empty");
			jsonUser = JsonUtil.javaToJson(errorMessage);
		
		}
		return jsonUser;
	}
	
	
	public SubCategory findSubCategory(int subCatId) {
		SubCategory subCategory=subCategoryRepository.findOne(subCatId);
		return subCategory;
	}
	
	public SubCatergoryList findAllSubCategories() {
		
		    List<SubCategory> subCategories=new ArrayList<SubCategory>();
			ErrorMessage errorMessage=new ErrorMessage();
			SubCatergoryList subCategoryList=new SubCatergoryList();
			
		subCategories=subCategoryRepository.findByDelStatus(0);
		if(subCategories!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All SubCategories displayed successfully");
			subCategoryList.setErrorMessage(errorMessage);
			subCategoryList.setSubCategory(subCategories);
			
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("SubCategories Not Found");
			subCategoryList.setErrorMessage(errorMessage);
		}
		
		return subCategoryList;
	}


	@Override
	public List<SubCategory> findSubCategoryByCatId(int catId) {
		  List<SubCategory> subCategoryList=subCategoryRepository.findSubCategoryByCatId(catId);
		return subCategoryList;
	}


	@Override
	public List<SubCategory> getAllSubCategory() {
		List<SubCategory> allSubCategory=subCategoryRepository.findByDelStatus(0);

		return allSubCategory;
	}

}
