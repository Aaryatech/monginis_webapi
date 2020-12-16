package com.ats.webapi.service;


import com.ats.webapi.model.AllFrIdNameList;

public interface AllFrIdNameService {
	
	AllFrIdNameList getFrIdAndName();
	
	AllFrIdNameList getFranchisesIdAndName();

	AllFrIdNameList findNonOrderFranchisee(String orderDate, int menuId);

	AllFrIdNameList getFrIdAndNameByDelstatus(int i);

	AllFrIdNameList findNonProductionFranchisee(String productionDate, int menuId);
}
