package com.ats.webapi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;

@Repository
public interface RmItemSubCategoryRepository extends JpaRepository<RmItemSubCategory, Long>{

	List<RmItemSubCategory> findRmItemSubCategoryByDelStatus(int delStatus);

	RmItemSubCategory findRmItemSubCategoryBySubCatId(int subCatId);
	
	List<RmItemSubCategory> findRmItemSubCategoryByCatId(int catId);

}
