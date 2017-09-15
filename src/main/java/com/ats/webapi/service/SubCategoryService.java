package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.SubCategory;

public interface SubCategoryService {
	
	public SubCategory findSubCategory(int subCatId);
	public String saveSubCategory(SubCategory subCategory);
	public SubCatergoryList findAllSubCategories();
	public List<SubCategory> getAllSubCategory();
	public List<SubCategory> findSubCategoryByCatId(int catId);

}
