package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetSubCategory;
@Repository
public interface GetSubCategoryRepository extends JpaRepository<GetSubCategory, Integer>{

	List<GetSubCategory> findByCatIdAndDelStatus(int catId, int i);

}
