package com.ats.webapi.service.rawmaterial;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
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
	
	Info addRawMaterial(RawMaterialDetails rawMaterialMasterDetails);

	RawMaterialDetails getRawMaterialDetails(int rmId);
	
	List<RawMaterialDetails> getAllRawMaterial();
	
	Info deleteRawMaterial(int rmId);
	
	
}
