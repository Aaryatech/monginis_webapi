package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ConfigureFranchisee;
//import com.ats.webapi.model.FrMenus;
import com.ats.webapi.model.FrMenus;
import com.ats.webapi.model.FrMenusList;

public interface ConfigureFranchiseeService {
	
	public String configureFranchisee(ConfigureFranchisee configureFranchisee);
	public ConfigureFranchisee findFranchiseeById(int setting_id);
	public ConfigureFranchisee updateFrConfig(int setting_id);
    public List<FrMenus> findFrMenus(int frId);
	public List<Integer> findConfiguredMenuId(int frId);
	
	//23 March
	public int updateFrConfForSelectedFr(List<Integer> frIdList, int menuId,String fromTime,String toTime,int settingType,String date,String day);
	public int updateFrConfForAllFr(int menuId,String fromTime,String toTime,int settingType,String date,String day);
	
	
	//21-6-2019
	public List<ConfigureFranchisee> getDataByFrAndMenu(List<Integer> frIdList,List<Integer> menuIdList);
	public int updateFrConfItems(String items,int settingId);
	
	
}
