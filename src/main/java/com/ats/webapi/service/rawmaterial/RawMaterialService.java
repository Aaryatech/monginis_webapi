package com.ats.webapi.service.rawmaterial;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemSubCatList;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;

@Service
public interface RawMaterialService {

	RmItemCatList getRmItemCategories();

	RmItemSubCatList getRmItemSubCategories();

	ErrorMessage saveItemCategory(RmItemCategory rmItemCategory);

	ErrorMessage saveItemSubCategory(RmItemSubCategory rmItemSubCategory);

	ErrorMessage deleteRmItemCategory(int catId);

	ErrorMessage deleteRmItemSubCategory(int subCatId);

	
	
}
