package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.AllMenuJsonResponse;
import com.ats.webapi.model.AllMenus;

public interface MenuService {
	public List<AllMenus> findAllMenus();
	public String saveMenuConfigurationPage(AllMenus menuConfigurationPage);
	public AllMenuJsonResponse findAllMenu();
	public AllMenuJsonResponse findMenuByCat(int catId);
	public AllMenus findMenu(int menuId);

	
	public List<AllMenus> findByCatIdAndIsSameDayApp(int catId,int isSameDayAppl);
	public List<AllMenus> findByCatIdAndIsSameDayAppAndDelStatus(int catId,int isSameDayAppl,int delStatus);
}
